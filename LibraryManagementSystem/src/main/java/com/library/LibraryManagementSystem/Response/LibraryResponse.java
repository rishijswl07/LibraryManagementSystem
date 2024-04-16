package com.library.LibraryManagementSystem.Response;

import lombok.Data;

@Data
public class LibraryResponse
{
    private long bookId;
    private long memberId;
    private long publisherId;
    private long genreId;
}
