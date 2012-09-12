package Oppgave3;
/**
 * Innlevering Java oppgave 3
 * Cezar Sincan Johansson
 * 02.02.2012
 */

public class ResultatVO {
    private String fag;
    private int studiepoeng;
    private String dato;
    private char karakter;   
    
    /** Creates a new instance of ResultatVO */
    public ResultatVO(String fag, int sp, String dato, char kar) {
        this.fag = fag;
        this.studiepoeng = sp;
        this.dato = dato;
        this.karakter = kar;
    }
    
    public String getFag() { return this.fag; }
    
    public int getStudiepoeng() { return this.studiepoeng; }    
    
    public String getDato() {  return this.dato;  }
    
    public char getKarakter() { return this.karakter;  }
    
}
