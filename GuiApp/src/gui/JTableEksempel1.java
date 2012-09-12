package gui;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class JTableEksempel1 extends JFrame {

    private DefaultTableModel biler;
    private JTable tabell;
    
    /** Creates new BilTabell */
    public JTableEksempel1() {
        super("Alle mine biler");
        
        //opprett et DefaultTableModel-objekt for å lagre bilene
        biler = new DefaultTableModel();
        // lag kolonnene
        biler.addColumn("Merke");
        biler.addColumn("Modell");
        biler.addColumn("Årsmodell");
        //legg inn rader i tabellen (DefaultTableModel)
        String[] bil1 = {"Opel","Omega", "1992"};
        biler.addRow(bil1);
        String[] bil2 = {"Lada","1500", "1982"};
        biler.addRow(bil2);        
        String[] bil3 = {"Mazda","626", "1986"};
        biler.addRow(bil3);    
        String[] bil4 = {"Mazda","323", "1995"};
        biler.addRow(bil4);   
        String[] bil5 = {"VW","Passat", "1999"};
        biler.addRow(bil5);  
        String[] bil6 = {"Merzedes","C180", "1998"};
        biler.addRow(bil6);         
        
        //opprett et JTable-objekt
        tabell = new JTable(biler);
     
        //opprett JButton for å legge til en ny bil
        JButton addButton = new JButton("Legg til en bil");
        addButton.addActionListener(
           new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                   String nyBil[] = {"", "", "" };
                   // legg bilen til tabellen
                   biler.addRow(nyBil);
               }
           }
        );

        //opprett JButton for å fjerne en bil fra tabellen
        JButton removeButton = new JButton("Fjern en bil");
        removeButton.addActionListener(
           new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                   // fjern valgte bil fra listen
                   int rad = tabell.getSelectedRow();
                   if (rad >= 0)
                   	biler.removeRow( rad );
               }
           }
        );  
        
        // legg på GUI komponentene
        JPanel inputPanel = new JPanel();
        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        getContentPane().add(new JScrollPane(tabell),BorderLayout.CENTER);
        getContentPane().add(inputPanel,BorderLayout.SOUTH);

        setSize(400,200);
        setVisible(true);
    }
    public static void main(String[] args) {
		new JTableEksempel1();
	}
    
  

}

