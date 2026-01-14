package com.alura.literatura.service;

import com.alura.literatura.dto.RespuestaGutendex;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GutendexService {

    private static final String BASE_URL = "https://gutendex.com/books/";

    private final RestTemplate restTemplate = new RestTemplate();

    public RespuestaGutendex buscarLibroPorTitulo(String titulo) {
        String url = UriComponentsBuilder
                .fromHttpUrl(BASE_URL)
                .queryParam("search", titulo)
                .toUriString();

        return restTemplate.getForObject(url, RespuestaGutendex.class);
    }
}
