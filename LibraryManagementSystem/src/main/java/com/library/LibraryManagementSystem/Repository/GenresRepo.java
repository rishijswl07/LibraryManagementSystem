package com.library.LibraryManagementSystem.Repository;

import com.library.LibraryManagementSystem.Entites.Genres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GenresRepo extends JpaRepository<Genres, String >
{

}
