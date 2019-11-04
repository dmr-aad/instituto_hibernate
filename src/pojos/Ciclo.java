
package pojos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author a18danielmr
 */
public class Ciclo implements Serializable{
    
    private int cod_ciclo;
    private String nom_ciclo;
    private Set<Instituto> institutos;
    private Set<Uso> usos;

    public Ciclo() {
    }

    public Ciclo(String nom_ciclo) {
        this.nom_ciclo = nom_ciclo;
        this.institutos = new HashSet<>();
        this.usos = new HashSet<>();
    }

    public int getCod_ciclo() {
        return cod_ciclo;
    }

    public void setCod_ciclo(int cod_ciclo) {
        this.cod_ciclo = cod_ciclo;
    }

    public String getNom_ciclo() {
        return nom_ciclo;
    }

    public void setNom_ciclo(String nom_ciclo) {
        this.nom_ciclo = nom_ciclo;
    }

    public Set<Instituto> getInstitutos() {
        return institutos;
    }

    public void setInstitutos(Set<Instituto> institutos) {
        this.institutos = institutos;
    }

    public Set<Uso> getUsos() {
        return usos;
    }

    public void setUsos(Set<Uso> usos) {
        this.usos = usos;
    }

    
    
    
    
}
