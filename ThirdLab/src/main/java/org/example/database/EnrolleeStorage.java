package org.example.database;

import org.example.entity.Enrollee;
import org.example.entity.Subject;

import java.util.List;

public class EnrolleeStorage {
    private List<Enrollee> enrolleeList;

    public EnrolleeStorage() {
    }

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

    public List<Enrollee> getEnrolleeList() {
        return enrolleeList;
    }
}