
package pojos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author a18danielmr
 */
public class Taller implements Serializable{
    
    private int cod_taller;
    private String nom_taller;
    private Instituto instituto;
    private Set<Uso> usos;

    public Taller() {
    }

    public Taller(String nom_taller) {
        this.nom_taller = nom_taller;
        this.usos = new HashSet<>();
    }

    public int getCod_taller() {
        return cod_taller;
    }

    public void setCod_taller(int cod_taller) {
        this.cod_taller = cod_taller;
    }

    public String getNom_taller() {
        return nom_taller;
    }

    public void setNom_taller(String nom_taller) {
        this.nom_taller = nom_taller;
    }

    public Instituto getInstituto() {
        return instituto;
    }

    public void setInstituto(Instituto instituto) {
        this.instituto = instituto;
    }

    public Set<Uso> getUsos() {
        return usos;
    }

    public void setUsos(Set<Uso> usos) {
        this.usos = usos;
    }  
}
