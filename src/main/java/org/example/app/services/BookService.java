package org.example.app.services;

import org.example.web.dto.Book;
import org.apache.log4j.Logger;
import org.example.web.dto.RegexBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BookService {

    private final ProjectRepository<Book> bookRepo;

    private ArrayList<Integer> chekedBooks = new ArrayList<>();
    private final Logger logger = Logger.getLogger(BookService.class);

    @Autowired
    public BookService(ProjectRepository<Book> bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks() {
        List<Book> selectBooks = bookRepo.retreiveAll();
        if (!chekedBooks.isEmpty()) {
            for (Integer id : chekedBooks) {
                //bookRepo.
                selectBooks.forEach(book -> {if (Objects.equals(book.getId(), id)) book.setFlag(true);});
            }
        }

        return selectBooks;
    }

    public boolean saveBook(Book book) {
        if (book.isFilled()) {
            bookRepo.store(book);
            return true;
        }
        return false;
    }

    public boolean removeBookById(Integer bookIdToRemove) {

        return bookRepo.removeItemById(bookIdToRemove);
    }

    public boolean selectedBookByRegex(RegexBook regexBook) {
        boolean result = false;
        chekedBooks.clear();
        List<Book> books = getAllBooks();
        // List<Book> selectBooks = new ArrayList<>();
        for (Book book : books) {
            book.setFlag(false);
            if (regexBook.includes(book)) {
                book.setFlag(true);
                result = true;
                chekedBooks.add(book.getId());
                //   selectBooks.add(book);
            }
        }
         return result;
    }

    public boolean removeBookByList() {
        //try {
            chekedBooks.forEach(bookRepo::removeItemById);
            return true;
        //} catch (Exception e) ;{
          //  logger.info("default INIT in book service");
        //}




    }

    public boolean updateFlags(List<Book> bookList) {

        //List<Book> books = getAllBooks();

        for (Book book : bookList) {
            System.out.println(book);
            //books.get(book.getId()).setFlag(book.isFlag());
        }

        return true;
    }

    public void defaultInit() {
        logger.info("default INIT in book service");
    }

    public void defaultDestroy() {
        logger.info("default DESTROY in book service");
    }
}
