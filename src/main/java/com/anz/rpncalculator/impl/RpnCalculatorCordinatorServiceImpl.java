package com.anz.rpncalculator.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.anz.rpncalculator.Command;
import com.anz.rpncalculator.RpnCalculatorCordinatorService;
import com.anz.rpncalculator.RpnCalculatorExecuteService;
import com.anz.rpncalculator.bean.RpnStack;
import com.anz.rpncalculator.exception.RpnCalculationException;
import com.anz.rpncalculator.util.CommandEnum;

/**
 *
 */
public class RpnCalculatorCordinatorServiceImpl implements RpnCalculatorCordinatorService {

    private RpnCalculatorExecuteService rpnCalculatorExecuteService;
    private RpnStack rpnStack;


    public RpnCalculatorCordinatorServiceImpl() {
        this.rpnCalculatorExecuteService = new RpnCalculatorExecuteServiceImpl();
        this.rpnStack = new RpnStack();
    }

    public void performCalculation(String input) throws RpnCalculationException {
        if (!input.replace(CommandEnum.UNDO.getCmd(), "").replace(CommandEnum.CLEAR.getCmd(), "").trim().isEmpty()) {
            previousCommands.add(input.replace(CommandEnum.UNDO.getCmd(), "").replace(CommandEnum.CLEAR.getCmd(), ""));
        }
        String commands = "";
        List<String> inputList = Stream.of(input.split(" ")).collect(Collectors.toList());
        int position = 0;
        for (String inputText : inputList) {
            position = position + 2;
            if (inputText.equalsIgnoreCase(CommandEnum.UNDO.getCmd()) && !previousCommands.isEmpty()) {
                String lastCommand = previousCommands.get(previousCommands.size() - 1);
                String[] commandTokens = lastCommand.split(" ");
                if (commandTokens.length > 1) {
                    commandTokens = Arrays.copyOf(commandTokens, commandTokens.length - 1);
                    previousCommands.remove(previousCommands.size() - 1);
                    previousCommands.add(String.join(" ", commandTokens));
                } else {
                    previousCommands.remove(previousCommands.size() - 1);
                }

                commands = String.join(" ", previousCommands);
                clearRpnStack();
            } else if (inputText.contains(CommandEnum.CLEAR.getCmd())) {
                previousCommands.clear();
                clearRpnStack();
            } else {
                commands = inputText;
            }
            if (!commands.isEmpty()) {
                rpnCalculatorExecuteService.computeTokens(Stream.of(commands.split(" ")).collect(Collectors.toList()), this.rpnStack, position-1);
            }
        }

    }

    public void performUndo() {

    }

    @Override
    public boolean addAllToRpnStack(List<String> cmdList) {
        return this.rpnStack.addAll(cmdList);
    }

    @Override
    public String getRpnStackAsString() {
        return this.rpnStack.toString();
    }

    @Override
    public void clearRpnStack() {
        this.rpnStack.clearStack();
    }

    @Override
    public void setCurrentLineCommandList(List<String> list) {
        this.rpnStack.setCurrentLineCommandList(list);
    }

}
