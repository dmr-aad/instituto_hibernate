package metodos;

import institutoshibernate.NewHibernateUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.Ciclo;
import pojos.Instituto;
import pojos.Uso;

/**
 *
 * @author a18danielmr
 */
public class Listados {

    public static void main(BufferedReader lee) throws IOException, ParseException {
        int op = Menu.listados(lee);
        switch (op) {
            case 1:
                usos(lee);
                break;
            case 2:
                ciclos(lee);
                break;
            case 3:
                institutos(lee);
                break;
            case 0:
                System.out.println("SALIENDO...");
                break;
        }
    }
    
    public static void usos(BufferedReader lee) throws IOException, ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Introduce una fecha (dd/mm/aaaa)");
        String fecha = lee.readLine();
        Date parsed = format.parse(fecha);
        java.sql.Date fechasql = new java.sql.Date(parsed.getTime());
        System.out.println("Introduce una hora (hh:mm:ss)");
        String hora = lee.readLine();
        java.sql.Time horasql = null;
        horasql = horasql.valueOf(hora);
        Session sesion;
        Uso u;
        try {
            sesion = NewHibernateUtil.getSession();
            List<Uso> usos = sesion.createCriteria(Uso.class).list();
            int n = 1;
            for (Uso uso : usos) {
                if (uso.getFecha().equals(fechasql) && uso.getHora().equals(horasql)) {
                    System.out.println(n + " -> Ciclo: " + uso.getCiclo().getNom_ciclo() + " // Taller: " + uso.getTaller().getNom_taller());
                    n++;
                }
            }
            System.out.println("******************************************************");
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void ciclos(BufferedReader lee) throws IOException {
        int cod_insti;
        Instituto i;
        boolean existe = Visualizar.visualizarInstitutos();
        if (existe) {
            do {
                System.out.println("Introduce el codigo del instituto:");
                cod_insti = Integer.parseInt(lee.readLine());
                i = Comprobaciones.comprobarInsti(cod_insti);
                if (i == null) {
                    System.out.println("No hay ningún instituto con ese código registrado");
                }
            } while (i == null);
            try {
                Session sesion;
                sesion = NewHibernateUtil.getSession();
                List <Ciclo> ciclos = sesion.createCriteria(Ciclo.class).list();
                int n = 1;
                for (Ciclo ciclo : ciclos) {
                    System.out.println(n + " -> " + ciclo.getNom_ciclo());
                    n++;
                }
            } catch (HibernateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void institutos(BufferedReader lee) throws IOException {
        int cod_ciclo;
        Ciclo c;
        boolean existe = Visualizar.visualizarCiclos();
        if (existe) {
            do {
                System.out.println("Introduce el codigo del ciclo:");
                cod_ciclo = Integer.parseInt(lee.readLine());
                c = Comprobaciones.comprobarCiclo(cod_ciclo);
                if (c == null) {
                    System.out.println("No hay ningún ciclo con ese código registrado");
                }
            } while (c == null);
            Session sesion;
            try {
                sesion = NewHibernateUtil.getSession();
                List<Instituto> institutos = sesion.createCriteria(Instituto.class).list();
                int n = 1;
                for (Instituto instituto : institutos) {
                    System.out.println(n + " -> " + instituto.getNom_insti());
                    n++;
                }
                sesion.close();
            } catch (HibernateException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
