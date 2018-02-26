package com.jefftc.engine;

import com.jefftc.viral.ViralSimulationData;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommandTest {

    private static Command[] commands;

    /**
     * Prepare for tests
     */
    @BeforeClass
    public static void setup() {
        commands = ViralSimulationData.COMMANDS;
    }

    /**
     * Test if the Command can detect itself in a regular input string
     */
    @Test
    public void matchFormatTest() {
        assertTrue(commands[ViralSimulationData.CMD_QUIT].matchFormat("quit"));
        assertFalse(commands[ViralSimulationData.CMD_QUIT].matchFormat("list"));
    }

    /**
     * Test if a command is recognized by a secondary accepted stem
     */
    @Test
    public void matchFormatSecondaryTest() {
        assertTrue(commands[ViralSimulationData.CMD_INFO].matchFormat("status"));
    }

    /**
     * Test if a command that doesn't require a body can be detected even with one
     */
    @Test
    public void matchFormatUnexpectedBodyTest() {
        assertTrue(commands[ViralSimulationData.CMD_QUIT].matchFormat("quit this shouldn't be here"));
    }

    /**
     * Test if a command that requires a body will be detected if there isn't one
     */
    @Test
    public void matchFormatMissingBodyTest() {
        assertTrue(commands[ViralSimulationData.CMD_INFO].matchFormat("info"));
        assertTrue(commands[ViralSimulationData.CMD_INFO].matchFormat("info "));
    }

    /**
     * Test if a command can be detected when extra spaces are before and/or after it
     */
    @Test
    public void matchFormatSpacedOutTest() {
        assertTrue(commands[ViralSimulationData.CMD_QUIT].matchFormat("    quit  "));
        assertTrue(commands[ViralSimulationData.CMD_INFO].matchFormat("  info   place"));
    }

    /**
     * Test if a command can be detected even if tabs are used instead of spaces
     */
    @Test
    public void matchFormatWithTabTest() {
        assertTrue(commands[ViralSimulationData.CMD_INFO].matchFormat("\tinfo\tsome\tcountry"));
    }

    /**
     * Test detecting a command from just spaces
     */
    @Test
    public void matchFormatJustSpacesTest() {
        assertFalse(commands[ViralSimulationData.CMD_INFO].matchFormat("    "));
    }

    /**
     * Test detecting a command on an empty string
     */
    @Test
    public void matchFormatEmptyTest() {
        assertFalse(commands[ViralSimulationData.CMD_QUIT].matchFormat(""));
    }

    /**
     * Test getting the primary command stem
     */
    @Test
    public void getCommandTest() {
        assertEquals("info", commands[ViralSimulationData.CMD_INFO].getCommand());
    }

    /**
     * Test getting the body from a command
     */
    @Test
    public void getBodyTest() {
        assertEquals("country",
                commands[ViralSimulationData.CMD_INFO].getBody("info country"));
    }

    /**
     * Test getting the body from a command followed by just spaces
     */
    @Test
    public void getBodyJustSpacesTest() {
        assertEquals("", commands[ViralSimulationData.CMD_INFO].getBody("  info   "));
    }

    /**
     * Test getting the body from a command when there is no body
     */
    @Test
    public void getBodyEmptyTest() {
        assertEquals("", commands[ViralSimulationData.CMD_INFO].getBody(""));
    }

    /**
     * Test getting the body separated by a tab
     */
    @Test
    public void getBodyTabsTest() {
        assertEquals("country",
                commands[ViralSimulationData.CMD_INFO].getBody("info\tcountry"));
    }

    /**
     * Test getting the body from a command even if it does not expect one
     */
    @Test
    public void getBodyUnexpectedTest() {
        assertEquals("stuff here",
                commands[ViralSimulationData.CMD_QUIT].getBody("quit stuff here"));
    }

}