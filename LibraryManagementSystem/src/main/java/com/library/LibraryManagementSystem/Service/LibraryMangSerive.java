package com.library.LibraryManagementSystem.Service;

import com.library.LibraryManagementSystem.Controller.GenerateRandom;
import com.library.LibraryManagementSystem.Entites.*;
import com.library.LibraryManagementSystem.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class LibraryMangSerive
{
    @Autowired
    AuthorRepo authorRepo;
    @Autowired
    BookAuthorsRepo bookAuthorsRepo;
    @Autowired
    BooksRepo booksRepo;
    @Autowired
    GenresRepo genresRepo;
    @Autowired
     MembersRepo membersRepo;
    @Autowired
    PublishersRepo publishersRepo;
    @Autowired
    private TransRepo transRepo;

    public List<Books> getBooksByAuthor(String authorName) {
        return booksRepo.findByAuthorsSet_AuthorName(authorName);
    }

    public List<Books> getBooksByGenre(String genreName) {
        return booksRepo.findByGenres_GenreName(genreName);
    }
    public List<Books> findByPublicationYear(long publicationYear)
    {
        return booksRepo.findByPublicationYear(publicationYear);
    }

    public List<Books> getBooksByPublisher(String publisherName) {
        return booksRepo.findByPublishers_PublisherName(publisherName);
    }
    public List<Books> getBooksByTiltle(String title)
    {
        return booksRepo.findByTitle(title);
    }

    public LibraryDetailedclass addcustomer(LibraryDetailedclass libraryDetailedclass) {
        try {
            GenerateRandom ran = new GenerateRandom();

            Publishers pub = new Publishers();
            pub.setPublisherName(libraryDetailedclass.getPublishers().getPublisherName());
            Publishers savedPublisher = publishersRepo.save(pub);

            Genres gen = new Genres();
            gen.setGenreName(libraryDetailedclass.getGenres().getGenreName());
            Genres savedGenre = genresRepo.save(gen);

            Books book = new Books();
            book.setTitle(libraryDetailedclass.getTitle());
            book.setISBN(libraryDetailedclass.getISBN());
            book.setQuantity(ran.getRandom());
            book.setPublicationYear(libraryDetailedclass.getPublicationYear());
            book.setPublishers(savedPublisher);
            book.setGenres(savedGenre);


            Books savedBook = booksRepo.save(book);

            Authors author = new Authors();
            author.setAuthorName(libraryDetailedclass.getAuthors().getAuthorName());
            Authors savedAuthor = authorRepo.save(author);

            BookAuthors bookAuthor = new BookAuthors();
            bookAuthor.setAuthor(savedAuthor);
            bookAuthor.setBook(savedBook);
            bookAuthorsRepo.save(bookAuthor);

            libraryDetailedclass.setAuthors(author);
            libraryDetailedclass.setGenres(gen);
            libraryDetailedclass.setPublishers(pub);

            return libraryDetailedclass;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
        }
    public Members addmembers( Members members) {
        GenerateRandom ran = new GenerateRandom();
        Members mem = new Members();
        mem.setMemberId(members.getMemberId());
        mem.setName(members.getName());
        mem.setAddress(members.getAddress());
        mem.setPhoneNumber(members.getPhoneNumber());
        mem.setEmail(members.getEmail());
        return membersRepo.save(mem);
    }
    public List<Books> getBooksDetails()
    {
        List<Books> dels= booksRepo.findAll();
        List<Books> boks=new ArrayList<>();
        for(Books details:dels)
        {
            Books bs=new Books();
            bs.setBookId(details.getBookId());
            bs.setTitle(details.getTitle());
            bs.getAuthorsSet();
            bs.setISBN(details.getISBN());
            bs.setGenres(details.getGenres());
            bs.setPublicationYear(details.getPublicationYear());
            bs.setQuantity(details.getQuantity());
            boks.add(bs);
        }
        return boks;
    }
    public List<Members> getMembersDetails()
    {
        List<Members> memd=membersRepo.findAll();
        List<Members> med= new ArrayList<>();
        for(Members detatils:memd)
        {
            Members ms=new Members();
            ms.setMemberId(detatils.getMemberId());
            ms.setName(detatils.getName());
            ms.setAddress(detatils.getAddress());
            ms.setPhoneNumber(detatils.getPhoneNumber());
            ms.setEmail(detatils.getEmail());
            med.add(ms);
        }
        return med;
    }
    public List<Publishers> getPublishers()
    {
        List<Publishers> publ=publishersRepo.findAll();
        List<Publishers> publi=new ArrayList<>();
        for(Publishers det:publ)
        {
            Publishers ps=new Publishers();
            ps.setPublisherId(det.getPublisherId());
            ps.setPublisherName(det.getPublisherName());
            publi.add(ps);
        }
        return publi;
    }
    public List<Authors> getAuthors()
    {
        List<Authors> aut=authorRepo.findAll();
        List<Authors> auth=new ArrayList<>();
        for(Authors dely:aut)
        {
            Authors as=new Authors();
            as.setAuthorId(dely.getAuthorId());
            as.setAuthorName(dely.getAuthorName());
            auth.add(as);
        }
        return auth;
     }
    public List<Transactions> getTransactionsDetails()
    {
        List<Transactions> trans=transRepo.findAll();
        List<Transactions> tran=new ArrayList<>();
        for(Transactions dets:trans)
        {
            Transactions ts=new Transactions();
            ts.setTransactionId(dets.getTransactionId());
            ts.setTransactionType(dets.getTransactionType());
            ts.setDueDate(dets.getDueDate());
            ts.setReturnDate(dets.getReturnDate());
            ts.setBooks(dets.getBooks());
            ts.setMembers(dets.getMembers());
            tran.add(ts);
        }
        return tran;
    }
    public LibraryDetailedclass updateCustomer(String memberId,LibraryDetailedclass libraryDetailedclass)
    {
        Books books=booksRepo.findById(memberId).get();
        books.setTitle(books.getTitle());
        books.setAuthorsSet(books.getAuthorsSet());
        books.setQuantity(books.getQuantity());
        booksRepo.save(books);
        return libraryDetailedclass;
    }
    public Transactions issueBook( NewTransaction newTransaction) {
        String type = newTransaction.getTransactionType();
        Transactions t = new Transactions();
        if(type.equalsIgnoreCase("issue")) {
            Transactions transaction = new Transactions();
            transaction.setTransactionType(newTransaction.getTransactionType());


            Optional<Books> optionalBook = booksRepo.findById(newTransaction.getBookId());
            if (optionalBook.isPresent()) {
                transaction.setBooks(optionalBook.get());
            } else {

                return null;
            }

            Optional<Members> optionalMember = membersRepo.findById(newTransaction.getMemberId());
            if (optionalMember.isPresent()) {
                transaction.setMembers(optionalMember.get());
            } else {

                return null;
            }

            long currentMillis = System.currentTimeMillis();
            long sevenDaysInMillis = 7 * 24 * 60 * 60 * 1000;
            Timestamp dueDate = new Timestamp(currentMillis + sevenDaysInMillis);
            transaction.setDueDate(dueDate);
            t = transRepo.save(transaction);
        }

        return t;
    }

    public Transactions returnBook( NewTransaction newTransaction) {
        String type = newTransaction.getTransactionType();
        Transactions t = new Transactions();
        Calendar c = Calendar.getInstance();
        Date retdate = c.getTime();
        if (type.equalsIgnoreCase("return")) {
            Optional<Transactions> transaction = transRepo.findById(newTransaction.getMemberId());
            if(transaction.isPresent()){
                Transactions tt = transaction.get();
                tt.setMembers(transaction.get().getMembers());
                tt.setBooks(transaction.get().getBooks());
                tt.setDueDate(transaction.get().getDueDate());
                tt.setTransactionType(type);
                tt.setReturnDate(retdate);
                t = transRepo.save(tt);
            }
        }
        return t;
    }



}
