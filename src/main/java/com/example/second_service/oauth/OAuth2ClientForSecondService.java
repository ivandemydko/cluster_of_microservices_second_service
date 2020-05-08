package com.example.second_service.oauth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@EnableOAuth2Client
@Component
public class OAuth2ClientForSecondService {

    @Value("${auth-service.uri}")
    String authServiceURI;

    /**
     *   This OAuth2RestTemplate was inserted only for example of using "client credentials" grant type.
     *   Much more better to use
     *   {@link  org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails}
     *   for getting an incoming token (like in "first_service" project)
     */

    @Bean("clientForFirstService")
    @LoadBalanced
    public OAuth2RestTemplate restTemplateFirstService(){
        ClientCredentialsResourceDetails resource = new ClientCredentialsResourceDetails();
        resource.setAccessTokenUri(authServiceURI+"/oauth/token");
        resource.setClientId("second_service");
        resource.setClientSecret("secret");
        resource.setGrantType("client_credentials");
        resource.setScope(new ArrayList<>(){{add("READ");add("WRITE");}});
        resource.setAuthenticationScheme(AuthenticationScheme.form);
        AccessTokenRequest request = new DefaultAccessTokenRequest();
        return new OAuth2RestTemplate(resource, new DefaultOAuth2ClientContext(request));
    }
}
