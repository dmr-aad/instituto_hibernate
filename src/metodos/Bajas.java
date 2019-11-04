package metodos;

import institutoshibernate.NewHibernateUtil;
import java.io.BufferedReader;
import java.io.IOException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.Ciclo;
import pojos.Taller;

/**
 *
 * @author a18danielmr
 */
public class Bajas {
    
    public static void main(BufferedReader lee) throws IOException {
        int op = Menu.bajas(lee);
        switch (op) {
            case 1:
                ciclo(lee);
                break;
            case 2:
                taller(lee);
                break;
            case 0:
                System.out.println("SALIENDO...");
                break;
        }
    }

    public static void ciclo(BufferedReader lee) throws IOException {
        int cod_ciclo, op;
        Ciclo c;
        do {
            boolean existe = Visualizar.visualizarCiclos();
            if (existe) {
                do {
                    System.out.println("Introduce el código del ciclo:");
                    cod_ciclo = Integer.parseInt(lee.readLine());
                    c = Comprobaciones.comprobarCiclo(cod_ciclo);
                    if (c == null) {
                        System.out.println("No hay ningún ciclo con ese código registrado");
                    }
                } while (c == null);
                op = Menu.confirmacion(lee, "¿Está seguro de que desea borrar este ciclo?");
                if (op == 1) {
                    eliminar(c);
                } else {
                    System.out.println("Baja cancelada");
                }
            }
            op = Menu.confirmacion(lee, "¿Desea dar de baja otro ciclo?");
        } while (op == 1);
    }
    
    public static void taller(BufferedReader lee) throws IOException {
        int cod_taller, op;
        Taller t;
        do {
            boolean existe = Visualizar.visualizarTalleres();
            if (existe) {
                do {
                    System.out.println("Introduce el código del taller:");
                    cod_taller = Integer.parseInt(lee.readLine());
                    t = Comprobaciones.comprobarTaller(cod_taller);
                    if (t == null) {
                        System.out.println("No hay ningún taller con ese código registrado");
                    }
                } while (t == null);
                op = Menu.confirmacion(lee, "¿Está seguro de que desea borrar este taller?");
                if (op == 1) {
                    eliminar(t);
                } else {
                    System.out.println("Baja cancelada");
                }
            }
            op = Menu.confirmacion(lee, "¿Desea dar de baja otro taller?");
        } while (op == 1);
    }

    public static void eliminar(Object objeto) {
        Session sesion;
        try {
            sesion = NewHibernateUtil.getSession();
            sesion.beginTransaction();
            sesion.delete(objeto);
            sesion.getTransaction().commit();
            sesion.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }
}
