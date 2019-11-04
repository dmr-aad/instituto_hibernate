package metodos;

import institutoshibernate.NewHibernateUtil;
import java.io.BufferedReader;
import java.io.IOException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.Ciclo;
import pojos.Instituto;
import pojos.Taller;

/**
 *
 * @author a18danielmr
 */
public class Altas {
    
    public static void main(BufferedReader lee) throws IOException {
        int op;
        op = Menu.altas(lee);
        switch(op) {
            case 1:
                instituto(lee);
                break;
            case 2:
                ciclo(lee);
                break;
            case 3:
                taller(lee);
                break;
            case 0:
                System.out.println("SALIENDO...");
                break;
        }
    }

    public static void instituto(BufferedReader lee) throws IOException {
        int tlfn, op;
        String nom_insti;
        System.out.println("Introduce el nombre del instituto: ");
        nom_insti = lee.readLine();
        System.out.println("Introduce el telefono del instituto: ");
        tlfn = Integer.parseInt(lee.readLine());
        Instituto i = new Instituto(nom_insti, tlfn);
        do {
            System.out.println("¿Desea dar de alta algún ciclo o taller en este instituto?\n"
                    + "1. Ciclo\n"
                    + "2. Taller\n"
                    + "0. Salir");
            op = Integer.parseInt(lee.readLine());
            switch (op) {
                case 1:
                    do {
                        System.out.println("¿Crear un ciclo nuevo o utilizar uno ya existente?\n"
                                + "1. Nuevo\n"
                                + "2. Existente");
                        int op2 = Integer.parseInt(lee.readLine());
                        if (op2 == 1) {
                            Ciclo c = crearCiclo(lee, i);
                            i.getCiclos().add(c);
                            guardarModificar(c);
                        } else if (op2 == 2) {
                            boolean existe = Visualizar.visualizarCiclos();
                            if (existe) {
                                int cod_ciclo;
                                System.out.println("Introduzca el codigo del ciclo que desea añadir: ");
                                cod_ciclo = Integer.parseInt(lee.readLine());
                                Ciclo c;
                                c = Comprobaciones.comprobarCiclo(cod_ciclo);
                                if (c != null) {
                                    i.getCiclos().add(c);
                                } else {
                                    System.out.println("El codigo tecleado no coincide con ningún código de la lista");
                                }
                            }
                        } else {
                            System.out.println("Opción incorrecta");
                        }
                        op = Menu.confirmacion(lee, "¿Desea añadir más ciclos?");
                    } while (op == 1);
                    break;
                case 2:
                    do {
                        System.out.println("¿Crear un taller nuevo o utilizar uno ya existente?\n"
                                + "1. Nuevo\n"
                                + "2. Existente");
                        int op2 = Integer.parseInt(lee.readLine());
                        if (op2 == 1) {
                            Taller t = crearTaller(lee, i);
                            i.getTalleres().add(t);
                            guardarModificar(t);
                        } else if (op2 == 2) {
                            boolean existe = Visualizar.visualizarTalleres();
                            if (existe) {
                                int cod_taller;
                                System.out.println("Introduzca el codigo del taller que desea añadir: ");
                                cod_taller = Integer.parseInt(lee.readLine());
                                Taller t;
                                t = Comprobaciones.comprobarTaller(cod_taller);
                                if (t != null) {
                                    i.getTalleres().add(t);
                                } else {
                                    System.out.println("El codigo tecleado no coincide con ningún código de la lista");
                                }
                            }
                        } else {
                            System.out.println("Opción incorrecta");
                        }
                        op = Menu.confirmacion(lee, "¿Desea añadir más talleres?");
                    } while (op == 1);
                    break;
                case 0:
                    System.out.println("SALIENDO...");
                    break;
            }
            op = Menu.confirmacion(lee, "¿Seguir añadiendo campos al instituto?");
        } while (op == 1);
        guardarModificar(i);
    }

    public static void ciclo(BufferedReader lee) throws IOException {
        String nom_ciclo;
        Instituto i;
        int op, op2;
        System.out.println("Introduce el nombre del ciclo: ");
        nom_ciclo = lee.readLine();
        Ciclo c = new Ciclo(nom_ciclo);
        op = Menu.confirmacion(lee, "¿Desea dar de alta algún instituto donde se imparta este ciclo?");
        if (op == 1) {
            do {
                System.out.println("¿Utilizar un instituto nuevo o uno ya existente?\n"
                        + "1. Nuevo\n"
                        + "2. Existente");
                op2 = Integer.parseInt(lee.readLine());
                switch (op2) {
                    case 1:
                        i = crearInstituto(lee, c);
                        c.getInstitutos().add(i);
                        guardarModificar(i);
                        break;
                    case 2:
                        boolean existe = Visualizar.visualizarInstitutos();
                        if (existe) {
                            System.out.println("Introduce el codigo del insituto al que quieres añadir el ciclo: ");
                            int cod_insti = Integer.parseInt(lee.readLine());
                            i = Comprobaciones.comprobarInsti(cod_insti);
                            if (i != null) {
                                c.getInstitutos().add(i);
                            } else {
                                System.out.println("El codigo tecleado no coincide con ningún código de la lista");
                            }
                        }
                        break;
                }
                op2 = Menu.confirmacion(lee, "¿Deseas añadir más institutos?");
            } while (op2 == 1);
        }
        guardarModificar(c);
    }

    public static void taller(BufferedReader lee) throws IOException {
        String nom_taller;
        Instituto i;
        int op;
        System.out.println("Introduce el nombre del taller: ");
        nom_taller = lee.readLine();
        Taller t = new Taller(nom_taller);
        System.out.println("Dar de alta el taller en un instituto: \n"
                + "1. Nuevo\n"
                + "2. Existente");
        op = Integer.parseInt(lee.readLine());
        switch (op) {
            case 1:
                i = crearInstituto(lee, t);
                t.setInstituto(i);
                guardarModificar(i);
                break;
            case 2:
                boolean existe = Visualizar.visualizarInstitutos();
                if (existe) {
                    System.out.println("Introduce el codigo del insituto al que quieres añadir el ciclo: ");
                    int cod_insti = Integer.parseInt(lee.readLine());
                    i = Comprobaciones.comprobarInsti(cod_insti);
                    if (i != null) {
                        t.setInstituto(i);
                    } else {
                        System.out.println("El codigo tecleado no coincide con ningún código de la lista");
                    }
                }
                break;
        }
    }

    public static Instituto crearInstituto(BufferedReader lee, Ciclo c) throws IOException {
        int tlfn, op;
        String nom_insti;
        System.out.println("Introduce el nombre del instituto: ");
        nom_insti = lee.readLine();
        System.out.println("Introduce el telefono del instituto: ");
        tlfn = Integer.parseInt(lee.readLine());
        Instituto i = new Instituto(nom_insti, tlfn);
        i.getCiclos().add(c);
        return i;
    }

    public static Instituto crearInstituto(BufferedReader lee, Taller t) throws IOException {
        int tlfn, op;
        String nom_insti;
        System.out.println("Introduce el nombre del instituto: ");
        nom_insti = lee.readLine();
        System.out.println("Introduce el telefono del instituto: ");
        tlfn = Integer.parseInt(lee.readLine());
        Instituto i = new Instituto(nom_insti, tlfn);
        i.getTalleres().add(t);
        return i;
    }

    public static Taller crearTaller(BufferedReader lee, Instituto i) throws IOException {
        String nom_taller;
        System.out.println("Introduce el nombre del taller");
        nom_taller = lee.readLine();
        Taller t = new Taller(nom_taller);
        t.setInstituto(i);
        return t;
    }

    public static Ciclo crearCiclo(BufferedReader lee, Instituto i) throws IOException {
        String nom_ciclo;
        System.out.println("Introduce el nombre del ciclo: ");
        nom_ciclo = lee.readLine();
        Ciclo c = new Ciclo(nom_ciclo);
        c.getInstitutos().add(i);
        return c;
    }

    public static void guardarModificar(Object objeto) {
        Session sesion;
        try {
            sesion = NewHibernateUtil.getSession();
            sesion.beginTransaction();
            sesion.saveOrUpdate(objeto);
            sesion.getTransaction().commit();
            sesion.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }
}
