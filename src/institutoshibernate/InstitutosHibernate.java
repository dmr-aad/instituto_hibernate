package institutoshibernate;

import java.io.*;
import java.sql.*;
import java.text.ParseException;
import metodos.Altas;
import metodos.Añadir;
import metodos.Bajas;
import metodos.Creacion;
import metodos.Listados;
import metodos.Menu;

/**
 *
 * @author a18danielmr
 */
public class InstitutosHibernate {

    static Connection conex;
    static Statement s;
    static ResultSet rs;

    public static void main(String[] args) throws IOException, ParseException {
        String url = "jdbc:mysql://localhost:3307/?user=root&password=usbw";
        int op;
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        try {
            conex = DriverManager.getConnection(url);
            s = conex.createStatement();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            System.exit(0);
        }
        try {
            if (!s.executeQuery("SHOW DATABASES LIKE 'institutodanihibernate'").first()) {
                Creacion.crearTablas(s);
            } else {
                s.execute("USE institutodanihibernate");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            System.exit(2);
        }

        NewHibernateUtil.getSessionFactory();

        

        do {
            op = Menu.principal(lee);
            switch (op) {
                case 1:
                    Altas.main(lee);
                    break;
                case 2:
                    Añadir.main(lee);
                    break;
                case 3:
                    Bajas.main(lee);
                    break;
                case 4:
                    Listados.main(lee);
                    break;
                case 0:
                    NewHibernateUtil.getSessionFactory().close();
                    System.out.println("SALIENDO...");
                    break;
            }
        } while (op != 0);
    }

}
