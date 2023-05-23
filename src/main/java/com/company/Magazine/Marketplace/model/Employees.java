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

    private Integer employeesId;

    private int user_id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @OneToMany(mappedBy = "employees_id", cascade = CascadeType.ALL)
    private Set<User> users;
}
