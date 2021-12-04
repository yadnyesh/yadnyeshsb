package io.yadnyesh.fullper.service;

import io.yadnyesh.fullper.model.Country;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class CountryClient {
    RestTemplate restTemplate = new RestTemplate();

    public List<Country> getCountriesByLanguage(String language) {
        String url = "https://restcountries.com/v2/lang/" + language + "?fields=name";
        Country[] response = restTemplate.getForObject(url, Country[].class);
        log.info("LANGUAGE: {} Fetched all relevant countries.",language);
        try {
            log.info("LANGUAGE Thread going into hibernation....");
            Thread.sleep(4000);
            log.info("LANGUAGE Thread out of hibernation....");
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        return Arrays.asList(response);
    }

    public List<Country> getCountriesByRegion(String region) {
        String url = "https://restcountries.com/v2/regionalbloc/" + region + "?fields=name";
        Country[] response = restTemplate.getForObject(url, Country[].class);
        log.info("REGION: {} Fetched all relevant countries.",region);
        try {
            log.info("REGION Thread going into hibernation....");
            Thread.sleep(3000);
            log.info("REGION Thread out of hibernation....");
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        return Arrays.asList(response);
    }

}
