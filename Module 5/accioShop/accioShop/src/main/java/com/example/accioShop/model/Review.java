package com.example.accioShop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.CodePointLength;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @Column
    private int id;

    @Column
    private String comment;

    @Min(value = 1)
    @Max(value = 5)
    @Column
    private int rating;

    @ManyToOne
    @JoinColumn(name="customer_id")
    Customer customer;

    @ManyToOne
    @JoinColumn(name="product_id")
    Product product;
}
