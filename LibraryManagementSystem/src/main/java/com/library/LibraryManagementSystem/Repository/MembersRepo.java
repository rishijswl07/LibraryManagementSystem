package com.library.LibraryManagementSystem.Repository;

import com.library.LibraryManagementSystem.Entites.Books;
import com.library.LibraryManagementSystem.Entites.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MembersRepo extends JpaRepository<Members, String >
{

}
