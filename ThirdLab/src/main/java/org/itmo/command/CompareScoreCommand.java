package org.itmo.command;

import org.itmo.entity.Enrollee;
import org.itmo.output.Printer;

public class CompareScoreCommand extends Command {
    public CompareScoreCommand(Receiver receiver, String description, Printer printer) {
        super(receiver, description, printer);
    }


    @Override
    public void execute(String[] parameters) {
        Enrollee enrollee1 = receiver.getEnrolleeById(Integer.parseInt(parameters[0]));
        Enrollee enrollee2 = receiver.getEnrolleeById(Integer.parseInt(parameters[1]));
        int enrolleeScore1 = receiver.getSubjectScore(enrollee1, parameters[2]);
        int enrolleeScore2 = receiver.getSubjectScore(enrollee2, parameters[2]);
        printer.printLine("У первого абитуриента: " + enrolleeScore1 + " баллов. По предмету: " + parameters[2]);
        printer.printLine("У второго абитуриента: " + enrolleeScore2 + " баллов. По предмету: " + parameters[2]);
    }

}
