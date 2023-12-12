package org.itmo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Direction {
    private String name;
    private int placesInCommon;
    private int privilegePlaces;
    private int targetPlaces;
    private Division[] divisions;
    private Subject[] subjects;
}
