package gui;

// Fig. 14.20: GridBagDemo2.java
// Demonstrating GridBagLayout constants.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GridBagDemo2 extends JFrame { 
   private GridBagLayout layout;
   private GridBagConstraints constraints;
   private Container container;
    
   // set up GUI
   public GridBagDemo2()
   {
      super( "GridBagLayout" );

      container = getContentPane();
      layout = new GridBagLayout();
      container.setLayout( layout );   

      // instantiate gridbag constraints
      constraints = new GridBagConstraints();

      // create GUI components
      String metals[] = { "Copper", "Aluminum", "Silver" };
      JComboBox comboBox = new JComboBox( metals );

      JTextField textField = new JTextField( "TextField" );

      String fonts[] = { "Serif", "Monospaced" };
      JList list = new JList( fonts );

      String names[] = { "zero", "one", "two", "three", "four" };
      JButton buttons[] = new JButton[ names.length ];

      for ( int count = 0; count < buttons.length; count++ )
         buttons[ count ] = new JButton( names[ count ] );

      // define GUI component constraints for textField
      constraints.weightx = 1;
      constraints.weighty = 1;  
      constraints.fill = GridBagConstraints.BOTH;
      constraints.gridwidth = GridBagConstraints.REMAINDER;
      //REMAINDER specifies that this component is the last
      //component in its column or row
      addComponent( textField );

      // buttons[0] -- weightx and weighty are 1: fill is BOTH
      constraints.gridwidth = 1;
      addComponent( buttons[ 0 ] );

      // buttons[1] -- weightx and weighty are 1: fill is BOTH
      constraints.gridwidth = GridBagConstraints.RELATIVE;
      //Specifies that this component is the next-to-last component
      //in its column or row (gridwidth, gridheight), or that this
      //component be placed next to the previously added component
      //(gridx, gridy).
      addComponent( buttons[ 1 ] );

      // buttons[2] -- weightx and weighty are 1: fill is BOTH
      constraints.gridwidth = GridBagConstraints.REMAINDER;
      addComponent( buttons[ 2 ] );

      // comboBox -- weightx is 1: fill is BOTH
      constraints.weighty = 0;
      constraints.gridwidth = GridBagConstraints.REMAINDER;
      addComponent( comboBox );
      
      // buttons[3] -- weightx is 1: fill is BOTH
      constraints.weighty = 1;
      constraints.gridwidth = GridBagConstraints.REMAINDER;
      addComponent( buttons[ 3 ] ); 

      // buttons[4] -- weightx and weighty are 1: fill is BOTH
      constraints.gridwidth = GridBagConstraints.RELATIVE;
      addComponent( buttons[ 4 ] );

      // list -- weightx and weighty are 1: fill is BOTH
      constraints.gridwidth = GridBagConstraints.REMAINDER;
      addComponent( list );

      setSize( 300, 200 );
      setVisible( true );
  
   }  // end constructor

   // add a component to the container
   private void addComponent( Component component ) 
   {
      layout.setConstraints( component, constraints );
      container.add( component );      // add component
   }   

   public static void main( String args[] )
   {
      GridBagDemo2 application = new GridBagDemo2();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

}  // end class GridBagDemo2
