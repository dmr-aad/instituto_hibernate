
package metodos;

import institutoshibernate.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.*;

/**
 *
 * @author a18danielmr
 */
public class Visualizar {
    
    public static boolean visualizarInstitutos() {
        try{
            Session sesion;
            sesion = NewHibernateUtil.getSession();
            //Guarda en una lista los datos de los departamentos añadidos
            List<Object> institutos = sesion.createCriteria(Instituto.class).list();
            sesion.close();
            //Si la lista no está vacia
            if (!institutos.isEmpty()) {
                System.out.println("cod_insti\t\tnom_insti\t\ttlfn");
                for (Object instituto : institutos) {
                    System.out.println(((Instituto) instituto).getCod_insti() + "\t\t" + ((Instituto) instituto).getNom_insti()+ "\t\t" + ((Instituto) instituto).getTlfn());
                }
                return true;
            } else {
                System.out.println("No hay institutos");
                return false;
            }
        } catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return true;
    }
    
    public static boolean visualizarCiclos() {
        try{
            Session sesion;
            sesion = NewHibernateUtil.getSession();
            //Guarda en una lista los datos de los departamentos añadidos
            List<Object> ciclos = sesion.createCriteria(Ciclo.class).list();
            sesion.close();
            //Si la lista no está vacia
            if (!ciclos.isEmpty()) {
                System.out.println("cod_ciclo\t\tnom_ciclo");
                for (Object ciclo : ciclos) {
                    System.out.println(((Ciclo) ciclo).getCod_ciclo() + "\t\t" + ((Ciclo) ciclo).getNom_ciclo()+ "\t\t");
                }
                return true;
            } else {
                System.out.println("No hay ciclos");
                return false;
            }
        } catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return true;
    }
    
    public static boolean visualizarTalleres() {
        try{
            Session sesion;
            sesion = NewHibernateUtil.getSession();
            //Guarda en una lista los datos de los departamentos añadidos
            List<Object> talleres = sesion.createCriteria(Taller.class).list();
            sesion.close();
            //Si la lista no está vacia
            if (!talleres.isEmpty()) {
                System.out.println("cod_taller\t\tnom_taller");
                for (Object taller : talleres) {
                    System.out.println(((Taller) taller).getCod_taller() + "\t\t" + ((Taller) taller).getNom_taller());
                }
                return true;
            } else {
                System.out.println("No hay talleres");
                return false;
            }
        } catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return true;
    }
    
    public static boolean visualizarUsos() {
        try{
            Session sesion;
            sesion = NewHibernateUtil.getSession();
            //Guarda en una lista los datos de los departamentos añadidos
            List<Object> usos = sesion.createCriteria(Uso.class).list();
            sesion.close();
            //Si la lista no está vacia
            if (!usos.isEmpty()) {
                System.out.println("fecha\t\thora");
                for (Object uso : usos) {
                    System.out.println(((Uso) uso).getFecha() + "\t\t" + ((Uso) uso).getHora());
                }
                return true;
            } else {
                System.out.println("No hay usos");
                return false;
            }
        } catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return true;
    }
}
