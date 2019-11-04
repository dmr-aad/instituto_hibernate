
package pojos;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Date;

/**
 *
 * @author a18danielmr
 */
public class Uso implements Serializable{
    
    private Date fecha;
    private Time hora;
    private Ciclo ciclo;
    private Taller taller;

    public Uso() {
    }

    public Uso(Date fecha, Time hora) {
        this.fecha = fecha;
        this.hora = hora;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public Taller getTaller() {
        return taller;
    }

    public void setTaller(Taller taller) {
        this.taller = taller;
    }
    
    
}
