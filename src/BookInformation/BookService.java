/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookInformation;

import java.util.List;

public class BookService {
    private BookDao bookDao;

    public BookService() {
        bookDao = new BookDao();
    }
    
    public List<Book> getAllBooks(){
        return bookDao.getAllBooks();
    }
    
    public void deleteUser(String id){
        bookDao.deleteUser(id);
    }
    public Book getUserByClassID(String classID){
        return bookDao.getUserByClassID(classID);
    }
          
    public void updateUser(Book book){
      bookDao.updateUser(book);
    }
}
