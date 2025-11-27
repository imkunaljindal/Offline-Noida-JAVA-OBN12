package com.example.accioShop.model;

import com.example.accioShop.enums.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    String name;

    @Column
    int price;

    @Column
    @Enumerated(value = EnumType.STRING)
    Category category;

    @ManyToOne
    @JoinColumn(name="seller_id")
    Seller seller;

    @OneToMany(mappedBy = "product")
    List<Review> reviews = new ArrayList<>();

    @ManyToMany(mappedBy = "products")
    List<OrderEntity> orders = new ArrayList<>();
}
