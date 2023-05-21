/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package b1prak813020210017;
import b1prak813020210017.book.Book;
import b1prak813020210017.book.BookService;
import b1prak813020210017.book.BookServiceImpl;
import b1prak813020210017.config.Database;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class B1Prak813020210017 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         BookService bookService = new BookServiceImpl();
        int menuInput = 0;
        
        System.out.println("Library Program");
        System.out.println("===============");
        
        do{
            
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Add Book");
            System.out.println("2. Find Book List");
            System.out.println("3. Find Book By Id");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            
            System.out.print("\nSelect Menu : ");
            menuInput = scanner.nextInt();
            
            switch (menuInput){
                case 1:
                    System.out.println("========");
                    System.out.println("Add Book");
                    System.out.println("========");
                    
                    scanner.nextLine();
                    
                    System.out.print("Book Title : ");
                    String title = scanner.nextLine();
                    
                    System.out.print("Author Name : ");
                    String authorName = scanner.nextLine();
                    
                    Book newBook = new Book(title, authorName);
                    bookService.addBook(newBook);
                    break;
                case 2:
                    System.out.println("==============");
                    System.out.println("Find Book List");
                    System.out.println("==============");
                    List<Book> books = bookService.findBookList();
                    if (books.size() < 1){
                        System.out.println("No books yet\n");
                    }else{
                        for (Book book : books){
                            System.out.println("ID          : " + book.getId());
                            System.out.println("Title       : " + book.getTitle());
                            System.out.println("Author Name : " + book.getAuthorName());
                            System.out.println("\n");
                        }
                    }
                    break;
                case 3:
                    System.out.println("===============");
                    System.out.println("Find Book By Id");
                    System.out.println("===============");
                    
                    System.out.print("Book id : ");
                    int bookId = scanner.nextInt();
                    
                    Book book = bookService.findBookById(bookId);
                    if (book !=null){
                        System.out.println("ID          :" + book.getId());
                        System.out.println("Title       :" + book.getTitle());
                        System.out.println("Author Name :" + book.getAuthorName());
                        
                        System.out.println("\n");
                    }else {
                        System.out.println("No books yet\n");
                    }
                    break;
                case 4:
                    System.out.println("===========");
                    System.out.println("Update Book");
                    System.out.println("===========");
                    
                    System.out.println("Update book id : ");
                    int bookIdUpdate = scanner.nextInt();
                    
                    scanner.nextLine();
                    
                    System.out.print("\nBook Title : ");
                    String newTitle = scanner.nextLine().substring(0);
                    System.out.print("Author Name : ");
                    String newAuthorName = scanner.nextLine();
                    
                    Book bookUpdate = new Book();
                    bookUpdate.setId(bookIdUpdate);
                    bookUpdate.setTitle(newTitle);
                    bookUpdate.setAuthorName(newAuthorName);
                    bookService.updateBook(bookUpdate);
                    break;
                case 5:
                    System.out.println("===========");
                    System.out.println("Remove Book");
                    System.out.println("===========");
                    
                    System.out.print("Book id : ");
                    int bookIdRemove = scanner.nextInt();
                    bookService.removeBook(bookIdRemove);
                    break;
                case 6:
                    System.out.println("Program Finished!");
                    Database.closeConnection();
                    break;
                default:
                    System.out.println("Invalid Menus!");
                    break;
            }
        }while (menuInput != 6);
    }
    }
    

