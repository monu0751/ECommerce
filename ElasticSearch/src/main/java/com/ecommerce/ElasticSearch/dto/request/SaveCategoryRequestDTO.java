package com.ecommerce.ElasticSearch.dto.request;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.UUID;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveCategoryRequestDTO {
    private Long categoryId;
    private String name;
    private String description;
}
