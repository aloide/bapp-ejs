package semana_05.Clase.JDBCExample;

import org.sqlite.JDBC;

import java.sql.*;

public class Programa {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Class.forName("org.sqlite.JDBC");

        // registramos el driver
        DriverManager.registerDriver(
                new JDBC()
        );

        // hacemos la com a la base de datos

        var url = "jdbc:sqlite:" + "C:\\Users\\Alito\\repos\\JavaBAPP\\BackendAplicaciones\\src\\main\\resources\\sqlite-sakila.db";
        Connection con = DriverManager.getConnection(url);
        System.out.println("OK DB");

        // hacemos una ejecucion de un sql
        var film_id =20;
        var sql = "SELECT * FROM FIlM WHERE FILM_ID=?";

        PreparedStatement s = con.prepareStatement(sql);
        s.setLong(1,film_id);
        var res = s.executeQuery();

        while (res.next()){
            // se puede acceder por indice o por nombre de la col
            var id = res.getLong("film_id");
            var titulo = res.getString("title");
            System.out.println(id + " " + titulo);
        }

        // cerramos coneccion con tod
        res.close();
        s.close();
        con.close();
    }
}
