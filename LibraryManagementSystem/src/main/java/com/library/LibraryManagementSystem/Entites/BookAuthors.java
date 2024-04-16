package com.library.LibraryManagementSystem.Entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BookAuthors
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )

    private String id;

    @ManyToOne
    @JoinColumn(name="bookId")
    private Books book;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private Authors author;


}
