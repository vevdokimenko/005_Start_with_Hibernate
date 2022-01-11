package practice;

import practice.entity.Book;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookHelper bookHelper = new BookHelper();

//        Book book1 = new Book();
//        book1.setName("Герой нашего времени");
//        book1.setAuthorId(1);
//
//        Book book2 = new Book();
//        book2.setName("Смерть поэта");
//        book2.setAuthorId(1);
//
//        Book book3 = new Book();
//        book3.setName("Сказка о царе Салтане");
//        book3.setAuthorId(2);

//        bookHelper.addBook(book1);
//        bookHelper.addBook(book2);
//        bookHelper.addBook(book3);

//        Book book = new Book();
//        book.setName("Поэмы");
//        book.setAuthorId(2);
//        book.setCopies(1000);
//
//        bookHelper.addBook(book);

//        List<Book> bookList = bookHelper.getBookList();
//
//        for (Book book : bookList) {
//            System.out.println(book);
//        }
//
//        Book book1 = bookList.get(0);
//        Book book2 = bookList.get(1);
//        book1.setCopies(5000);
//        book2.setCopies(8765);
//        bookHelper.updateBook(book1);
//        bookHelper.updateBook(book2);

        List<Book> bookList = bookHelper.getNameCopiesBook();
        for (Book book : bookList) {
            System.out.println(book.getName() + " " + book.getCopies());
        }
    }
}
