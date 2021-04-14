package QuanPham;


import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS FX504
 */
public class SQLQuery {
    public Connect cn = new Connect();
    
    public ResultSet GetBookCategoriese () throws SQLException{
        cn.connectSQL();
        String query = "SELECT * FROM LoaiSach";
        return cn.LoadData(query);
    }
    
    public ResultSet GetBooks() throws SQLException {
        cn.connectSQL();
        String query = "SELECT a.MaSach, a.TenSach, a.NamXB, a.GiaSach, b.TenLoai FROM Sach as a, LoaiSach as b WHERE a.MaLoai=b.MaLoai";
        return cn.LoadData(query);
    }
    
    public void RemoveBook(String code) throws SQLException{
        cn.connectSQL();
        String sql = "DELETE FROM Sach WHERE MaSach='" + code + "'";
        cn.UpdateData(sql);
    }
    
    public void UpdateBook(String code, String name, String gia, String nam, String tl) throws SQLException{
        cn.connectSQL();
        String sql = "UPDATE Sach "
                +    "SET NamXB=" + nam + ", TenSach=N'" + name + "', GiaSach=" + gia + ", MaLoai=(SELECT loai.MaLoai FROM LoaiSach as loai WHERE loai.TenLoai=N'" + tl + "') "
                +    "WHERE MaSach='" + code + "'";
        cn.UpdateData(sql);
    }
    
    public void AddBook(String code, String name,String gia, String nam, String tl) throws SQLException {
        cn.connectSQL();
        String sql = "INSERT INTO Sach (MaSach, TenSach, GiaSach, NamXB, MaLoai) VALUES ('" + code + "', N'" + name + "', " + gia + ", " + nam + ", "
                + "(SELECT l.MaLoai FROM LoaiSach as l WHERE l.TenLoai=N'" + tl + "'))";
        System.out.println("SQL : " + sql);
        cn.UpdateData(sql);
    }
}
