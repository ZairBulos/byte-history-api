package com.bytehistory.utils;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateUtils {

    private static final Locale SPANISH = Locale.of("es", "ES");

    /**
     * Returns the current date in the format "day of week, day of month of year".
     * @return the current date
     */
    public static String getCurrentDate() {
        LocalDate today = LocalDate.now();
        int day = today.getDayOfMonth();
        String dayOfWeek = today.getDayOfWeek().getDisplayName(TextStyle.FULL, SPANISH);
        String month = today.getMonth().getDisplayName(TextStyle.FULL, SPANISH);
        int year = today.getYear();

        return String.format("%s, %d de %s de %d", capitalize(dayOfWeek), day, capitalize(month), year);
    }

    /**
     * Capitalizes the first letter of a string
     * @param text the string
     * @return the string with the first letter capitalized
     */
    private static String capitalize(String text) {
        if (text == null || text.isEmpty()) return text;
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }
}
