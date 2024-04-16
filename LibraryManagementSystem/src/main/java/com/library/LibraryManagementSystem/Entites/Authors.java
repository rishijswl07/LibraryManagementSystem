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
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Authors
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)// Universally Unique IDentifier
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String authorId;

    @Column
    private String authorName;
    @ManyToMany(mappedBy = "authorsSet")
    @JsonIgnore
    private Set<Books> booksSet = new HashSet<>();


}