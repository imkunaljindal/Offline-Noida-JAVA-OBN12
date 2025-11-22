package com.example.accioShop.model;

import com.example.accioShop.enums.Gender;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @NotNull
    private int age;

    @Column(unique = true,nullable = false)
    @Email
    private String email;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(length = 10)
    private String mobNo;

//    @OneToOne(mappedBy = "customer")
//    Address address;

    @CreationTimestamp
    Date createdAt;

    @OneToMany
    @JoinColumn(name="customer_id")
    @JsonBackReference
    List<Review> reviews = new ArrayList<>();
}
