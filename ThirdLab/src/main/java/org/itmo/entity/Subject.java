package org.itmo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Subject {
    private String name;
    private int score;

    public Subject(String name) {
        this.setName(name);
    }

    public Subject(String name, int score) {
        this.name = name;
        this.score = score;
    }


}
