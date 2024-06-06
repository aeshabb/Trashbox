package org.itmo.runner;

import com.opencsv.exceptions.CsvException;
import org.itmo.command.*;
import org.itmo.controller.Invoker;
import org.itmo.database.RouteStorage;
import org.itmo.entity.Route;
import org.itmo.output.CommandPrinter;
import org.itmo.reader.ReaderCSV;

import java.io.*;
import java.util.*;

/**
 * Runner для начала работы программы.
 */
public class Runner {
    private Invoker invoker;
    private RouteStorage routeStorage;
    private CommandPrinter commandPrinter;
    private CommandPrinter infoPrinter;

    /**
     *
     * @param commandPrinter задаем режим работы Runner.
     */
    public Runner(CommandPrinter commandPrinter) {
        this.commandPrinter = commandPrinter;
    }

    /**
     *
     * @param inputStream
     * @param isScript
     * @throws IOException
     * @throws CsvException
     */
    public void runMethods(InputStream inputStream, boolean isScript) throws IOException, CsvException {
        initInvoker(commandPrinter);
        runCommands(inputStream, isScript);
    }


    /**
     *
     * @param printer
     */
    private void initInvoker(CommandPrinter printer) {
        this.routeStorage = new RouteStorage((TreeSet<Route>) ReaderCSV.getRouteSet(), ReaderCSV.getInitTimeSet());
        Receiver receiver = new Receiver(routeStorage);
        Map<String, Command> commandMap = fillCommandMap(receiver, printer);
        invoker = new Invoker(commandMap);
    }

    /**
     *
     * @param receiver
     * @param printer
     * @return
     */
    private Map<String, Command> fillCommandMap(Receiver receiver, CommandPrinter printer) {
        PrintStream printStream = new PrintStream(System.out);
        CommandPrinter infoPrinter = new CommandPrinter(printStream);
        this.infoPrinter = infoPrinter;

        Command infoCommand = new InfoCommand(receiver, "Информация о коллекции: \"info\"", infoPrinter);
        Command showCommand = new ShowCommand(receiver, "Вывести коллекцию: \"show\"", infoPrinter);
        Command addCommand = new AddCommand(receiver, "Добавить элемент в коллекцию: \"add\"", printer);
        Command updateCommand = new UpdateCommand(receiver, "Заменить элемент в колекции по id: \"update + (id)\"", printer);
        Command removeByIdCommand = new RemoveByIdCommand(receiver, "Удалить Route по id из коллекции: \"remove_by_id + (id)\"", printer);
        Command clearCommand = new ClearCommand(receiver, "Очистить коллекцию: \"clear\"", infoPrinter);
        Command saveCommand = new SaveCommand(receiver, "Сохранить коллекцию в файл \"save\"", infoPrinter);
        Command addMinCommand = new AddMinCommand(receiver, "Добавить элемент в коллекцию, если он минимальный: \"add_if_min\"", printer);
        Command removeLowerCommand = new RemoveLowerCommand(receiver, "Удалить все элементы, меньше данного: \"remove_lower + (distance)\"", printer);
        Command historyCommand = new HistoryCommand(receiver, "Вывести историю: \"history\"", infoPrinter);
        Command minByFromCommand = new MinByFromCommand(receiver, "Вывести Route с минимальным полем LocationFrom: \"min_by_from\"", infoPrinter);
        Command countRoutesLessDistanceCommand = new CountRoutesLessDistanceCommand(receiver, "Вывести количество Route с меньшим полем distance: \"count_less_than_distance + (distance)\"", infoPrinter);
        Command filterRoutesLessDistanceCommand = new FilterRoutesLessDistance(receiver, "Вывести Route с меньшим полем distance: \"filter_less_than_distance + (distance)\"", infoPrinter);
        Command executeScript = new ExecuteScriptCommand(receiver, "Чтение комманд со скрипта: \"execute_script + (filename)\"", infoPrinter);

        Map<String, Command> commandMap = new HashMap<>();
        commandMap.put("info", infoCommand);
        commandMap.put("show", showCommand);
        commandMap.put("add", addCommand);
        commandMap.put("update", updateCommand);
        commandMap.put("remove_by_id", removeByIdCommand);
        commandMap.put("clear", clearCommand);
        commandMap.put("save", saveCommand);
        commandMap.put("add_if_min", addMinCommand);
        commandMap.put("remove_lower", removeLowerCommand);
        commandMap.put("history", historyCommand);
        commandMap.put("min_by_from", minByFromCommand);
        commandMap.put("count_less_than_distance", countRoutesLessDistanceCommand);
        commandMap.put("filter_less_than_distance", filterRoutesLessDistanceCommand);
        commandMap.put("execute_script", executeScript);

        Command help = new HelpCommand(receiver, "Вывести список команд: \"help\"", infoPrinter, createDescriptionList(commandMap));
        commandMap.put("help", help);

        return commandMap;
    }

    /**
     *
     * @param inputStream
     * @param isScript
     * @throws IOException
     */
    private void runCommands(InputStream inputStream, boolean isScript) throws IOException {

        invoker.executeCommand("help");
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while (!"exit".equals(line = br.readLine())) {
            if (line == null) {
                break;
            } else {
                if (isScript) {
                    if (line.split(" ").length == 2) {
                        String[] par = line.split(" ");
                        if (par[0].equals("execute_script")) {
                            ScriptsCounter.scriptsList.add(par[1]);
                            ScriptsCounter.scriptsSet.add(par[1]);
                            if (ScriptsCounter.scriptsList.size() != ScriptsCounter.scriptsSet.size()) {
                                infoPrinter.printLine("Рекурсия!!!");
                                break;
                            }
                        }
                    }
                } else {
                    if (line.split(" ").length == 2) {
                        String[] par = line.split(" ");
                        if (par[0].equals("execute_script")) {
                            ScriptsCounter.scriptsList.clear();
                            ScriptsCounter.scriptsSet.clear();
                            ScriptsCounter.scriptsSet.add(par[1]);
                            ScriptsCounter.scriptsList.add(par[1]);
                        }
                    }
                }


                if (!invoker.executeCommand(line)) {
                    commandPrinter.printLine("Неправильная команда");
                }
            }
        }
        if (!ScriptsCounter.scriptsList.isEmpty()) {
            ScriptsCounter.scriptsSet.remove(ScriptsCounter.scriptsList.get(ScriptsCounter.scriptsList.size() - 1));
            ScriptsCounter.scriptsList.remove(ScriptsCounter.scriptsList.size() - 1);
        }

        br.close();
    }


    /**
     *
     * @param commandMap
     * @return
     */
    private List<String> createDescriptionList(Map<String, Command> commandMap) {
        List<String> descriptionList = new ArrayList<>();
        for (String key : commandMap.keySet()) {
            descriptionList.add(commandMap.get(key).getDescription());
        }
        return descriptionList;
    }
}
