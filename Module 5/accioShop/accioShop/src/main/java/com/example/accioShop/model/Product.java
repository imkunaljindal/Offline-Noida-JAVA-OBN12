package com.example.accioShop.model;

import com.example.accioShop.enums.Category;
import jakarta.persistence.*;
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
public class Product {

    @Id
    @Column
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
