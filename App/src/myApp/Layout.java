package myApp;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import pojo.Days;
import pojo.TableDataChanged;

import db.dbHandler;

public class Layout extends JFrame {

	private dbHandler db;
	private DefaultTableModel days;
	private JTable tabel;
	private Map<TableDataChanged, Object> hash;
	private  Object value ;

	public Layout() {
		super("Layout");
		hash = new HashMap<TableDataChanged, Object>();
		JTabbedPane tabs = new JTabbedPane();
		JPanel mainPanel = new JPanel();
		db = new dbHandler("sincez10", "sincez10");
		// mainPanel.add(createButtonRow());
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(makeTable(), BorderLayout.NORTH);
		mainPanel.add(Buttons(), BorderLayout.WEST);

		tabs.addTab("Main", mainPanel);

		getContentPane().add(tabs, BorderLayout.CENTER);
		setSize(800, 600);
		setVisible(true);
		
		
	}

	private JPanel Buttons() {
		JButton btnNew = new JButton("Ny rad");
		JButton btnSave = new JButton("Lagre");
		JButton btnDelete = new JButton("Slett");
		JPanel pane = new JPanel();
		pane.add(btnNew);
		pane.add(btnSave);
		pane.add(btnDelete);

		btnNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				db.insert();
			

			}
		});

		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = tabel.getSelectedRow();
				db.delete(row);
				makeTable();
			}

		});
		
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Set<Entry<TableDataChanged, Object>> entries = hash.entrySet();
				Iterator it = entries.iterator();
				
				while (it.hasNext()){
					Map.Entry<TableDataChanged, Object> entry = (Entry<TableDataChanged, Object>) it.next();
					it.remove();
					db.update(entry.getKey().getNameOfColumn(), entry.getValue().toString(), entry.getKey().getRow());
					//System.out.println(entry.getKey().getNameOfColumn() + "--->" + entry.getValue().toString());
					}
				
			}
		});

		return pane;

	}

	private JPanel makeTable() {

		days = new DefaultTableModel();
		ArrayList<String> metaData = db.getMetaData("diary");

		for (int i = 0; i < metaData.size(); i++) {
			days.addColumn(metaData.get(i).toString().toUpperCase());
		}
		ArrayList<Days> daysList = db.getTable("diary");
		for (int i = 0; i < daysList.size(); i++) {
			String[] book = { daysList.get(i).getAuthor(),
					daysList.get(i).getTitle(), daysList.get(i).getId(),
					daysList.get(i).getPages(), daysList.get(i).getYear(),
					daysList.get(i).getSyrke(), daysList.get(i).getTennis() };
			days.addRow(book);
		}

		tabel = new JTable(days);
		tabel.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				
				int row = e.getFirstRow();
		        int column = e.getColumn();
		        TableModel model = (TableModel)e.getSource();
		        String columnName = model.getColumnName(column);
		        value = model.getValueAt(row, column);
		        
		        TableDataChanged key = new TableDataChanged(row, column, columnName);
		        
		        hash.put(key, value);
		       
		      

				
			}
		});

		tabel.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					JTable target = (JTable) e.getSource();
					int row = target.getSelectedRow();

					int column = target.getSelectedColumn();
					

				}
			}
		});

		JPanel pane = new JPanel();

		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		pane.add(new JLabel("Tabell "));
		pane.add(new JScrollPane(tabel));
		pane.setAlignmentY(TOP_ALIGNMENT);

		return pane;

	}

	public static void main(String[] args) {
		Layout app = new Layout();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
