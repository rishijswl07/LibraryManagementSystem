package com.library.LibraryManagementSystem.Controller;

import com.library.LibraryManagementSystem.Entites.*;
import com.library.LibraryManagementSystem.Service.LibraryMangSerive;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private LibraryMangSerive libraryMangSerive;


    @PostMapping("/addbooks")
    public LibraryDetailedclass addcustomer(@RequestBody LibraryDetailedclass libraryDetailedclass) {
        return libraryMangSerive.addcustomer(libraryDetailedclass);
    }

    @PostMapping("/addmembers")
    public Members addmembers(@RequestBody Members members) {
        return libraryMangSerive.addmembers(members);

    }

    @GetMapping("/books")
    public List<Books> getBooksDetails() {
        return libraryMangSerive.getBooksDetails();
    }

    @GetMapping("/members")
    public List<Members> getMembersDetails() {
        return libraryMangSerive.getMembersDetails();
    }

    @GetMapping("/transactions")
    public List<Transactions> getTransactionDetails() {
        return libraryMangSerive.getTransactionsDetails();
    }

    @GetMapping("/publishers")
    public List<Publishers> getPublishers() {
        return libraryMangSerive.getPublishers();
    }

    @GetMapping("/authors")
    public List<Authors> getAuthors() {
        return libraryMangSerive.getAuthors();
    }

    @PutMapping("/addupdateCustomer/{memberId}")
    public LibraryDetailedclass updateCustomer(@PathVariable String memberId, @RequestBody LibraryDetailedclass libraryDetailedclass) {
        return libraryMangSerive.updateCustomer(memberId, libraryDetailedclass);
    }

    @PostMapping("/issueBook")
    public ResponseEntity<String> issueBook(@RequestBody NewTransaction newTransaction) {
        Transactions transaction = libraryMangSerive.issueBook(newTransaction);
        if (transaction != null) {
            return ResponseEntity.ok("Book issued successfully.");
        }
        return ResponseEntity.badRequest().body("Failed to issue book.");
    }

    @PostMapping("/returnBook")
    public ResponseEntity<String> returnBook(@RequestBody NewTransaction newTransaction) {
        Transactions transaction = libraryMangSerive.returnBook(newTransaction);
        if (transaction != null) {
            return ResponseEntity.ok("Book returned successfully.");
        }
        return ResponseEntity.badRequest().body("Failed to return book.");
    }

    @GetMapping("/booksByAuthor/{authorName}")
    public ResponseEntity<List<Books>> getBooksByAuthor(@PathVariable String authorName) {
        List<Books> books = libraryMangSerive.getBooksByAuthor(authorName);
        if (!books.isEmpty()) {
            return ResponseEntity.ok(books);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/booksByGenre/{genreName}")
    public ResponseEntity<List<Books>> getBooksByGenre(@PathVariable String genreName) {
        List<Books> books = libraryMangSerive.getBooksByGenre(genreName);
        if (!books.isEmpty()) {
            return ResponseEntity.ok(books);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/booksByPublisher/{publisherName}")
    public ResponseEntity<List<Books>> getBooksByPublisher(@PathVariable String publisherName) {
        List<Books> books = libraryMangSerive.getBooksByPublisher(publisherName);
        if (!books.isEmpty()) {
            return ResponseEntity.ok(books);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getBooksByPublisherYear/{publicationYear}")
    public ResponseEntity<List<Books>> getBooksByPublisherYear(@PathVariable long publicationYear) {
        List<Books> books = libraryMangSerive.findByPublicationYear(publicationYear);
        if (!books.isEmpty()) {
            return ResponseEntity.ok(books);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getBooksByTiltle/{title}")
    public ResponseEntity<List<Books>> getBooksByTiltle(@PathVariable String title) {
        List<Books> books = libraryMangSerive.getBooksByTiltle(title);
        if (!books.isEmpty()) {
            return ResponseEntity.ok(books);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

