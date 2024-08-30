package com.ecommerce.ApiGateway.models;

import lombok.*;

import java.util.Collection;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OAuthResponse {
    private String userId;
    private String accessToken;
    private String refreshToken;
    private Collection<String> authorities;
    private Long expiresIn;
}
