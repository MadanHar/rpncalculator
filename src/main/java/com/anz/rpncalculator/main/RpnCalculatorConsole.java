package com.anz.rpncalculator.main;

import java.util.Scanner;

import com.anz.rpncalculator.RpnCalculatorCordinatorService;
import com.anz.rpncalculator.exception.RpnCalculationException;
import com.anz.rpncalculator.impl.RpnCalculatorCordinatorServiceImpl;

/**
 * RPN Calculator console to interact with the calc via command line interface.
 *
 */

public class RpnCalculatorConsole {

	public static void main(String[] args) {
		RpnCalculatorCordinatorService rpnCalculatorCordinatorService = new RpnCalculatorCordinatorServiceImpl();

		// This is a bad coding pattern to put while.
		// However this is for demo and to always get input from user make it infinite
		// loop as per the requirement so that user can always enter input until program
		// exception is thrown.

		try (Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextLine()) {
				String inputString = scanner.nextLine();

				rpnCalculatorCordinatorService.performCalculation(inputString);
				System.out.println(rpnCalculatorCordinatorService.getRpnStackAsString());
			}
		} catch (RpnCalculationException ie) {
			System.out.println(
					ie.getErrorMessage() + "\n" + "Stack: " + rpnCalculatorCordinatorService.getRpnStackAsString());
			System.exit(0);
		}
	}
}
