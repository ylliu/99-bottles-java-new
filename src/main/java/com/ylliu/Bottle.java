package com.ylliu;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Bottle {
    public String verse(int number) {
        return capitalize(quantity(number) + " " + container(number) + " of beer on the wall,") +
                quantity(number) + " " + container(number) + " of beer.\n" +
                action(number) +
                quantity(next(number)) + " " + container(next(number)) + " of beer on the wall.\n";
    }

    private int next(int number) {
        if (number == 0) {
            return 99;
        }
        return number - 1;
    }

    private String action(int number) {
        if (number == 0) {
            return "Go to the store and buy some more, ";
        }
        return "Take " + pronoun(number) + " down and pass it around, ";
    }

    private String quantity(int number) {
        if (number == 0) {
            return "no more";
        }
        if (number == 6) {
            return "1";
        }
        return String.valueOf(number);
    }

    private String pronoun(int number) {
        if (number == 1) {
            return "it";
        }
        return "one";
    }

    private String container(int number) {
        if (number == 1) {
            return "bottle";
        }
        if (number == 6) {
            return "six-pack";
        }
        return "bottles";
    }

    public String verses(int starting, int ending) {
        return IntStream.rangeClosed(ending, starting).boxed().sorted(Collections.reverseOrder()).
                map(this::verse).collect(Collectors.joining("\n"));
    }

    public static String capitalize(String str) {
        if (str == null || str.length() <= 1) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

}
