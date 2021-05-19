/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookInformation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hoava
 */
public class BookDao {
     Connection con = connectDataBase.getJDBCConnection();

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<Book>();
        String sql = "select * from tblBookInformation";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();

                book.setId(rs.getString("id"));
                book.setTitle(rs.getString("title"));
                book.setPrice(rs.getDouble("price"));

                books.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return books;
    }
    public Book getUserByClassID(String id) {
        String sql = "select * from tblBookInformation where id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Book book = new Book();

                book.setId(rs.getString("id"));
                book.setTitle(rs.getString("title"));
                book.setPrice(rs.getDouble("price"));

                return book;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
//    public void addUser(Book book) {
//        String sql = "insert into tblBookInformation values(?,?,?)";
//
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, book.getId());
//            ps.setString(2, book.getTitle());
//            ps.setDouble(3, book.getPrice());
//            int rs = ps.executeUpdate();
//            System.out.println(rs);
//        } catch (SQLException ex) {
//            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public void updateUser(Book book) {
        String sql = "update tblBookInformation set title = ?, price = ? where id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(2, book.getId());
            ps.setString(1, book.getTitle());
            ps.setDouble(2, book.getPrice());
            int rs = ps.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void deleteUser(String id) {
        String sql = "delete from tblBookInformation where id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            int rs = ps.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
