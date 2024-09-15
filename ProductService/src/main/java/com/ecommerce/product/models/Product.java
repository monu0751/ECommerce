package com.ecommerce.product.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseModel{
    private String name;
    private String description;
    private double price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonManagedReference
    private Category category;
}
