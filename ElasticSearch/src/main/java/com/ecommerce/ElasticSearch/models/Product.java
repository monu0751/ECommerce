package com.ecommerce.ElasticSearch.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.UUID;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "product")
public class Product{
    @Id
    UUID id;
    @Field(name = "product_id",type = FieldType.Long)
    private Long productId;
    @Field(name = "name",type = FieldType.Text)
    private String name;
    @Field(name = "description",type = FieldType.Text)
    private String description;
    @Field(name = "price",type = FieldType.Double)
    private double price;
    @Field(name = "category",type = FieldType.Nested)
    private Category category;
}
