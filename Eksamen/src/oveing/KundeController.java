/*
 * KundeController.java
 *
 * Created on 5. juni 2005, 21:57
 */

package oveing;

/**
 *
 * @author  Kjell Dirdal
 */
public class KundeController {
    private KundeRegister kundereg;
    
    /** Creates a new instance of KundeController */
    public KundeController() {
        kundereg = new KundeRegister();
    }
    
    public void registrerNyKunde( KundeVO kunde ){
        kundereg.registrerNyKunde(kunde);
    }
    
    public KundeVO finnKunde( int index ){
        return kundereg.finnKunde(index);
    }
    
    public KundeVO finnKunde( String navn){
        return kundereg.finnKunde(navn);
    }
    
    public KundeVO fjernKunde( String navn ){
        return kundereg.fjernKunde(navn);
    }
    
    public int getAntallKunder(){
        return kundereg.getAntallKunder();
    }
    
    public void endreKunde( int index, KundeVO kunde ){
        kundereg.oppdaterKunde( index, kunde ); 
    }
    
    public KundeAntallView getKundeAntallView(){
        return new KundeAntallView(kundereg);
    }
    
    public KundeEndringsView getKundeEndringsView(){
        return new KundeEndringsView( kundereg );
    }
    
    public KundeLogView getKundeLogView(){
        return new KundeLogView( kundereg );
    }
}
