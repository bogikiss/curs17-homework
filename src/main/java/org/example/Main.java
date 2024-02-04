package org.example;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<Countries> countries = CountryReader.readCountries("countries.txt");
        CountryService countryService = new CountryService(countries);

        System.out.println(countryService.getAllCountries());
        System.out.println(countryService.getAllCountryNames());
        System.out.println(countryService.capitalOfCountry("Afghanistan"));
        System.out.println(countryService.populationOfCountry("Afghanistan"));
        System.out.println(countryService.countriesInContinent("Europe"));
        System.out.println(countryService.countryNeighbours("Afghanistan"));
        System.out.println(countryService.countriesInContinentWithPopulation("Europe", 10000000));
        System.out.println(countryService.neighbours("FRA", "HUN"));
    }
}
