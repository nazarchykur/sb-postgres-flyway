package com.example.sbpostgresflyway.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authorities")
@Getter
@Setter
@NoArgsConstructor
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authorities_seq")
    @SequenceGenerator(name = "authorities_seq", sequenceName = "authorities_seq", allocationSize = 50)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 25)
    private String name;
    ;

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(mappedBy = "authorities")
    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        account.getAuthorities().add(this);
        accounts.add(account);
    }

    private void removeAccount(Account account) {
        account.getAuthorities().remove(this);
        accounts.remove(account);
    }

}
