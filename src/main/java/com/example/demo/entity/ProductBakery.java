package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
@Entity
@IdClass(ProductBakeryPK.class)
//@IdClass(ProductBakeryPK.class)
public class ProductBakery {

    @Id
    @ManyToOne
    @MapsId("bakeryId")
    @JoinColumn(name = "bakery_id")
//    @JoinColumn(name = "bakeryCategory_id")
    private Bakery bakery;

    @Id
    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id",foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private Product product;
//    @Id
//    UUID bakeryId;
//    @Id
//    UUID productId;

    private int price;
}
