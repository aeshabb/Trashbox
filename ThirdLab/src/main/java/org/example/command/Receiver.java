package org.example.command;

import org.example.database.DirectionStorage;
import org.example.database.EnrolleeStorage;
import org.example.entity.Direction;
import org.example.entity.Division;
import org.example.entity.Enrollee;
import org.example.entity.Subject;

import java.util.ArrayList;
import java.util.List;

public class Receiver {
    private final EnrolleeStorage enrolleeStorage;
    private final DirectionStorage directionStorage;

    public Receiver(EnrolleeStorage enrolleeStorage, DirectionStorage directionStorage) {
        this.enrolleeStorage = enrolleeStorage;
        this.directionStorage = directionStorage;
    }

    public void deleteById(int id) {
        for (int i = 0; i < enrolleeStorage.getEnrolleeList().size(); i++) {
            if (enrolleeStorage.getEnrolleeList().get(i).getId() == id) {
                deleteEnrollee(enrolleeStorage.getEnrolleeList().get(i));
            }
        }
    }

    public void deleteEnrollee(Enrollee enrollee) {
        enrolleeStorage.deleteEnrollee(enrollee);
    }

    public Enrollee getEnrolleeById(int id) {
        Enrollee enrolleeToSearch = null;
        for (Enrollee enrollee : enrolleeStorage.getEnrolleeList()) {
            if (enrollee.getId() == id) {
                enrolleeToSearch = enrollee;
            }
        }
        return enrolleeToSearch;
    }

    public void updateEnrolleeScore(String name, int score, Enrollee enrollee) {
        enrolleeStorage.updateEnrolleeScore(name, score, enrollee);
    }

    public void changeDirName(String oldName, String newName) {
        directionStorage.changeDirName(oldName, newName);
    }

    public List<Direction> getDirectionList() {
        return directionStorage.getDirectionList();
    }

    public List<Enrollee> getEnrolleeList() {
        return enrolleeStorage.getEnrolleeList();
    }

    public int getSubjectScore(Enrollee enrollee, String name) {
        int score = 0;
        Subject[] subjects = enrollee.getSubjects();
        for (Subject subject : subjects) {
            if (subject.getName().equals(name)) {
                score = subject.getScore();
            }
        }
        return score;
    }

    public List<Enrollee> getEnrolleesWithOriginals(String division) {
        List<Enrollee> enrolleesWithOriginals = new ArrayList<>();
        for (Enrollee enrollee : enrolleeStorage.getEnrolleeList()) {
            if ((enrollee.isOriginals()).getName().equals(division)) {
                enrolleesWithOriginals.add(enrollee);
            }
        }
        return enrolleesWithOriginals;
    }

    public int getEnterPoints(String name) {
        List<Integer> originalsList = new ArrayList<>();
        for (Enrollee enrollee : enrolleeStorage.getEnrolleeList()) {
            for (Division division : enrollee.getDivision()) {
                if (division.getName().equals(name)) {
                    if (enrollee.getOriginalsToDivision().getName() != null && (enrollee.getOriginalsToDivision().getName()).equals(name)) {
                        originalsList.add(310);
                    } else {
                        int summ = 0;
                        for (Subject subject : enrollee.getSubjects()) {
                            summ += subject.getScore();
                        }
                        originalsList.add(summ);
                    }
                }
            }
        }
        int places = getDirectionFromDivisionsName(name).getPlacesInCommon();
        if (originalsList.size() > places) {
            return originalsList.get(places - 1);
        } else {
            return 0;
        }

    }

    public Direction getDirectionFromDivisionsName(String name) {
        Direction directionToFind = null;
        for (Direction direction : directionStorage.getDirectionList()) {
            for (Division division : direction.getDivisions()) {
                if (division.getName().equals(name)) {
                    directionToFind = direction;
                    break;
                }
            }
        }
        return directionToFind;
    }
}