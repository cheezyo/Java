/*
 * KundeModell.java
 *
 * Created on 5. juni 2005, 20:54
 */

package oveing;

/**
 *
 * @author  Kjell Dirdal
 */
public interface KundeModell {
    public void addKundeListener( KundeListener l );
    
    public void removeKundeListener( KundeListener l );
    
    public void registrerNyKunde( KundeVO kundeVO );
    
    public KundeVO fjernKunde( String navn );
    
    public KundeVO oppdaterKunde( int index, KundeVO kundeVO );
    
    // Finn metoder til bruk for KundeListener
    
    public KundeVO finnKunde( int index );
    
    public KundeVO finnKunde( String navn );
    
    public java.util.ArrayList<KundeVO> getAlleKunder();
    
    public int getAntallKunder();
}
