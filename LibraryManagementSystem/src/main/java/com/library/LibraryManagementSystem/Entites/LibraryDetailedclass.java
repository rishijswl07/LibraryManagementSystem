package com.library.LibraryManagementSystem.Entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class LibraryDetailedclass
{
    private String title;
    private String ISBN;
    private long publicationYear;
    private Publishers publishers;
    private Genres genres;
    private Authors authors;

}
