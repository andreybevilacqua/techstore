package com.abevilacqua.techstore.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.*;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class Product extends PanacheEntity {

    private String name;
    private String description;
    private double price;
}
