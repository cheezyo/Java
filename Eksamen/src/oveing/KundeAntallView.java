/*
 * KundeAntallView.java
 *
 * Created on 5. juni 2005, 21:51
 */

package oveing;

/**
 *
 * @author  Kjell Dirdal
 */
public class KundeAntallView extends KundeAdapter{
    
    /** Creates a new instance of KundeAntallView */
    public KundeAntallView(KundeModell kReg) {
        kReg.addKundeListener( this );
    }
    
    public void kundeFjernet( KundeEvent event ){
        KundeModell kundeRegister = (KundeModell) event.getSource();
        javax.swing.JOptionPane.showMessageDialog(null, 
        "KundeAntallView- kunde er fjernet: " +
        kundeRegister.getAntallKunder() + " kunder igjen" );
    }
    
    public void kundeRegistrert( KundeEvent event ){
        KundeModell kundeRegister = (KundeModell) event.getSource();
        javax.swing.JOptionPane.showMessageDialog(null, 
        "KundeAntallView- kunde er registrert: " +
        kundeRegister.getAntallKunder() + " antall kunder" );
    }
    
}
