package com.in28mintues.learn_spring_security.jwt;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Marks this class as a REST controller in Spring
public class JwtAuthenticationResource {

    private JwtEncoder jwtEncoder; // Encoder for generating JWT tokens

    // Constructor injection of the JwtEncoder
    public JwtAuthenticationResource(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    @PostMapping("/authenticate") // Maps HTTP POST requests to /authenticate to this method
    public JwtResponse authenticate(Authentication authentication) {
        // Calls createToken to generate a JWT and wraps it in a JwtResponse
        return new JwtResponse(createToken(authentication));
    }

    private String createToken(Authentication authentication) {
        // Build the JWT claims (issuer, issued at, expiration, subject, scope)
        var claims = JwtClaimsSet.builder()
                .issuer("self") // Issuer of the token
                .issuedAt(Instant.now()) // Time of token issuance
                .expiresAt(Instant.now().plusSeconds(60 * 30)) // Token expiration time (30 minutes from issuance)
                .subject(authentication.getName()) // Subject of the token, typically the user's name
                .claim("scope", createScope(authentication)) // Custom claim to include user roles/authorities
                .build();

        // Encode the JWT claims into a token string and return it
        return jwtEncoder.encode(JwtEncoderParameters.from(claims))
                .getTokenValue();
    }

    private String createScope(Authentication authentication) {
        // Collects all authorities (roles/permissions) into a single string separated by spaces
        return authentication.getAuthorities().stream()
                .map(a -> a.getAuthority()) // Maps each authority to its string representation
                .collect(Collectors.joining(" ")); // Joins the authorities with a space separator
    }

}

// A record that holds the JWT token as a response object
record JwtResponse(String token) {}
