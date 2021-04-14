package QuanPham;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS FX504
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS FX504
 */
public class Connect {
    private Connection conn = null;
    public Connect(){
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1435;databasename=Food_DB;"
//                    + "username=admin;password=123456");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    
    public void connectSQL() throws SQLException {
        try {
            String username = "admin";
            String password = "123456";
            // Lưu ý nè coi cái Port của tụi m là port bao nhiêu mà set Port cho đúng
            // Ko là ko kết nối được đâu
            String url = "jdbc:sqlserver://localhost:1435;databasename=QLSach;"; // Đường dẫn trỏ đến server trong SQL của PC 
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// Cái này là mặc định ko đụng dô
            conn = java.sql.DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e){
            System.out.println("ERROR");
            e.printStackTrace();// Chir ra đường dẫn sai đọc ko hiểu đâu khỏi đọc google đi
        }
    }
    
    // Phương thức dùng để truy vấn đến db
    public ResultSet LoadData(String sql) {
        ResultSet result = null;
        try {
            Statement statement = conn.createStatement();
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //Phương thức thực hiện các câu lệnh (SELECT, UPDATE, CREATE, ... ) - Thêm xóa sửa dữ liêuj
    public void UpdateData(String sql) {
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
//    Check ket noi csdl
//    public static void main(String[] args) {
//        new Connect();
//    }
}
