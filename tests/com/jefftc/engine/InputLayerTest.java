package com.jefftc.engine;

import com.jefftc.viral.ViralSimulationData;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class InputLayerTest {

    private InputLayer io = new InputLayer(false);

    private static final String TEST_INPUT_1 = "This is a test";
    private static final String TEST_INPUT_2 = "THIS IS ANOTHER TEST";

    /**
     * Reset the InputLayer before each test
     */
    @Before
    public void reset() {
        io = new InputLayer(false);
        io.init(ViralSimulationData.COMMANDS);
    }

    /**
     * Test the input method using predefined data in place of a scanner
     */
    @Test
    public void receiveInputTest() {
        io.predefinedInput.add(TEST_INPUT_1);
        io.predefinedInput.add(TEST_INPUT_2);

        assertEquals(TEST_INPUT_1, io.receiveInput());
        assertEquals(TEST_INPUT_1, io.inputHistory.get(0));
        assertEquals(TEST_INPUT_2, io.receiveInput());
        assertEquals(TEST_INPUT_2, io.inputHistory.get(1));
    }

    /**
     * Test the input method using predefined data of an empty string
     */
    @Test
    public void receiveInputEmptyTest() {
        String testInput = "";
        io.predefinedInput.add(testInput);

        assertEquals("", io.receiveInput());
        assertTrue(io.inputHistory.isEmpty());
    }

    /**
     * Test the input method using predefined data of just spaces
     */
    @Test
    public void receiveInputSpacesTest() {
        String testInput = "     ";
        io.predefinedInput.add(testInput);

        assertEquals("", io.receiveInput());
        assertTrue(io.inputHistory.isEmpty());
    }

    /**
     * Test expecting a boolean
     */
    @Test
    public void expectBooleanTest() {
        io.predefinedInput.add("yes");
        boolean receivedBoolean = io.expectBoolean();
        assertTrue(receivedBoolean);
    }

    /**
     * Test expecting a boolean but receiving something else
     */
    @Test
    public void expectBooleanNotBooleanTest() {
        io.predefinedInput.add("hello");
        io.predefinedInput.add("0");
        boolean receivedBoolean = io.expectBoolean();
        assertFalse(receivedBoolean);
    }

    /**
     * Test expecting an int
     */
    @Test
    public void expectIntTest() {
        io.predefinedInput.add("5");
        int receivedInt = io.expectInt(0, 6);
        assertEquals(5, receivedInt);
    }

    /**
     * Test expecting an int and receiving one out of bounds
     */
    @Test
    public void expectIntOutOfBoundsTest() {
        io.predefinedInput.add("10");
        io.predefinedInput.add("2");
        int receivedInt = io.expectInt(0, 6);
        assertEquals(2, receivedInt);
    }

    /**
     * Test expecting an int and receiving a string
     */
    @Test
    public void expectIntNotIntTest() {
        io.predefinedInput.add("hello");
        io.predefinedInput.add("9");
        int receivedInt = 9;
        assertEquals(9, receivedInt);
    }

    /**
     * Test the output logging method alternative to println
     */
    @Test
    public void printlnTest() {
        io.println(TEST_INPUT_1);
        io.println(TEST_INPUT_2);

        assertEquals(TEST_INPUT_1, io.outputHistory.get(0));
        assertEquals(TEST_INPUT_2, io.outputHistory.get(1));
    }

    /**
     * Test the output logging method with a spaced out string
     */
    @Test
    public void printlnSpacedOutTest() {
        io.println("   This  is a     test  ");
        assertEquals(TEST_INPUT_1, io.outputHistory.get(0));
    }

    /**
     * Test the output logging method with an empty string
     */
    @Test
    public void printlnEmptyTest() {
        io.println("");
        assertTrue(io.outputHistory.isEmpty());
    }

    /**
     * Test the output logging method with just spaces
     */
    @Test
    public void printlnSpacesTest() {
        io.println("    ");
        assertTrue(io.outputHistory.isEmpty());
    }

    /**
     * Test the command detection with expected input
     */
    @Test
    public void detectCommandTest() {
        io.predefinedInput.add("quit");
        io.predefinedInput.add("info blah");

        assertEquals("quit", io.detectCommand(io.receiveInput()).getCommand());
        assertEquals("info", io.detectCommand(io.receiveInput()).getCommand());
    }

    /**
     * Test the command detection with alternate versions of command stems
     * aka "exit" is another accepted version of "quit"
     */
    @Test
    public void detectCommandAltTest() {
        io.predefinedInput.add("exit");
        assertEquals("quit", io.detectCommand(io.receiveInput()).getCommand());
    }

    /**
     * Test command detection with a command followed by a body that shouldn't be there
     */
    @Test
    public void detectCommandUnexpectedBodyTest() {
        io.predefinedInput.add("quit extra garbage");
        assertEquals("quit", io.detectCommand(io.receiveInput()).getCommand());
    }

    /**
     * Test command detection with a spaced out command
     */
    @Test
    public void detectCommandSpacedOutTest() {
        io.predefinedInput.add("   info   an item ");
        assertEquals("info", io.detectCommand(io.receiveInput()).getCommand());
    }

    /**
     * Test command detection being case insensitive
     */
    @Test
    public void detectCommandMixedCaseTest() {
        io.predefinedInput.add("ExIt");
        assertEquals("quit", io.detectCommand(io.receiveInput()).getCommand());
    }

    /**
     * Test command detection with an empty string
     */
    @Test
    public void detectCommandEmptyTest() {
        io.predefinedInput.add("");
        assertNull(io.detectCommand(io.receiveInput()));
    }

    /**
     * Test command detection with a string of spaces
     */
    @Test
    public void detectCommandJustSpacesTest() {
        io.predefinedInput.add("   ");
        assertNull(io.detectCommand(io.receiveInput()));
    }

    /**
     * Get the printed bar given a fractional value
     */
    @Test
    public void printableStatusTest() {
        assertEquals(
                "█████████████████████████████████████████████░░░░░ 90%",
                InputLayer.printableStatus(0.9, 1.0)
        );
    }

    /**
     * Get the printed bar when given a value over the base value
     */
    @Test
    public void printableStatusOverflowTest() {
        assertEquals(
                "██████████████████████████████████████████████████ 200%",
                InputLayer.printableStatus(2.0, 1.0)
        );
    }

    /**
     * Get a printable format of a double
     */
    @Test
    public void printableDoubleTest() {
        assertEquals("3.14", InputLayer.printableDouble(3.14));
    }

    /**
     * Get a printable format of a double that is a whole number
     */
    @Test
    public void printableDoubleWholeNumberTest() {
        assertEquals("100.00", InputLayer.printableDouble(100));
    }

    /**
     * Test comparing an array with a list of the same objects
     */
    @Test
    public void compareWithListTest() {
        String[] stringArray = TEST_INPUT_1.split(" ");
        List<String> stringList = Arrays.asList(stringArray);
        assertTrue(InputLayer.compareWithList(stringList, stringArray));
    }

    /**
     * Test comparing an array with a list of a different number of objects
     */
    @Test
    public void compareWithListDifferentSizeTest() {
        String[] stringArray = TEST_INPUT_1.split(" ");
        List<String> stringList = Arrays.asList("some words".split(" "));
        assertFalse(InputLayer.compareWithList(stringList, stringArray));
    }

    /**
     * Test comparing an array with a list that has a different case
     */
    @Test
    public void compareWithListCaseSensitiveTest() {
        String[] stringArray = TEST_INPUT_1.split(" ");
        List<String> stringList = Arrays.asList(TEST_INPUT_1.toUpperCase().split(" "));
        assertFalse(InputLayer.compareWithList(stringList, stringArray));
    }

    /**
     * Test comparing an array with a list of different values
     */
    @Test
    public void compareWithListDifferentValuesTest() {
        String[] stringArray = TEST_INPUT_1.split(" ");
        List<String> stringList = Arrays.asList("have some random words".split(" "));
        assertFalse(InputLayer.compareWithList(stringList, stringArray));
    }

    /**
     * Test comparing an array with a list when one is null
     */
    @Test
    public void compareWithListOneNullTest() {
        String[] stringArray = TEST_INPUT_1.split(" ");
        List<String> stringList = Arrays.asList(TEST_INPUT_1.split(" "));

        assertFalse(InputLayer.compareWithList(stringList, null));
        assertFalse(InputLayer.compareWithList(null, stringArray));
    }

    /**
     * Test comparing an array with a list when both are null
     */
    @Test
    public void compareWithListBothNullTest() {
        assertTrue(InputLayer.compareWithList(new ArrayList<>(), null));
        assertTrue(InputLayer.compareWithList(null, null));
    }


}