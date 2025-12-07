package com.example.zwigato.model;

import com.example.zwigato.utility.enums.FoodCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column
    private int price;

    @Column
    @Enumerated(EnumType.STRING)
    private FoodCategory category;

    @Column
    private boolean isVeg;

    @OneToMany(mappedBy = "menuItem")
    @JsonIgnore
    List<OrderItem> orderItems;

    @ManyToMany
    @JoinTable
    private List<Restaurant> restaurants;

}
