package org.itmo.validator;

/**
 *
 */
public class Validator {
    /**
     *
     * @param name
     * @return
     */
    public static boolean validateRouteName(String name) {
        return !name.isBlank();
    }

    /**
     *
     * @param coordinates
     * @return
     */
    public static boolean validateRouteCoordinates(String coordinates) {
        String[] coord = coordinates.split(" ");
        if (coord.length != 2) {
            return false;
        } else {
            try {
                if (Double.valueOf(coord[0]) <= 660) {
                    return Integer.valueOf(coord[1]) <= 909;
                } else {
                    return false;
                }
            } catch (NumberFormatException numberFormatException) {
                return false;
            }
        }
    }

    /**
     *
     * @param coordinates
     * @return
     */
    public static boolean validateRouteLocationFrom(String coordinates) {
        String[] coord = coordinates.split(" ");
        if (coord.length != 3) {
            return false;
        } else {
            try {
                Long.valueOf(coord[0]);
                Double.valueOf(coord[1]);
                Float.valueOf(coord[2]);
            } catch (NumberFormatException numberFormatException) {
                return false;
            }
            return true;
        }
    }

    /**
     *
     * @param coordinates
     * @return
     */
    public static boolean validateRouteLocationTo(String coordinates) {
        String[] coord = coordinates.split(" ");
        if (coord.length != 3) {
            return false;
        } else {
            try {
                Double.valueOf(coord[0]);
                Long.valueOf(coord[1]);
                Integer.valueOf(coord[2]);
            } catch (NumberFormatException numberFormatException) {
                return false;
            }
            return true;
        }
    }

    /**
     *
     * @param distance
     * @return
     */
    public static boolean validateRouteDistance(String distance) {
        try {
            return (Integer.valueOf(distance)) >= 1;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }


}
