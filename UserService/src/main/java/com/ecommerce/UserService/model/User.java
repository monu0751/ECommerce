package com.ecommerce.UserService.model;

import com.ecommerce.UserService.external.model.Rating;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    private UUID id;
    private String name;
    private String email;
    private String role;
    private String status;
    private String phone;
    @Transient
    private List<Rating> ratings;
}
