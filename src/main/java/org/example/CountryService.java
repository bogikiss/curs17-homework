package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

@AllArgsConstructor
@Getter
@ToString
public class CountryService {
    List<Countries> countriesList = new ArrayList<>();

    public List<Countries> getAllCountries() {
        return countriesList.stream()
                .toList();
    }

    public List<String> getAllCountryNames() {
        return countriesList.stream()
                .map(Countries::getName)
                .toList();
    }

   /* public String capitalOfCountry(String country) {
        String result = null;
        for (Countries countries : countriesList) {
            if (countries.getName().equals(country)) {
                result = countries.getCapital();
            }
        }
        return result;
    }*/

    public String capitalOfCountry(String country) {
        List<Countries> filtered = new ArrayList<>();
        filtered = countriesList.stream()
                .filter(countries -> countries.getName().equals(country)).toList();
        return filtered.stream().map(Countries::getCapital).collect(joining("\n"));
    }

    /*public Long populationOfCountry(String country) {
        Long result = null;
        for (Countries countries : countriesList) {
            if (countries.getName().equals(country)) {
                result = (long) countries.getPopulation();
            }
        }
        return result;
    }*/

    public Long populationOfCountry(String country) {
        List<Countries> filtered = new ArrayList<>();
        filtered = countriesList.stream()
                .filter(countries -> countries.getName().equals(country))
                .toList();
        Stream<Integer> pop = filtered.stream().map(Countries::getPopulation);
        return Long.valueOf(pop.collect(toList()).get(0));
    }

    public List<Countries> countriesInContinent(String continent) {
        List<Countries> result = new ArrayList<>();
        for (Countries countries : countriesList) {
            if (countries.getContinent().equals(continent)) {
                result.add(countries);
            }
        }
        return result;
    }

    public List<String> countryNeighbours(String country) {
        List<String> neighbours = new ArrayList<>();
        for (Countries countries : countriesList) {
            if (countries.getName().equals(country)) {
                List<String> ng = Arrays.stream(countries.getNeighbour().split(Pattern.quote("~"))).toList();
                neighbours.add(ng.toString());
            }
        }
        return neighbours;
    }

    public List<Countries> countriesInContinentWithPopulation(String continent, Integer population) {
        List<Countries> result = new ArrayList<>();
        for (Countries countries : countriesList) {
            if (countries.getContinent().equals(continent) && countries.getPopulation() > population) {
                result.add(countries);
            }
        }
        return result;
    }

    public List<Countries> neighbours(String neighbour, String notNeighbour) {
        List<Countries> result = new ArrayList<>();
        for (Countries countries : countriesList) {
            if (countries.getNeighbour() != null) {
                List<String> neighboursList = Arrays.stream(countries.getNeighbour().split(Pattern.quote("~"))).toList();
                if (neighboursList.contains(neighbour) && !neighboursList.contains(notNeighbour)) {
                    result.add(countries);
                }
            }
        }
        return result;
    }
}
