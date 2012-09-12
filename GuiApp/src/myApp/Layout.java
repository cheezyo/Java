package myApp;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Layout extends JFrame {
	JButton btn1, btn2, btn3, btn4;
	public Layout(){
		super("Layout");
	JTabbedPane tabs = new JTabbedPane();
	JPanel mainPanel = new JPanel();
	
	
	
	
	
	//mainPanel.add(createButtonRow());
	mainPanel.add(comboBox());
	
	
	tabs.addTab("Main", mainPanel);
	
		
		
		getContentPane().add(tabs, BorderLayout.WEST);
		setSize(1000,500);
		setVisible(true);
	}
	private JPanel createButtonRow() {
		JButton btn1 = new JButton("Rediger Tabeller");
		JPanel pane = new JPanel();
		
		pane.setLayout(new BorderLayout());
		pane.add(btn1, BorderLayout.WEST);
		
		
		

		return pane;
	}
	
	private JPanel comboBox(){
		JComboBox<String> combo = new JComboBox<String>();
		combo.setMaximumRowCount(4);
		combo.addItem("Studenter");
		
		
		DefaultTableModel persons = new DefaultTableModel();
		
		persons.addColumn("Navn");
		persons.addColumn("Alder");
		persons.addColumn("Bo sted");
		
		String [] person1 ={"Cezar", "25", "Oslo"};
		persons.addRow(person1);
		String [] person2 ={"Jon", "256", "Bergen"};
		persons.addRow(person2);
		
		JTable tabel = new JTable(persons);
		
		
		JPanel pane = new JPanel();
		
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		pane.add(combo);
		pane.add(new JLabel("Tabell "));
		pane.add(tabel);
		pane.setAlignmentY(TOP_ALIGNMENT);
		
		
		
		return pane;
		
	}
	public static void main(String[] args) {
		Layout app = new Layout();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
