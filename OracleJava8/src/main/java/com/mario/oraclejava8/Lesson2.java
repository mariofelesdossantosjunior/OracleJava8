/**
 * Copyright © 2016, Oracle and/or its affiliates. All rights reserved.
 *
 * JDK 8 MOOC Lesson 2 homework
 */
package com.mario.oraclejava8;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Speakjava (Simon Ritter)
 */
public class Lesson2 {

    private static final String WORD_REGEXP = "[- .:,]+";

    /**
     * Run the exercises to ensure we got the right answers
     *
     * @throws java.io.IOException
     */
    public void runExercises() throws IOException {
        System.out.println("JDK 8 Lambdas and Streams MOOC Lesson 2");
        System.out.println("Running exercise 1 solution...");
        exercise1();
        System.out.println("Running exercise 2 solution...");
        exercise2();
        System.out.println("Running exercise 3 solution...");
        exercise3();
        System.out.println("Running exercise 4 solution...");
        exercise4();
        System.out.println("Running exercise 5 solution...");
        exercise5();
        System.out.println("Running exercise 6 solution...");
        exercise6();
        System.out.println("Running exercise 7 solution...");
        exercise7();
    }

    /**
     * Exercise 1
     *
     * Create a new list with all the strings from original list converted to
     * lower case and print them out.
     *
     * @return
     */
    public List<String> exercise1() {
        List<String> list = Arrays.asList(
                "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

        return list.stream().map(String::toLowerCase).peek(System.out::println).collect(Collectors.toList());

        /* YOUR CODE HERE */
    }

    /**
     * Exercise 2
     *
     * Modify exercise 1 so that the new list only contains strings that have an
     * odd length
     *
     * @return
     */
    public List<String> exercise2() {
        List<String> list = Arrays.asList(
                "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

        return list.stream().filter(string -> string.length() % 2 != 0).peek(System.out::println).collect(Collectors.toList());

    }

    /**
     * Exercise 3
     *
     * Join the second, third and forth strings of the list into a single
     * string, where each word is separated by a hyphen (-). Print the resulting
     * string.
     *
     * @return
     */
    public String exercise3() {
        List<String> list = Arrays.asList(
                "The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");

        return list.stream().skip(1).limit(3).collect(Collectors.joining("-"));
    }

    /**
     * Count the number of lines in the file using the BufferedReader provided
     */
    public long exercise4() {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get("SonnetI.txt"), StandardCharsets.UTF_8)) {
            return reader.lines().count();
        } catch (IOException ex) {
            return 0;
        }
    }

    /**
     * Using the BufferedReader to access the file, create a list of words with
     * no duplicates contained in the file. Print the words.
     *
     * HINT: A regular expression, WORD_REGEXP, is already defined for your use.
     */
    private List<String> exercise5() {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get("SonnetI.txt"), StandardCharsets.UTF_8)) {
            return reader.lines()
                    .flatMap(line -> Stream.of(line.split(WORD_REGEXP)))
                    .distinct()
                    .peek(System.out::println)
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            Logger.getLogger(Lesson2.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Using the BufferedReader to access the file create a list of words from
     * the file, converted to lower-case and with duplicates removed, which is
     * sorted by natural order. Print the contents of the list.
     */
    private List<String> exercise6() {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get("SonnetI.txt"), StandardCharsets.UTF_8)) {
            return reader.lines()
                    .flatMap(line -> Stream.of(line.split(WORD_REGEXP)))
                    .map(String::toLowerCase)
                    .distinct()
                    .sorted()
                    .peek(System.out::println)
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            Logger.getLogger(Lesson2.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Modify exercise6 so that the words are sorted by length
     */
    private List<String> exercise7() {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get("SonnetI.txt"), StandardCharsets.UTF_8)) {
            return reader.lines()
                    .flatMap(line -> Stream.of(line.split(WORD_REGEXP)))
                    .map(String::toLowerCase)
                    .distinct()
                    .sorted((o1, o2) -> o1.length() - o2.length())
                    .peek(System.out::println)
                    .collect(Collectors.toList());
            /* YOUR CODE HERE */
        } catch (IOException ex) {
            Logger.getLogger(Lesson2.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Main entry point for application
     *
     * @param args the command line arguments
     * @throws IOException If file access does not work
     */
    public static void main(String[] args) throws IOException {
        Lesson2 lesson = new Lesson2();
        lesson.runExercises();
    }
}
