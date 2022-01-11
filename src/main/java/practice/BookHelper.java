package practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import practice.entity.Book;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import java.util.List;

public class BookHelper {

    private SessionFactory sessionFactory;

    public BookHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Book> getBookList() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Book.class);
        Root<Book> root = cq.from(Book.class);
        cq.select(root);

        Query query = session.createQuery(cq);
        List<Book> bookList = query.getResultList();
        session.close();

        return bookList;
    }

    public Book getBookById(long id) {
        Session session = sessionFactory.openSession();
        Book book = session.get(Book.class, id);
        session.close();
        return book;
    }

    public void addBook(Book book) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        session.close();
    }

    public void updateBook(Book book) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Book bookDB = session.get(Book.class, book.getId());
        bookDB.setName(book.getName());
        bookDB.setAuthorId(book.getAuthorId());
        bookDB.setCopies(book.getCopies());
        session.save(bookDB);
        session.getTransaction().commit();
        session.close();
    }

    public List<Book> getNameCopiesBook(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = criteriaQuery.from(Book.class);
        Selection[] selections = {root.get("name"), root.get("copies")};
        criteriaQuery.select(criteriaBuilder.construct(Book.class, selections));

        Query query = session.createQuery(criteriaQuery);

        return query.getResultList();
    }
}
