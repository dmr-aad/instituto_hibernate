package metodos;

import institutoshibernate.NewHibernateUtil;
import java.sql.Time;
import java.sql.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.*;

/**
 *
 * @author a18danielmr
 */
public class Comprobaciones {

    public static Instituto comprobarInsti(int cod_insti) {

        Session sesion;
        Instituto i = null;
        try {
            sesion = NewHibernateUtil.getSession();
            i = (Instituto) sesion.get(Instituto.class, cod_insti);
            sesion.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return i;
    }

    public static Ciclo comprobarCiclo(int cod_ciclo) {

        Session sesion;
        Ciclo c = null;
        try {
            sesion = NewHibernateUtil.getSession();
            c = (Ciclo) sesion.get(Ciclo.class, cod_ciclo);
            sesion.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return c;
    }

    public static Taller comprobarTaller(int cod_taller) {

        Session sesion;
        Taller t = null;
        try {
            sesion = NewHibernateUtil.getSession();
            t = (Taller) sesion.get(Taller.class, cod_taller);
            sesion.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return t;
    }

    /* SESION.GET RECIBE 2 VALORES AL SER CLAVE COMPUESTA
    public static Uso comprobarUso(Date fecha, Time hora) {
        
        Session sesion;
        Uso u = null;
        try {
            sesion = NewHibernateUtil.getSession();
            u = (Uso) sesion.get(Uso.class, )
        }
    }
     */
    public static Uso comprobarUso(Date fecha, Time hora, int cod_taller, int cod_ciclo) {

        Session sesion;
        Uso u = null;
        try {
            sesion = NewHibernateUtil.getSession();
            List<Object> usos = sesion.createCriteria(Uso.class).list();
            sesion.close();
            if (!usos.isEmpty()) {
                for (Object uso : usos) {
                    if (fecha == ((Uso) uso).getFecha()
                            && hora == ((Uso) uso).getHora()
                            && cod_taller == ((Uso) uso).getTaller().getCod_taller()
                            && cod_ciclo == ((Uso) uso).getCiclo().getCod_ciclo()) {
                        u = (Uso) uso;
                    } else {
                        System.out.println("No se encuentra coincidencia");
                    }
                }
            } else {
                System.out.println("No hay ningún uso registrado");
            }
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return u;
    }
}
