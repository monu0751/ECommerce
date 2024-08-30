package com.ecommerce.ApiGateway.controllers;

import com.ecommerce.ApiGateway.models.OAuthResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/oauth")
public class OAuthController {
    @GetMapping
    public String hello(@AuthenticationPrincipal OidcUser user) {
        return String.format("Welcome, %s", user.getFullName());
    }
    Logger logger = LoggerFactory.getLogger(OAuthController.class);

    @GetMapping("/hello-oauth")
    public String hello(Principal principal) {
        return "Hello, " + principal.getName();
    }
    @GetMapping("/login")
    public OAuthResponse login(
            @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient authorizedClient,
            @AuthenticationPrincipal OidcUser user,
            Model model
            ) {

        logger.info("User Info: " + user.getEmail());
        logger.info("Authorized Client Info: " + authorizedClient.getAccessToken().getTokenValue());
        logger.info("Authorized Client Info: " + authorizedClient.getAccessToken().getExpiresAt());
        logger.info("Authorized Client Info: " + authorizedClient.getAccessToken().getScopes());

        return OAuthResponse.builder()
                .userId(user.getName())
                .accessToken(authorizedClient.getAccessToken().getTokenValue())
                .authorities(user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .expiresIn(Objects.requireNonNull(authorizedClient.getAccessToken().getExpiresAt()).getEpochSecond())
                .build();
    }
}
