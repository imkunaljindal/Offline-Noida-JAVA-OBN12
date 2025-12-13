package com.example.zwigato.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    private String location;

    boolean isOpen;

    @CreationTimestamp
    Date registeredAt;

    @ManyToMany(mappedBy = "restaurants",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<MenuItem> menuItems;
}
