
package pojos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author a18danielmr
 */
public class Instituto implements Serializable{
    
    private int cod_insti;
    private String nom_insti;
    private int tlfn;
    private Set<Ciclo> ciclos;
    private Set<Taller> talleres;

    public Instituto() {
    }

    public Instituto(String nom_insti, int tlfn) {
        this.nom_insti = nom_insti;
        this.tlfn = tlfn;
        this.ciclos = new HashSet<>();
        this.talleres = new HashSet<>();
    }

    public String getNom_insti() {
        return nom_insti;
    }

    public void setNom_insti(String nom_insti) {
        this.nom_insti = nom_insti;
    }

    public int getCod_insti() {
        return cod_insti;
    }

    public void setCod_insti(int cod_insti) {
        this.cod_insti = cod_insti;
    }

    public int getTlfn() {
        return tlfn;
    }

    public void setTlfn(int tlfn) {
        this.tlfn = tlfn;
    }

    public Set<Ciclo> getCiclos() {
        return ciclos;
    }

    public void setCiclos(Set<Ciclo> ciclos) {
        this.ciclos = ciclos;
    }

    public Set<Taller> getTalleres() {
        return talleres;
    }

    public void setTalleres(Set<Taller> talleres) {
        this.talleres = talleres;
    }
    
    
}
