package com.anz.rpncalculator.impl;

import com.anz.rpncalculator.RpnCalculatorCordinatorService;
import com.anz.rpncalculator.exception.RpnCalculationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RpnCalculatorImplTest {

    @BeforeEach
    public void setupSpyStream() {
        rpn = new RpnCalculatorCordinatorServiceImpl();
    }

    @AfterEach
    public void clearSystem() {
        RpnCalculatorCordinatorService.previousCommands.clear();
    }

    private RpnCalculatorCordinatorService rpn;

    @Test
    public void testAdd_Success() {
        try {
            rpn.performCalculation("5 4 +");

            String expectedOutput = "9";
            assertEquals(expectedOutput, rpn.getRpnStackAsString().trim(), "Addition failed.");
        } catch (Exception e) {
            assertTrue(false, "Unexpected exception thrown - Failed.");
        }
    }

    @Test
    public void testSubtract_Success() {
        try {
            rpn.performCalculation("5 4 -");
            String expectedOutput = "1";
            assertEquals(expectedOutput, rpn.getRpnStackAsString().trim(), "Subtraction failed.");
        } catch (Exception e) {
            assertTrue(false, "Unexpected exception thrown - Failed.");
        }
    }

    @Test
    public void testMultiply_Success() {
        try {
            rpn.performCalculation("5 4 *");

            String expectedOutput = "20";
            assertEquals(expectedOutput, rpn.getRpnStackAsString().trim(), "Multiplication failed.");
        } catch (Exception e) {
            assertTrue(false, "Unexpected exception thrown - Failed.");
        }
    }

    @Test
    public void testDivision_Success() {
        try {
            rpn.performCalculation("5 4 /");

            String expectedOutput = "1.25";
            assertEquals(expectedOutput, rpn.getRpnStackAsString().trim(), "Division failed.");
        } catch (Exception e) {
            assertTrue(false, "Unexpected exception thrown - Failed.");
        }

    }

    @Test
    public void testDivision_InSufficient() {
        try {
            rpn.performCalculation("5 4 / /");
            assertTrue(false, "Unexpected exception thrown - Failed.");
        } catch (RpnCalculationException e) {
            assertEquals("operator / (position: 6): insufficient parameters", e.getErrorMessage(), "Division failed.");
        }

    }

    @Test
    public void testUndo_Success() {
        try {
            rpn.performCalculation("5 4 / undo");

            String expectedOutput = "5 4";
            assertEquals(expectedOutput, rpn.getRpnStackAsString().trim(), "Undo failed.");
        } catch (Exception e) {
            assertTrue(false, "Unexpected exception thrown - Failed.");
        }
    }

    @Test
    public void testSqrt_Success() {
        try {
            rpn.performCalculation("4 sqrt");

            String expectedOutput = "2";
            assertEquals(expectedOutput, rpn.getRpnStackAsString().trim(), "Sqrt failed.");
        } catch (Exception e) {
            assertTrue(false, "Unexpected exception thrown - Failed.");
        }
    }

    @Test
    public void testSqrtPrecision_Success() {
        try {
            rpn.performCalculation("2 sqrt");
            String expectedOutput = "1.4142135624";
            assertEquals(expectedOutput, rpn.getRpnStackAsString().trim(), "Sqrt failed.");
        } catch (Exception e) {
            assertTrue(false, "Unexpected exception thrown - Failed.");
        }
    }

    @Test
    public void testMultilineAdd_Success() {
        try {
            rpn.performCalculation("5 4 + 3 +");

            String expectedOutput = "12";
            assertEquals(expectedOutput, rpn.getRpnStackAsString().trim(), "multiline failed.");
        } catch (Exception e) {
            assertTrue(false, "Unexpected exception thrown - Failed.");
        }
    }
}
