/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package b1prak813020210017.book;
import java.util.List;
/**
 *
 * @author LENOVO
 */
public interface BookService {
    public void addBook(Book book);
    public List<Book> findBookList();
    public Book findBookById(int id);
    public void updateBook(Book book);
    public void removeBook(int id);
}
