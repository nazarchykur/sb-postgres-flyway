package com.example.sbpostgresflyway.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accounts_seq")
    @SequenceGenerator(name = "accounts_seq", sequenceName = "accounts_seq", allocationSize = 50)
    @Column(name = "id", nullable = false)
    private Long id;

    private String firstName;
    private String lastName;

    @Column(name = "email", nullable = false, unique = true, length = 50)
    private String email;
    private String password;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "account")
    private List<Post> posts = new ArrayList<>();

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "accounts_authorities",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private Set<Authority> authorities = new HashSet<>();

    public void addPost(Post post) {
        post.setAccount(this);
        posts.add(post);
    }

    public void removePost(Post post) {
        post.setAccount(null);
        posts.remove(post);
    }

    public void addAuthority(Authority authority) {
        authority.getAccounts().add(this);
        authorities.add(authority);
    }

    public void removeAuthority(Authority authority) {
        authority.getAccounts().remove(this);
        authorities.remove(authority);
    }
}
