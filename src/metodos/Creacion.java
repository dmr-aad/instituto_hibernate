
package metodos;

import java.sql.*;
import java.sql.SQLException;

/**
 *
 * @author a18danielmr
 */
public class Creacion {
    
    public static void crearTablas(Statement s) {
        try{
            s.execute("CREATE DATABASE IF NOT EXISTS institutosdanihibernate");
            
            s.execute("USE institutosdanihibernate");
            
            s.execute("CREATE TABLE IF NOT EXISTS institutos("
                    + "cod_insti INT(4) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, "
                    + "nom_insti VARCHAR(45) NOT NULL, "
                    + "tlfn CHAR(9) NOT NULL, "
                    + "PRIMARY KEY(cod_insti)"
                    + ")ENGINE = INNODB;");
            
            s.execute("CREATE TABLE IF NOT EXISTS ciclos("
                    + "cod_ciclo INT(4) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, "
                    + "nom_ciclo VARCHAR(45) NOT NULL, "
                    + "PRIMARY KEY(cod_ciclo)"
                    + ")ENGINE = INNODB;");
            
            s.execute("CREATE TABLE IF NOT EXISTS talleres("
                    + "cod_taller INT(4) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, "
                    + "nom_taller VARCHAR(10) NOT NULL, "
                    + "instituto INT(4) UNSIGNED ZEROFILL NOT NULL, "
                    + "PRIMARY KEY (cod_taller), "
                    + "FOREIGN KEY (instituto) REFERENCES institutos(cod_insti)"
                    + " ON DELETE CASCADE"
                    + " ON UPDATE CASCADE"
                    + ")ENGINE = INNODB;");
            
            s.execute("CREATE TABLE IF NOT EXISTS ciclos_institutos("
                    + "ciclo INT(4) UNSIGNED ZEROFILL NOT NULL, "
                    + "instituto INT(4) UNSIGNED ZEROFILL NOT NULL, "
                    + "PRIMARY KEY(ciclo, instituto), "
                    + "FOREIGN KEY (ciclo) REFERENCES ciclos(cod_ciclo)"
                    + " ON DELETE CASCADE"
                    + " ON UPDATE CASCADE, "
                    + "FOREIGN KEY (instituto) REFERENCES institutos(cod_insti)"
                    + " ON DELETE CASCADE"
                    + " ON UPDATE CASCADE"
                    + ")ENGINE = INNODB;");
            
            s.execute("CREATE TABLE IF NOT EXISTS usos("
                    + "ciclo INT(4) UNSIGNED ZEROFILL NOT NULL, "
                    + "taller INT(4) UNSIGNED ZEROFILL NOT NULL, "
                    + "fecha DATE NOT NULL, "
                    + "hora TIME NOT NULL, "
                    + "PRIMARY KEY (ciclo, taller, fecha, hora), "
                    + "FOREIGN KEY (ciclo) REFERENCES ciclos (cod_ciclo)"
                    + " ON DELETE CASCADE"
                    + " ON UPDATE CASCADE, "
                    + "FOREIGN KEY (taller) REFERENCES talleres(cod_taller)"
                    + " ON DELETE CASCADE"
                    + " ON UPDATE CASCADE"
                    + ")ENGINE = INNODB;");
            
        }catch(SQLException e){
            System.out.println("Error: "+e);
            System.exit(1);
        }
    }
}
