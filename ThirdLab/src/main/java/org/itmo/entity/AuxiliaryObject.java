package org.itmo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuxiliaryObject implements Serializable {
    private List<Enrollee> enrollees;
    private List<Direction> directions;
}
