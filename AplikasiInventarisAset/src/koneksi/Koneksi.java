package koneksi;
import java.sql.*;

public class Koneksi {
    private static Connection conn;

    public static Connection getKoneksi() {
        if(conn==null){
            try{
                // Ganti username/password/db sesuai MySQL
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventaris","root","");
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("Gagal koneksi ke database");
            }
        }
        return conn;
    }
}
