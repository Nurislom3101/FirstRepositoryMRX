package com.company.Magazine.Marketplace.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "user_id")
    private Integer userId;

    private int loaners_id;

    private int image_id;

    @Column(name = "user_first_name")
    private String user_first_name;

    @Column(name = "user_last_name")
    private String user_last_name;

    @Column(name = "user_middle_name")
    private String user_middle_name;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "user_borrow_name")
    private String user_borrow_name;

    @Column(name = "user_phone_number")
    private String user_phone_number;

    @Column(name = "user_password_series")
    private String user_password_series;

    @Column(name = "user_first_address")
    private String user_first_address;

    @Column(name = "user_second_address")
    private String user_second_address;

    @Column(name = "user_monthly_price")
    private Double user_monthly_price;


    @Column(name = "user_birthdate")
    private Timestamp user_birthdate;

    @Column(name = "user_working_time;")
    private Timestamp user_working_time;

    @Column(name = "user_working_days")
    private Timestamp user_working_days;

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "updated_at")
    private Timestamp updated_at;

    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @Column(name = "loaner_id")
    private Integer loaner_id;

    @OneToOne(mappedBy = "user")
    private Loaner loaner;

    @Column(name = "employees_id")
    private Integer employees_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employees_id", insertable = false, updatable = false)
    private Employees employees;

    @OneToOne(mappedBy = "user")
    private Image image;




}
