package com.ecommerce.ElasticSearch.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;
import java.util.UUID;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "category")
public class Category {
    @Id
    private UUID id;
    @Field(name = "category_id", type = FieldType.Long)
    private Long categoryId;
    @Field(name = "name", type = FieldType.Text)
    private String name;
    @Field(name = "description", type = FieldType.Text)
    private String description;
//    @Field(name = "products", type = FieldType.Nested)
//    @JsonBackReference
//    private List<Product> products;
}
