package com.milosbognar.buylist.core;

import java.util.function.BiFunction;

import static java.lang.String.format;

public class Constants {

    public static final BiFunction<Integer, String, String> LIST_DESCRIPTION = (a, b) -> format("All items: %d Sum: %s £ Date: \\d{1,2}:\\d{1,2}, \\d{1,2}.\\d{1,2}.\\d{1,2}", a, b);
}
