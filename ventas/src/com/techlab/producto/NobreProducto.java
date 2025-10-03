package com.techlab.producto;

public class NobreProducto {

    public static void main(String[] args) {
        // pruebas

        String word = "café MOLIDO";
        String outputWord = productNameFormat(word);
        System.out.println(outputWord);

    }

    public static String productNameFormat(String name) {
        name = name.trim().toLowerCase();
        // Dividimos en palabras
        String[] words = name.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) {
                String firstLetter =
                        words[i].substring(0,1).toUpperCase();
                String rest = words[i].substring(1);
                sb.append(firstLetter).append(rest);
                if (i < words.length - 1) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }
}
