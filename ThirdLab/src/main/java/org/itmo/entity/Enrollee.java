package org.itmo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Enrollee {
    private int id;
    private Subject[] subjects;
    private Division[] division;
    private boolean wet;
    private boolean privileges;
    private boolean target;
    private Division originalsToDivision;

    public int getSubjectsScore() {
        int subjectsSumm = 0;
        for (Subject subject : getSubjects()) {
            subjectsSumm += subject.getScore();
        }
        return subjectsSumm;
    }
}
