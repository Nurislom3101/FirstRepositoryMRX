package com.company.Magazine.Marketplace.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = ("employees"))
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "employees_id")
    private Integer employeesId;

    private int user_id;

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "updated_at")
    private Timestamp updated_at;

    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @OneToMany(mappedBy = "employees_id", cascade = CascadeType.ALL)
    private Set<User> users;
}
