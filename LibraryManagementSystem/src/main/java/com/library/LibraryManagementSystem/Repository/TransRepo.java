package com.library.LibraryManagementSystem.Repository;

import com.library.LibraryManagementSystem.Entites.Transactions;
import jakarta.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository

public interface TransRepo extends JpaRepository<Transactions, String >
{

}
