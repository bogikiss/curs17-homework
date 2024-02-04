package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CountryReader {
    public static List<Countries> readCountries(String fileName) throws FileNotFoundException{
        List<Countries> countries = new ArrayList<>();
        Scanner scan = new Scanner(new File("files", fileName));
        int id = 1;
        while (scan.hasNext()) {
            String[] country = scan.nextLine().split(Pattern.quote("|"));
            try {
                countries.add(new Countries(id, country[0], country[1], Integer.parseInt(country[2]), Integer.parseInt(country[3]), country[4], country[5]));
            } catch (ArrayIndexOutOfBoundsException e) {
                countries.add(new Countries(id, country[0], country[1], Integer.parseInt(country[2]), Integer.parseInt(country[3]), country[4], null));
            }
            id++;

        }
        return countries;
    }
}
