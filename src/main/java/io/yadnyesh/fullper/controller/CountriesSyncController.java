package io.yadnyesh.fullper.controller;

import io.yadnyesh.fullper.model.Country;
import io.yadnyesh.fullper.service.CountryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("allcountries")
public class CountriesSyncController {
    private final CountryClient countryClient;

    public CountriesSyncController(CountryClient countryClient) {
        this.countryClient = countryClient;
    }

    @GetMapping("/")
    public List<String> getAllCountriesByLanguageAndRegion() {
        List<Country> countriesByLanguage = countryClient.getCountriesByLanguage("fr");
        List<Country> countriesByRegion = countryClient.getCountriesByRegion("eu");
        List<String> countriesByLanguageAndRegion = countriesByLanguage.stream().map(Country::getName).collect(Collectors.toList());
        countriesByLanguageAndRegion.addAll(countriesByRegion.stream().map(Country::getName).collect(Collectors.toList()));
        return countriesByLanguageAndRegion;
    }
}
