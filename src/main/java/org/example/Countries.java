package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class Countries {
    private int id;
    private final String name;
    private final String capital;
    private final Integer population;
    private final Integer area;
    private final String continent;
    private final String neighbour;
}
