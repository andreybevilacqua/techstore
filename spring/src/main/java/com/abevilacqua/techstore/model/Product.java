package com.abevilacqua.techstore.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE, force = true)
@Getter
@Entity
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final long id;

    @NotNull
    @Column
    private final String name;

    @NotNull
    @Column
    private final String description;

    @NotNull
    @Column
    private final double price;

}
