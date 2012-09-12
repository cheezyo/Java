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
public class KundeEvent extends java.util.EventObject{
    private int endretIndex;
    
    /** Creates a new instance of KundeEvent */
    public KundeEvent(Object kilde, int endretIndeks ) {
        super(kilde);
        endretIndex = endretIndeks;
    }
    
    public int getEndretIndex(){
        return endretIndex;
    }
}
