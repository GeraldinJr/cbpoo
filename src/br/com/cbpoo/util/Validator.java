package br.com.cbpoo.util;

import java.util.regex.Pattern;

public class Validator {
    private static Pattern CPFPattern = Pattern.compile("^([0-9]{3}\\.?){3}-?[0-9]{2}$");

    public static boolean validateCpf(String cpf) {
        return CPFPattern.matcher(cpf).matches();
    }

    public static String onlyDigits(String str) {
        return str.replaceAll("[^0-9]", "");
    }
}
