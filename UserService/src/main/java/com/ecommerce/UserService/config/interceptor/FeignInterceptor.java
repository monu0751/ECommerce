package com.ecommerce.UserService.config.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class FeignInterceptor implements RequestInterceptor {
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String BEARER_TOKEN_TYPE = "Bearer";

    @Autowired
    private OAuth2AuthorizedClientManager manager;
    private OAuth2AuthorizedClientService authorizedClientService;
    public FeignInterceptor(OAuth2AuthorizedClientService authorizedClientService) {
        this.authorizedClientService = authorizedClientService;
    }
    @Override
    public void apply(RequestTemplate requestTemplate) {
        OAuth2AuthorizedClient client = manager
                .authorize(
                        OAuth2AuthorizeRequest
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

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
//        OAuth2AuthorizedClient client = authorizedClientService.loadAuthorizedClient(
//                oauthToken.getAuthorizedClientRegistrationId(),
//                oauthToken.getName());
//        OAuth2AccessToken accessToken = client.getAccessToken();
//        requestTemplate.header(
//                AUTHORIZATION_HEADER,
//                String.format("%s %s", BEARER_TOKEN_TYPE, accessToken.getTokenValue()));
    }
}
