package br.com.cbpoo.util;

import java.util.Random;

public class Id {
    private static final Random Gerador = new Random();

    public static String randomId() {
        String id = "";
        for (int i = 0; i < 10; i++) {
            id = id.concat(Gerador.nextInt(10) + "");
        }
        return id;
    }
}
