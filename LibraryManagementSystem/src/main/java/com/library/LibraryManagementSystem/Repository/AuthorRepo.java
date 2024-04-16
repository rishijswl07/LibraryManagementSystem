package com.library.LibraryManagementSystem.Repository;

import com.library.LibraryManagementSystem.Entites.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorRepo extends JpaRepository<Authors, String>
{

}
