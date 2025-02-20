package org.itmo.client.runner;

import lombok.Setter;
import org.itmo.client.command.*;
import org.itmo.client.controller.Invoker;
import org.itmo.client.entity.User;
import org.itmo.client.exception.NotAvailableServer;
import org.itmo.client.login.RegistrationLogin;
import org.itmo.client.output.InfoPrinter;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Runner {
    @Setter
    private Socket socket;
    private Invoker invoker;
    private InfoPrinter commandPrinter;
    private final InfoPrinter infoPrinter;
    private InputStreamReader inputStreamReader;
    @Setter
    private User user;
    private BufferedReader br;

    public Runner(InfoPrinter commandPrinter, InputStreamReader inputStreamReader) {
        this.commandPrinter = commandPrinter;
        this.infoPrinter = new InfoPrinter(new PrintStream(System.out));
        this.inputStreamReader = inputStreamReader;
        br = new BufferedReader(inputStreamReader);

    }

    public Runner(InfoPrinter commandPrinter, InputStreamReader inputStreamReader, Socket socket) {
        this.commandPrinter = commandPrinter;
        this.infoPrinter = new InfoPrinter(new PrintStream(System.out));
        this.inputStreamReader = inputStreamReader;
        this.socket = socket;
        br = new BufferedReader(inputStreamReader);

    }

    public static Socket connectToServer() {
        Scanner scanner = new Scanner(System.in);
        Socket socket = null;

        while (true) {
            try {
                System.out.print("Введите адрес сервера: ");
                String host = scanner.nextLine();
                System.out.print("Введите порт сервера: ");
                int port = Integer.parseInt(scanner.nextLine());
                socket = new Socket();
                socket.connect(new InetSocketAddress(host, port), 1000);
                System.out.println("Вы успешно подключились к серверу");

                break; // Если удалось подключиться к серверу, выходим из цикла
            } catch (IOException | NumberFormatException e) {
                System.out.println("Ошибка подключения к серверу. Пожалуйста, проверьте введенные данные.");
            }
        }

        return socket;
    }


    public void runMethods(boolean isScript) throws IOException {
        if (!isScript) {
            this.socket = connectToServer();
            user = null;
            RegistrationLogin registrationLogin = new RegistrationLogin(socket, commandPrinter, inputStreamReader, user);
            user = registrationLogin.login();

        }

        initInvoker();
        runCommands(isScript);
    }


    private void initInvoker() {
        Map<String, Command> commandMap = fillCommandMap();
        invoker = new Invoker(commandMap);
    }


    private Map<String, Command> fillCommandMap() {

        Command infoCommand = new InfoCommand(socket, infoPrinter, inputStreamReader, user);
        Command showCommand = new ShowCommand(socket, infoPrinter, inputStreamReader, user);
        Command addCommand = new AddCommand(socket, commandPrinter, inputStreamReader, br, user);
        Command updateCommand = new UpdateCommand(socket, commandPrinter, inputStreamReader, br, user);
        Command removeByIdCommand = new RemoveByIdCommand(socket, commandPrinter, inputStreamReader, user);
        Command clearCommand = new ClearCommand(socket, infoPrinter, inputStreamReader, user);
        Command addMinCommand = new AddMinCommand(socket, commandPrinter, inputStreamReader, br, user);
        Command removeLowerCommand = new RemoveLowerCommand(socket, commandPrinter, inputStreamReader, user);
        Command historyCommand = new HistoryCommand(socket, infoPrinter, inputStreamReader, user);
        Command minByFromCommand = new MinByFromCommand(socket, infoPrinter, inputStreamReader, user);
        Command countRoutesLessDistanceCommand = new CountRoutesLessDistanceCommand(socket, infoPrinter, inputStreamReader, user);
        Command filterRoutesLessDistanceCommand = new FilterRoutesLessDistance(socket, infoPrinter, inputStreamReader, user);
        Command executeScript = new ExecuteScriptCommand(socket, infoPrinter, inputStreamReader, user);
        Command help = new HelpCommand(socket, infoPrinter, inputStreamReader, user);
        Command filter = new FilterCommand(socket, infoPrinter, inputStreamReader, br, user);
        Command filterInfo = new FilterInfoCommand(socket, infoPrinter, inputStreamReader, user);

        Map<String, Command> commandMap = new HashMap<>();
        commandMap.put("info", infoCommand);
        commandMap.put("show", showCommand);
        commandMap.put("add", addCommand);
        commandMap.put("update", updateCommand);
        commandMap.put("remove_by_id", removeByIdCommand);
        commandMap.put("clear", clearCommand);
        commandMap.put("add_if_min", addMinCommand);
        commandMap.put("remove_lower", removeLowerCommand);
        commandMap.put("history", historyCommand);
        commandMap.put("min_by_from", minByFromCommand);
        commandMap.put("count_less_than_distance", countRoutesLessDistanceCommand);
        commandMap.put("filter_less_than_distance", filterRoutesLessDistanceCommand);
        commandMap.put("execute_script", executeScript);
        commandMap.put("help", help);
        commandMap.put("filter", filter);
        commandMap.put("filter_info", filterInfo);

        return commandMap;
    }


    private void runCommands(boolean isScript) throws IOException {

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
            }
            try {
                if (!invoker.executeCommand(line)) {
                    infoPrinter.printLine("Неправильная команда");
                }
            } catch (NotAvailableServer e) {
                infoPrinter.printLine("Соединение с сервером потеряно, попробуйте переподключиться");
                runMethods(false);
            }
        }
        if (!ScriptsCounter.scriptsList.isEmpty()) {
            ScriptsCounter.scriptsSet.remove(ScriptsCounter.scriptsList.get(ScriptsCounter.scriptsList.size() - 1));
            ScriptsCounter.scriptsList.remove(ScriptsCounter.scriptsList.size() - 1);
        }
        if (isScript) {
            br.close();
        } else {
            exit();
        }

    }



    public void exit() throws IOException {
        socket.close();
        br.close();
        System.exit(0);
    }

}


