package com.ecommerce.product.config.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class FeignInterceptor implements RequestInterceptor {
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String BEARER_TOKEN_TYPE = "Bearer";
    private final OAuth2AuthorizedClientManager manager;

    public FeignInterceptor(OAuth2AuthorizedClientManager manager) {
        this.manager = manager;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        OAuth2AuthorizedClient client = manager.authorize(OAuth2AuthorizeRequest
                .withClientRegistrationId("my-internal-client")
                .principal("internal")
                .build());
        OAuth2AccessToken accessToken = null;
        if (client != null) {
            accessToken = client.getAccessToken();
        }
        if (accessToken != null) {
            requestTemplate.header(
                    AUTHORIZATION_HEADER,
                    String.format("%s %s", BEARER_TOKEN_TYPE, accessToken.getTokenValue()));
        }
    }
}
