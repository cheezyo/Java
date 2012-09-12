/*
 * KundeEvent.java
 *
 * Created on 5. juni 2005, 20:44
 */

package oveing;

/**
 *
 * @author  Kjell Dirdal
 */
public interface KundeListener extends java.util.EventListener{
    
    public void kundeRegistrert( KundeEvent kundeEvent );
    
    public void kundeEndret( KundeEvent kundeEvent );
    
    public void kundeFjernet( KundeEvent kundeEvent );
}
