package com.company.quoll.utils;

import java.util.Random;

public class GenerateUuid {

    public static int generate(int high, int low){
        Random r = new Random();
        return r.nextInt(high-low) + low;
    }

}
