package org.itmo.database;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.itmo.entity.Enrollee;
import org.itmo.entity.Subject;

import java.util.List;

@Getter
@NoArgsConstructor
public class EnrolleeStorage {
    private List<Enrollee> enrolleeList;

    public EnrolleeStorage(List<Enrollee> enrolleeList) {
        this.enrolleeList = enrolleeList;
    }

    public void createEnrollee(Enrollee enrollee) {
        enrolleeList.add(enrollee);
    }

    public void updateEnrolleeScore(String name, int score, Enrollee enrollee) {
        Subject[] subjects = enrollee.getSubjects();
        for (Subject subject : subjects) {
            if (subject.getName().equals(name)) {
                subject.setScore(score);
            }
        }
    }

    public void deleteEnrollee(Enrollee enrollee) {
        enrolleeList.remove(enrollee);
    }

}
