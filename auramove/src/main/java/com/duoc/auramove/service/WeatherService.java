package com.duoc.auramove.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.duoc.auramove.Dto.WeatherDTO;

@Service
public class WeatherService {

    @Autowired
    @Qualifier("weatherWebClient")
    private WebClient weatherWebClient;

    public WeatherDTO obtenerClima(double latitude, double longitude) {
        return weatherWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/forecast")
                        .queryParam("latitude", latitude)
                )
    }
}
