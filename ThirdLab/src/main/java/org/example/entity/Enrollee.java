package org.example.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

@Data
@NoArgsConstructor(force = true)
public class Enrollee {
    @Getter
    private int id;
    @Getter
    private Subject[] subjects;
    @Getter
    private Division[] division;
    @Getter
    private boolean privileges;
    @Getter
    private boolean target;

    private Division originalsToDivision;

    public Enrollee(int id, Subject[] subjects, Division[] division, boolean privileges, boolean target, Division originalsToDivision) {
        this.id = id;
        this.subjects = subjects;
        this.division = division;
        this.privileges = privileges;
        this.target = target;
        this.originalsToDivision = originalsToDivision;
    }

    public Division isOriginals() {
        return originalsToDivision;
    }

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }

    public void setDivision(Division[] division) {
        this.division = division;
    }

    public void setPrivileges(boolean privileges) {
        this.privileges = privileges;
    }

    public void setTarget(boolean target) {
        this.target = target;
    }

    public void setOriginals(Division originals) {
        this.originalsToDivision = originals;
    }

    @Override
    public String toString() {
        return "Enrollee{" +
                "id=" + id +
                ", subjects=" + Arrays.toString(subjects) +
                ", division=" + Arrays.toString(division) +
                ", privileges=" + privileges +
                ", target=" + target +
                ", originalsToDivision=" + originalsToDivision +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Enrollee enrollee)) return false;
        return getId() == enrollee.getId() && isPrivileges() == enrollee.isPrivileges() && isTarget() == enrollee.isTarget() && Arrays.equals(getSubjects(), enrollee.getSubjects()) && Arrays.equals(getDivision(), enrollee.getDivision()) && Objects.equals(originalsToDivision, enrollee.originalsToDivision);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), isPrivileges(), isTarget(), originalsToDivision);
        result = 31 * result + Arrays.hashCode(getSubjects());
        result = 31 * result + Arrays.hashCode(getDivision());
        return result;
    }
}