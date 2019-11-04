
package metodos;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author a18danielmr
 */
public class Menu {
    
    public static int principal(BufferedReader lee) throws IOException {
        int op;
        System.out.println("***MENU_HIBERNATE***\n"
                + "1. Altas\n"
                + "2. Añadir\n"
                + "3. Bajas\n"
                + "4. Listados\n"
                + "0. Salir");
        op = Integer.parseInt(lee.readLine());
        return op;
    }
    
    public static int altas(BufferedReader lee) throws IOException {
        int op;
        System.out.println("***MENU_ALTAS***\n"
                + "1. Alta instituto\n"
                + "2. Alta ciclo\n"
                + "3. Alta taller\n"
                + "0. Salir");
        op = Integer.parseInt(lee.readLine());
        return op;
    }
    
    public static int bajas(BufferedReader lee) throws IOException {
        int op;
        System.out.println("***MENU_BAJAS***\n"
                + "1. Baja ciclo\n"
                + "2. Baja taller\n"
                + "0. Salir");
        op = Integer.parseInt(lee.readLine());
        return op;
    }
    
    public static int añadir(BufferedReader lee) throws IOException {
        int op;
        System.out.println("***MENU_AÑADIR***\n"
                + "1. Ciclos a un instituto\n"
                + "2. Taller a un instituto\n"
                + "3. Usos a un ciclo en un taller\n"
                + "0. Salir");
        op = Integer.parseInt(lee.readLine());
        return op;
    }
    
    public static int listados(BufferedReader lee) throws IOException {
        int op;
        System.out.println("***MENU_LISTADOS***\n"
                + "1. Ciclos que utilizaron un taller\n"
                + "2. Ciclos que imparte un instituto\n"
                + "3. Institutos en los que se imparte un ciclo\n"
                + "0. Salir");
        op = Integer.parseInt(lee.readLine());
        return op;
    }
    
    public static int confirmacion(BufferedReader lee, String mensaje) throws IOException {
        int op;
        System.out.println(mensaje + "\n"
                + "1. Si\n"
                + "2. No");
        op = Integer.parseInt(lee.readLine());
        return op;
    }
}
