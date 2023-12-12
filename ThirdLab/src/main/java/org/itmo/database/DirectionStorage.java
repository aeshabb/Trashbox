package org.itmo.database;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.itmo.entity.Direction;

import java.util.List;
@Getter
@NoArgsConstructor
public class DirectionStorage {
    private List<Direction> directionList;

    public DirectionStorage(List<Direction> directionList) {
        this.directionList = directionList;
    }

    public void createDirection(Direction direction) {
        directionList.add(direction);
    }

    public void changeDirName(String oldName, String newName) {
        for (Direction direction : directionList) {
            if (direction.getName().equals(oldName)) {
                direction.setName(newName);
            }
        }
    }

    public void deleteDirection(Direction direction) {
        directionList.remove(direction);
    }

}
