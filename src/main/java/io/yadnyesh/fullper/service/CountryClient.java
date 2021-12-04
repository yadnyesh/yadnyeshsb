package io.yadnyesh.fullper.service;

import io.yadnyesh.fullper.model.Country;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class CountryClient {
    RestTemplate restTemplate = new RestTemplate();

    public List<Country> getCountriesByLanguage(String language) {
        String url = "https://restcountries.com/v2/lang/" + language + "?fields=name";
        Country[] response = restTemplate.getForObject(url, Country[].class);
        log.info("LANGUAGE: {} Fetched all relevant countries.",language);
        return Arrays.asList(response);
    }

    public List<Country> getCountriesByRegion(String region) {
        String url = "https://restcountries.com/v2/regionalbloc/" + region + "?fields=name";
        Country[] response = restTemplate.getForObject(url, Country[].class);
        log.info("REGION: {} Fetched all relevant countries.",region);
        return Arrays.asList(response);
    }

}
