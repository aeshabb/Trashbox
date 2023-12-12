package org.itmo.runner;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.itmo.Main;
import org.itmo.command.*;
import org.itmo.controller.Invoker;
import org.itmo.database.DirectionStorage;
import org.itmo.database.EnrolleeStorage;
import org.itmo.entity.AuxiliaryObject;
import org.itmo.entity.Direction;
import org.itmo.entity.Enrollee;
import org.itmo.output.Printer;
import org.itmo.reader.ReadCommands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Runner {
    private List<Enrollee> enrolleeList;
    private List<Direction> directionList;
    private EnrolleeStorage enrolleeStorage;
    private DirectionStorage directionStorage;
    private Invoker invoker;

    public void runMethods() throws IOException {
        fillEnrAndDirLists();
        initStorages();
        initInvoker();
        runCommands();
    }

    private void fillEnrAndDirLists() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        java.io.InputStream inputStream = Main.class.getResourceAsStream("/db.json");
        AuxiliaryObject auxiliaryObject = mapper.readValue(inputStream, AuxiliaryObject.class);

        enrolleeList = auxiliaryObject.getEnrollees();
        directionList = auxiliaryObject.getDirections();
    }

    private void initStorages() {
        enrolleeStorage = new EnrolleeStorage(enrolleeList);
        directionStorage = new DirectionStorage(directionList);
    }

    private void initInvoker() throws IOException {
        Receiver receiver = new Receiver(enrolleeStorage, directionStorage);
        Printer printer = new Printer();
        Map<String, Command> commandMap = fillCommandMap(receiver, printer);
        invoker = new Invoker(commandMap);
    }

    private Map<String, Command> fillCommandMap(Receiver receiver, Printer printer) {
        Command changeDirName = new ChangeDirNameCommand(receiver, "Изменить название направления: \"changeDirName + (старое название) + > + (новое название)\"", printer);
        Command update = new UpdateScoreCommand(receiver, "Изменить балл ЕГЭ абитуриента: \"updateScore + (id абитуриента) + (название предмета) + (балл предмета)\"", printer);
        Command compare = new CompareScoreCommand(receiver, "Сравнить баллы двух абитуриентов: \"compare + (id первого) + (id второго) + (название предмета)\"", printer);
        Command delete = new DeleteByIdCommand(receiver, "Удалить абитуриента по id: \"delete + (id абитуриента)\"", printer);
        Command showOriginals = new ShowEnrolleesWithOriginalsCommand(receiver, "Вывести количество абитуриентов с оригиналами на программе: \"showOriginals + (название программы)\"", printer);
        Command showEnrollees = new ShowAllEnrolleesCommand(receiver, "Вывести список абитуриентов: \"showAllEnrollees\"", printer);
        Command showDirections = new ShowAllDirectionsCommand(receiver, "Вывести список направлений: \"showAllDirections\"", printer);
        Command showEnterPoints = new ShowEnterPointsCommand(receiver, "Показать проходной балл на направлении: \"showEnterPoints + (название направления)\"", printer);
        Command showEnrolleesWithFirstPriority = new ShowEnrolleesWithFirstPriorityCommand(receiver, "Показать абитуриентов с первым приоритетом: \"showFirstPriority + (название направления)\"", printer);
        Command showEnterPointsIfOriginalsCommand = new ShowEnterPointsIfOriginalsCommand(receiver, "Показать проходной балл на направлении если все принесут оригиналы \"showEnterPointsOriginals + (название направления)\"", printer);
        Command showEnrolleesOnDirectionCommand = new ShowEnrolleesOnDirectionCommand(receiver, "Показать список абитуриентов по убыванию: \"showEnrolleesOnDirection + (название направления)\"", printer);

        Map<String, Command> commandMap = new HashMap<>();

        commandMap.put("changeDirName", changeDirName);
        commandMap.put("delete", delete);
        commandMap.put("updateScore", update);
        commandMap.put("compare", compare);
        commandMap.put("showOriginals", showOriginals);
        commandMap.put("showAllEnrollees", showEnrollees);
        commandMap.put("showAllDirections", showDirections);
        commandMap.put("showEnterPoints", showEnterPoints);
        commandMap.put("showFirstPriority", showEnrolleesWithFirstPriority);
        commandMap.put("showEnterPointsOriginals", showEnterPointsIfOriginalsCommand);
        commandMap.put("showEnrolleesOnDirection", showEnrolleesOnDirectionCommand);

        Command help = new HelpCommand(receiver, "Вывести список команд: \"help\"", printer, createDescriptionMap(commandMap));
        commandMap.put("help", help);

        return commandMap;
    }

    private void runCommands() throws IOException {
        invoker.executeCommand("help");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ReadCommands readCommands = new ReadCommands(br);
        String line;
        while (!(line = readCommands.readConsoleString()).equals("quit")) {
            invoker.executeCommand(line);
        }
        readCommands.stopStream();
    }

    private List<String> createDescriptionMap(Map<String, Command> commandMap) {
        List<String> descriptionList = new ArrayList<>();
        for (String key : commandMap.keySet()) {
            descriptionList.add(commandMap.get(key).getDescription());
        }
        return descriptionList;
    }
}
