package org.itmo.client.command;

import org.apache.commons.lang3.ObjectUtils;
import org.itmo.client.output.InfoPrinter;
import org.itmo.client.validator.Validator;
import org.itmo.entity.Coordinates;
import org.itmo.entity.LocationFrom;
import org.itmo.entity.LocationTo;
import org.itmo.entity.Route;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.time.LocalDateTime;

public class RouteParser {
    private InfoPrinter printer;
    private BufferedReader br;

    RouteParser(InfoPrinter printer, BufferedReader br) {
        this.printer = printer;
        this.br = br;
    }

    protected Route parseRouteFromConsole(InputStreamReader inputStreamReader) {

        String line;
        try {
            printer.printLine("Введите имя Route: ");
            while (!Validator.validateRouteName(line = br.readLine())) {
                printer.printLine("Имя не может быть пустым!");
                printer.printLine("Введите имя Route: ");
            }
            String name = line;

            printer.printLine("Введите координаты x, y через пробел (x-дробный меньше 909, y-целый меньше 660): ");
            while (!Validator.validateRouteCoordinates(line = br.readLine())) {
                printer.printLine("Неверный ввод!");
                printer.printLine("Введите координаты x, y через пробел (x-дробный меньше 909, y-целый меньше 660): ");
            }
            String[] nums = line.split(" ");
            Coordinates coordinates = new Coordinates(Double.parseDouble(nums[0]), Integer.parseInt(nums[1]));

            printer.printLine("Вы хотите задать поле LocationFrom?(Y/N)");
            LocationFrom locationFrom;
            while (!(((line = br.readLine()).equals("Y")) || (line.equals("N")))) {
                printer.printLine("Неверный ввод!");
            }
            if (line.equals("Y")) {
                printer.printLine("Введите координаты x, y, z локации из которой вы едете(x-целый, y-дробный, z-дробный): ");
                while (!Validator.validateRouteLocationFrom(line = br.readLine())) {
                    printer.printLine("Неверный ввод!");
                    printer.printLine("Введите координаты x, y, z локации из которой вы едете(x-целый, y-дробный, z-дробный): ");
                }
                nums = line.split(" ");

                printer.printLine("Введите имя локации откуда вы уехали: ");
                String locationName;
                if ((line = br.readLine()).isEmpty()) {
                    locationName = null;
                } else {
                    locationName = line;
                }
                locationFrom = new LocationFrom(Long.parseLong(nums[0]), Double.parseDouble(nums[1]), Float.parseFloat(nums[2]), locationName);
            } else {
                locationFrom = null;
            }

            printer.printLine("Введите координаты x, y, z локации в которую вы едете(x-дробный, y-целый, z-целый): ");
            while (!Validator.validateRouteLocationTo(line = br.readLine())) {
                printer.printLine("Неверный ввод!");
                printer.printLine("Введите координаты x, y, z локации в которую вы едете(x-дробный, y-целый, z-целый): ");
            }
            nums = line.split(" ");

            LocationTo locationTo = new LocationTo(Double.parseDouble(nums[0]), Long.parseLong(nums[1]), Integer.parseInt(nums[2]));

            printer.printLine("Введите дистанцию(натуральное число)");
            Integer distance;
            while (!Validator.validateRouteDistance(line = br.readLine())) {
                printer.printLine("Неверный ввод!");
                printer.printLine("Введите дистанцию(натуральное число)");
            }
            if (line.isBlank()) {
                distance = null;
            } else {
                distance = Integer.parseInt(line);
            }
            Route route = new Route(-1, name, coordinates, null, locationFrom, locationTo, distance);
            return route;
        } catch (IOException | NullPointerException n) {
            printer.printLine("Неправильная команда");
            return null;
        }

    }
}
