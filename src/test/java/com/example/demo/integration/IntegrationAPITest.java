package com.example.demo.integration;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationAPITest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void exemploTeste() {
        String url = "http://localhost:8080/api/movie-awards/intervals";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
