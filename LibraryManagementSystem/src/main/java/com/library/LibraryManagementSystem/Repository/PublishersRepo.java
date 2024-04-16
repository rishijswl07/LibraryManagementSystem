package com.library.LibraryManagementSystem.Repository;

import com.library.LibraryManagementSystem.Entites.Books;
import com.library.LibraryManagementSystem.Entites.Publishers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PublishersRepo extends JpaRepository<Publishers, String >
{
    UUID findByPublisherName(String publisherName);
}
