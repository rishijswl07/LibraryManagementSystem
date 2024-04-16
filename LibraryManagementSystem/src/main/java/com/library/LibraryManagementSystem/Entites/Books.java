package com.library.LibraryManagementSystem.Entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.List;
import java.util.RandomAccess;
import java.util.Set;
import java.util.concurrent.Flow;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Books
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)// Universally Unique IDentifier
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )

    private String bookId;
    @Column
    private String title;
    @Column
    private  String ISBN;
    @Column
    private long publicationYear;
    @Column
    private long quantity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genreId")
    @JsonIgnore

    private Genres genres;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisherId")
    @JsonIgnore
    private Publishers publishers;


    @ManyToMany
    @JoinTable(name = "BookAuthors",
            joinColumns = @JoinColumn(name = "BookId"),
            inverseJoinColumns = @JoinColumn(name = "AuthorId")
    )
    @JsonIgnore
    private Set<Authors> authorsSet = new HashSet<>();


    @OneToMany(mappedBy = "books")
    @JsonIgnore
    private Set<Transactions> transactionsset=new HashSet<>();



}
