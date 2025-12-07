package com.example.zwigato.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItem {

    @Id
    private int id;

    @Column
    private int quantity;

    @ManyToOne
    @JoinColumn(name="order_id")
    OrderEntity order;

    @ManyToOne
    @JoinColumn(name="menu_item_id")
    MenuItem menuItem;
}
