package com.ecommerce.product.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponseDTO {
    private String message;
    private String details;
    private String statusCode;
}
