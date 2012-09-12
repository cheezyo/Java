package xmlParsing;



import java.io.File;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * Simple parsing of XML documents
 * @author anders
 */
public class XMLParsing {

    public static void main(String[] args) throws Exception {
        new XMLParsing("C:/Java_Programmering/XML/src/xmlParsing/skole.xml");
    }
    
    public XMLParsing(String filename) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        dbf.setValidating(true);
        dbf.setIgnoringElementContentWhitespace(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        db.setErrorHandler(new ErrorHandler() { // bruker anonymous inner class

            @Override
            public void warning(SAXParseException saxpe) throws SAXException {
                System.out.println("Warning reported: " + saxpe.getMessage());
            }

            @Override
            public void error(SAXParseException saxpe) throws SAXException {
                System.out.println("Error reported: " + saxpe.getMessage());
            }

            @Override
            public void fatalError(SAXParseException saxpe) throws SAXException {
                System.out.println("Fatal error  reported: " + saxpe.getMessage());
            }
            
        });
        Document doc = db.parse(new File(filename));
        Element docEl1 = doc.getDocumentElement();
        dumpElement(docEl1);
        String xmlStr = serializeDocument(doc);
        System.out.println(xmlStr);
    }
        

    public String serializeDocument(Document doc) {    
        try
        {
          // Set up the output transformer
          TransformerFactory transfac = TransformerFactory.newInstance();
          Transformer trans = transfac.newTransformer();
          trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
          trans.setOutputProperty(OutputKeys.INDENT, "yes");
          
          // Print the DOM node
          StringWriter sw = new StringWriter();
          StreamResult result = new StreamResult(sw);
          DOMSource source = new DOMSource(doc);
          trans.transform(source, result);
          return sw.toString();
        }
        catch (TransformerException e)
            { e.printStackTrace(); }
        return null;
    }
    
    private void dumpElement(Element el)  {
    	
        NodeList nl = el.getChildNodes();
        for (int i=0; i<nl.getLength(); i++) {
            Node n = nl.item(i);
            System.out.print("Nodename=" + n.getNodeName());
            System.out.println(", Nodevalue=" + n.getNodeValue());
            if (n instanceof Element) {
                // Dump attributtene også
                NamedNodeMap nm = n.getAttributes(); // null if n is not element
                for (int j=0; j<nm.getLength(); j++) {
                    Attr xAttr = (Attr)nm.item(j);
                    String attrName = xAttr.getName();
                    String attrValue = xAttr.getValue();
                    System.out.println("Attribute: " + attrName + "=" + attrValue);
                }
                // Going recursive
                dumpElement((Element)n);
                
            }
        }
    }
    
    private void buildDocument(Document doc) {
        Element docElement = doc.createElement("rotNode");
        Node n = doc.createTextNode("Dette er tekst");
        docElement.appendChild(n);
        Element el = doc.createElement("barn1");
        el.setAttribute("level", "medium");
        n = doc.createTextNode("Dette er mer tekst");
        el.appendChild(n);
        docElement.appendChild(el);
        doc.appendChild(docElement);
    }
    
    private void buildNSDocument(Document doc) {
        Element docElement = doc.createElementNS("http://fongen.no/xxx", "def");
        doc.appendChild(docElement);
    }
    
    private void stealElements(Document from, Document to) {
        to.appendChild(to.createElement("barn0"));
        NodeList nl = from.getElementsByTagName("barn1");
        Node el = nl.item(0);
        if (el == null) System.out.println("Element er null!");
        
        // Her kopieres et "subtre" til et annet dokument
        Node n = to.importNode(el, true);
        to.getDocumentElement().appendChild(n);
    }
}
