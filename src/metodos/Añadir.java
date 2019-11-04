package metodos;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Time;
import java.sql.Date;
import pojos.Ciclo;
import pojos.Instituto;
import pojos.Taller;
import pojos.Uso;

/**
 *
 * @author a18danielmr
 */
public class Añadir {

    public static void main(BufferedReader lee) throws IOException {

        int op = Menu.añadir(lee);
        switch (op) {
            case 1:
                ciclo(lee);
                break;
            case 2:
                taller(lee);
                break;
            case 3:
                uso(lee);
                break;
            case 0:
                System.out.println("SALIENDO...");
                break;
        }
    }
    
    public static void taller(BufferedReader lee) throws IOException {
        int op;
        Taller t;
        Instituto i;
        int cod_insti, cod_taller;
        A: do {
            boolean existeInsti = Visualizar.visualizarInstitutos();
            if (existeInsti) {
                do {
                    System.out.println("Introduce el código del instituto:");
                    cod_insti = Integer.parseInt(lee.readLine());
                    i = Comprobaciones.comprobarInsti(cod_insti);
                    if (i == null) {
                        System.out.println("No existe ningún instituto con ese código");
                    }
                } while (i == null);
                do{
                    boolean existeTaller = Visualizar.visualizarTalleres();
                    if (existeTaller) {
                        do {
                            System.out.println("Introduce el código del taller");
                            cod_taller = Integer.parseInt(lee.readLine());
                            t = Comprobaciones.comprobarTaller(cod_taller);
                            if (t == null) {
                                System.out.println("No existe ningún taller con ese código");
                            }
                        }while(t == null);
                        i.getTalleres().add(t);
                        Altas.guardarModificar(i);
                    } else {
                        break A;
                    }
                    op = Menu.confirmacion(lee, "¿Desea añadir más talleres a este instituto?");
                }while(op == 1);
            } else {
                break;
            }
            op = Menu.confirmacion(lee, "¿Desea añadir talleres a otro instituto?");
        }while(op == 1);
    }

    public static void ciclo(BufferedReader lee) throws IOException {
        int op;
        Ciclo c;
        Instituto i;
        int cod_insti, cod_ciclo;
        A: do {
            boolean existeInsti = Visualizar.visualizarInstitutos();
            if (existeInsti) {
                do {
                    System.out.println("Introduce el código del instituto:");
                    cod_insti = Integer.parseInt(lee.readLine());
                    i = Comprobaciones.comprobarInsti(cod_insti);
                    if (i == null) {
                        System.out.println("No existe ningún instituto con ese código");
                    }
                } while (i == null);
                do{
                    boolean existeCiclo = Visualizar.visualizarCiclos();
                    if (existeCiclo) {
                        do {
                            System.out.println("Introduce el código del ciclo");
                            cod_ciclo = Integer.parseInt(lee.readLine());
                            c = Comprobaciones.comprobarCiclo(cod_ciclo);
                            if (c == null) {
                                System.out.println("No existe ningún ciclo con ese código");
                            }
                        }while(c == null);
                        i.getCiclos().add(c);
                        Altas.guardarModificar(i);
                    } else {
                        break A;
                    }
                    op = Menu.confirmacion(lee, "¿Desea añadir más ciclos a este instituto?");
                }while(op == 1);
            } else {
                break;
            }
            op = Menu.confirmacion(lee, "¿Desea añadir ciclos a otro instituto?");
        }while(op == 1);
    }

    public static void uso(BufferedReader lee) throws IOException {
        Ciclo c;
        Taller t;
        Uso u;
        int cod_ciclo, cod_taller, op;
        do {
            boolean existeCiclo = Visualizar.visualizarCiclos();
            if (existeCiclo) {
                do {
                    System.out.println("Introduce el código del ciclo:");
                    cod_ciclo = Integer.parseInt(lee.readLine());
                    c = Comprobaciones.comprobarCiclo(cod_ciclo);
                    if (c == null) {
                        System.out.println("No existe ningún ciclo con ese código");
                    }
                } while (c == null);
                boolean existeTaller = Visualizar.visualizarTalleres();
                if (existeTaller) {
                    do {
                        System.out.println("Introduce el código del taller:");
                        cod_taller = Integer.parseInt(lee.readLine());
                        t = Comprobaciones.comprobarTaller(cod_taller);
                        if (t == null) {
                            System.out.println("No existe ningún taller con ese código");
                        }
                    } while (t == null);
                    java.util.Date fecha = new java.util.Date();
                    Time hora = new Time(fecha.getTime());
                    java.sql.Date fechasql = new java.sql.Date(fecha.getTime());
                    u = new Uso(fechasql, hora);
                    u.setCiclo(c);
                    u.setTaller(t);
                    Altas.guardarModificar(u);
                }
            }
            op = Menu.confirmacion(lee, "¿Desea añadir más usos?");
        } while (op == 1);
    }
}
