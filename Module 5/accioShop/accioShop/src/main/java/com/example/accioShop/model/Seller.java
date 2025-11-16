package com.example.accioShop.model;

import com.example.accioShop.enums.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.CodePointLength;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Seller {

    @Id
    private int id;

    @Column
    private String name;

    @Column(length = 10,unique = true)
    private String pan;

    @Column
    @Min(value = 0)
    @Max(value = 5)
    private int rating;

    @Column
    private String email;
}
