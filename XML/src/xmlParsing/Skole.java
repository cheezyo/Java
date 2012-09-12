package xmlParsing;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class Skole {
	
	public static void main(String[] args) throws Exception {
		 new Skole("C:/Java_Programmering/XML/src/xmlParsing/skole.xml");
	}
	
	 public Skole(String filename) throws Exception {
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
	        System.out.println("Fag som finnes: \n");
	        finnFag(docEl1);
	       // System.out.println("Lærere som  finnes \n");
	      //  finnLerer(docEl1);
	        
	       
	    }
	 
	 private void finnFag(Element el)  {
	    	
	        NodeList nl = el.getElementsByTagName("fag");
	        
	        Node nC = null;
	        for (int i=0; i<nl.getLength(); i++) {
	        	Node n = nl.item(i);
	        	
	            
	            //System.out.print("Nodename=" + n.getNodeName());
	            //System.out.println(", Nodevalue=" + n.getNodeValue());
	            if (n instanceof Element) {
	                // Dump attributtene også
	            	//NamedNodeMap nmC = nC.getAttributes();
	                NamedNodeMap nm = n.getAttributes(); 
	                System.out.println("Hoved node: " + n.getNodeName());
	                for (int j=0; j<nm.getLength(); j++) {
	                    Attr xAttr = (Attr)nm.item(j);
	                    String attrName = xAttr.getName();
	                    String attrValue = xAttr.getValue();
	                    System.out.println("Attribute: " + attrName + "=" + attrValue);
	                }
	                
	                if(n.hasChildNodes()){
	                	System.out.println("\n\tBarne noder: ");
	    	        	NodeList child = nl.item(i).getChildNodes(); 
	    	        	
	    	        	for (int l = 0; l < child.getLength();l ++){
	    	        		 nC = child.item(l);
	    	        		System.out.println("\t -"+nC.getNodeName() +":");
	    	        		
	    	        		if(nC.hasAttributes()){
	    	        		NamedNodeMap nmC = nC.getAttributes();
	    	        		
	    	        		for (int m = 0; m < nmC.getLength(); m++){
	    	        			Attr xAttr = (Attr)nmC.item(m);
	    	                    String attrName = xAttr.getName();
	    	                    String attrValue = xAttr.getValue();
	    	                    System.out.println("\tAttribute: " + attrName + "=" + attrValue);
	    	        		}
	    	        		}
	    	        		
	    	        	}
	    	        	System.out.println();
	    	        	}
	                // Going recursive
	                finnFag((Element)n);
	                
	            }
	        
	    	}
	    }
	 
	 /*private void finnLerer(Element el){
		 NodeList nl = el.getElementsByTagName("lærer");
		 for ( int i = 0; i < nl.getLength(); i++){
			 Node n = nl.item(i);
			
			 if(n instanceof Element){
				 NamedNodeMap nm = n.getAttributes();
				 for (int j = 0; j < nm.getLength();j++){
					 Attr xAttr = (Attr)nm.item(i);
					 String attrName = xAttr.getName();
					 String attrValue = xAttr.getValue();
					 System.out.println("Attribute: "+ attrName + " = " + attrValue);
					 
				 }
				 finnLerer((Element)n);
			 }
		 }
	 }*/

}
