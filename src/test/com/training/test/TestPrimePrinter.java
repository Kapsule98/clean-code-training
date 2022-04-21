package com.training.test;

import com.training.before.PrimePrinter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestPrimePrinter {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
    @Test
    public void testPrimePrinter() throws IOException {
        String[] args = null;
        PrimePrinter.main(args);
        String expectedOutput = Files.readString(Path.of("/Users/kapil.bedekar/Documents/prime-project-master/expectedoutput.txt"), StandardCharsets.US_ASCII);
        Assert.assertEquals(expectedOutput,outContent.toString());
    }

}
