package com.example.zwigato.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    private String houseNo;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private int pinCode;
}
