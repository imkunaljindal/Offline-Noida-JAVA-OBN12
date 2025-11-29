package com.example.accioShop.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="address")
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String houseNo;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private int pinCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    Customer customer;
}
