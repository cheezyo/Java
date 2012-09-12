/*
 * KundeEndringsView.java
 *
 * Created on 5. juni 2005, 21:36
 */

package oveing;

import javax.swing.JOptionPane;
/**
 *
 * @author  Kjell Dirdal
 */
public class KundeEndringsView implements KundeListener{
    
    public KundeEndringsView(KundeModell kReg){
        kReg.addKundeListener( this );        
    }
    
    public void kundeRegistrert( KundeEvent kundeEvent ){
        
    }
    
    public void kundeEndret( KundeEvent kundeEvent ){
        int endretIndex = kundeEvent.getEndretIndex();
        KundeModell kundeRegister = (KundeModell) kundeEvent.getSource();
        String melding = "KundeendringsView Kunde endret ved index " + endretIndex;
        
        KundeVO endretKunde = kundeRegister.finnKunde( endretIndex );
        melding = melding + "\nKundeEndringsview. Ny kundeInfo: " + endretKunde.toString();
        
        JOptionPane.showMessageDialog( null, melding );
    }
    
    public void kundeFjernet( KundeEvent kundeEvent ){
        
    }
}
