/*
 * KundeRegister.java
 *
 * Created on 5. juni 2005, 21:00
 */

package oveing;

import java.util.ArrayList;
/**
 *
 * @author  Kjell Dirdal
 */
public class KundeRegister implements KundeModell{
    private ArrayList<KundeVO> kundeliste;
    private ArrayList<KundeListener> kundelyttere;
    
    /** Creates a new instance of KundeRegister */
    public KundeRegister() {
        kundeliste = new ArrayList<KundeVO>();
        kundelyttere = new ArrayList<KundeListener>();
    }
    
    public synchronized void addKundeListener(KundeListener l) {
        if( kundelyttere.contains(l)){
            return;
        }
        kundelyttere.add(l);
    }
    
    public java.util.ArrayList<KundeVO> getAlleKunder() {
        return (ArrayList<KundeVO>) kundeliste.clone();
    }
    
    public int getAntallKunder() {
        return kundeliste.size();
    }
    
    public KundeVO finnKunde(int index) {
        if( index < kundeliste.size()){
            return (KundeVO)kundeliste.get(index);
        }
        return null;
    }
    
    public KundeVO finnKunde(String navn) {
        int pos = finnKundePosisjon(navn);
        if( pos >= 0 ){
            return (KundeVO) kundeliste.get(pos);
        }
        return null;
    }
    
    public KundeVO fjernKunde(String navn) {
        KundeVO fjernetKunde = null;
        int pos = finnKundePosisjon( navn );
        if( pos >= 0 ){
            fjernetKunde = (KundeVO) kundeliste.remove(pos);
            fireKundeFjernet(pos);
        }
        return fjernetKunde;
    }
    
    public KundeVO oppdaterKunde(int index, KundeVO kundeVO) {
        KundeVO gammelKunde = null;
        gammelKunde = (KundeVO) kundeliste.set(index, kundeVO);
        fireKundeEndret( index );
        return gammelKunde;
    }
    
    public void registrerNyKunde(KundeVO kundeVO) {
        kundeliste.add( kundeVO );
        fireKundeRegistrert( kundeliste.size()-1);
    }
    
    public synchronized void removeKundeListener(KundeListener l) {
        kundelyttere.remove(l);
    }
    
    private int finnKundePosisjon(String navn){
        int antall = kundeliste.size();
        for( int i = 0; i < antall; i++ ){
            KundeVO vo = (KundeVO) kundeliste.get(i);
            if( vo.getNavn().equals( navn )){
                return i;
            }
        }
        return -1;
    }
    
    private void fireKundeRegistrert(int indeks) {
        ArrayList<KundeListener> snapshot;
        synchronized(this){
            snapshot = (ArrayList<KundeListener>) kundelyttere.clone();
            int antall = snapshot.size();
            if( antall == 0 ){
                return;
            }
            
            KundeEvent event = new KundeEvent( this, indeks );
            for( int i = 0; i < antall; i++ ){
                KundeListener l = (KundeListener) kundelyttere.get(i);
                l.kundeRegistrert( event );
            }
        }
    }
    
    private void fireKundeFjernet(int indeks) {
        ArrayList<KundeListener> snapshot;
        synchronized(this){
            snapshot = (ArrayList<KundeListener>) kundelyttere.clone();
            int antall = snapshot.size();
            if( antall == 0 ){
                return;
            }
            
            KundeEvent event = new KundeEvent( this, indeks );
            for( int i = 0; i < antall; i++ ){
                KundeListener l = (KundeListener) kundelyttere.get(i);
                l.kundeFjernet( event );
            }
        }
    }
    
    private void fireKundeEndret(int indeks) {
        ArrayList<KundeListener> snapshot;
        synchronized(this){
            snapshot = (ArrayList<KundeListener>) kundelyttere.clone();
            int antall = snapshot.size();
            if( antall == 0 ){
                return;
            }
            
            KundeEvent event = new KundeEvent( this, indeks );
            for( int i = 0; i < antall; i++ ){
                KundeListener l = (KundeListener) kundelyttere.get(i);
                l.kundeEndret( event );
            }
        }
    }
}
