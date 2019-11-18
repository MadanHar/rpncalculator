package com.anz.rpncalculator;

import java.util.ArrayList;
import java.util.List;

import com.anz.rpncalculator.exception.RpnCalculationException;

/**
 * This is a spec for coordination service which basically interacts with
 * multiple services classes to acheive desired result.
 *
 */
public interface RpnCalculatorCordinatorService {

    List<String> previousCommands = new ArrayList<>();

    void performCalculation(String input) throws RpnCalculationException;

    boolean addAllToRpnStack(List<String> cmdList);

    String getRpnStackAsString();

    void clearRpnStack();

    void setCurrentLineCommandList(List<String> list);
}
