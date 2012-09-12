/*
 * KundeSystem.java
 *
 * Created on 5. juni 2005, 22:06
 */

package oveing;

import javax.swing.*;
/**
 *
 * @author  Kjell Dirdal
 */
public class KundeSystem {
    /** Creates a new instance of KundeSystem */
    public KundeSystem() {
        
    }
 
    public static void main( String[] args ){
        KundeController kundeCtr = new KundeController();
        
        kundeCtr.getKundeAntallView();
        
        kundeCtr.getKundeEndringsView();
        
        kundeCtr.getKundeLogView();
        
        JOptionPane.showMessageDialog(null,"Tre view registrert mot modellen" +
            "\nViewene vil varsles om endringer i modellen");

        kundeCtr.registrerNyKunde( new KundeVO( "Ola", "Aveien 1"));
        
        kundeCtr.registrerNyKunde( new KundeVO( "Eli", "Aveien 10"));
        
        kundeCtr.registrerNyKunde( new KundeVO( "Ole", "Bveien 7"));
        
        kundeCtr.endreKunde( 2, new KundeVO( "Per", "Bveien 7"));
        
        kundeCtr.fjernKunde( "Eli" );
        
        kundeCtr.fjernKunde( "Ola" );
        
    }
}
