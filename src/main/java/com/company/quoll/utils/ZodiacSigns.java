package com.company.quoll.utils;

import com.company.quoll.model.User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ZodiacSigns {

    public static final int AQUARIUS = 1;
    public static final int PISCES = 2;
    public static final int ARIES = 3;
    public static final int TAURUS = 4;
    public static final int GEMINI = 5;
    public static final int CANCER = 6;
    public static final int LEO = 7;
    public static final int VIRGO = 8;
    public static final int LIBRA = 9;
    public static final int SCORPIO = 10;
    public static final int SAGITTARIUS = 11;
    public static final int CAPRICORN = 12;

    public static int getZodiacSign(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        if (month == 0) {
            return day < 20 ? CAPRICORN : AQUARIUS;
        } else if (month == 1) {
            return day < 19 ? AQUARIUS : PISCES;
        } else if (month == 2) {
            return day < 21 ? PISCES : ARIES;
        } else if (month == 3) {
            return day < 20 ? ARIES : TAURUS;
        } else if (month == 4) {
            return day < 21 ? TAURUS : GEMINI;
        } else if (month == 5) {
            return day < 21 ? GEMINI : CANCER;
        } else if (month == 6) {
            return day < 23 ? CANCER : LEO;
        } else if (month == 7) {
            return day < 23 ? LEO : VIRGO;
        } else if (month == 8) {
            return day < 23 ? VIRGO : LIBRA;
        } else if (month == 9) {
            return day < 23 ? LIBRA : SCORPIO;
        } else if (month == 10) {
            return day < 22 ? SCORPIO : SAGITTARIUS;
        } else {
            return day < 22 ? SAGITTARIUS : CAPRICORN;
        }
    }

    public static List<String> getZodiacSigns() {
        List<String> signs = new ArrayList<>();
        signs.add("Aquarius");
        signs.add("Pisces");
        signs.add("Aries");
        signs.add("Taurus");
        signs.add("Gemini");
        signs.add("Cancer");
        signs.add("Leo");
        signs.add("Virgo");
        signs.add("Libra");
        signs.add("Scorpio");
        signs.add("Sagittarius");
        signs.add("Capricorn");
        return signs;
    }

}
