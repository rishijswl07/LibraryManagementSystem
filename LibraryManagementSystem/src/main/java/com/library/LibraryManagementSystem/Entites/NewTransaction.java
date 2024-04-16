package com.library.LibraryManagementSystem.Entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewTransaction
{
    private String  memberId;
    private String bookId;
    private String transactionType;



}
