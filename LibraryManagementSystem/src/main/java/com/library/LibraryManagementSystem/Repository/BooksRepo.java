package com.library.LibraryManagementSystem.Repository;

import com.library.LibraryManagementSystem.Entites.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface BooksRepo extends JpaRepository<Books, String>
{

    List<Books> findByAuthorsSet_AuthorName(String authorName);

    List<Books> findByGenres_GenreName(String genreName);

    List<Books> findByPublishers_PublisherName(String publisherName);

    List<Books> findByPublicationYear(long publicationYear);

    List<Books> findByTitle(String title);


}

