package com.example.accioShop.model;

import com.example.accioShop.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
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

    @OneToMany(mappedBy = "customer")
    List<Review> reviews = new ArrayList<>();
}
