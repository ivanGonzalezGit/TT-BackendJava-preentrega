package com.techlab.menuInicio;

public class Validacion {

    public static double doubleValido (String numeroInput){
        try {
            // Reemplaza la coma por punto (para adaptarse a Double.parseDouble)
            numeroInput = numeroInput.replace(',', '.');
            double precio = Double.parseDouble(numeroInput);
            return precio;
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Debe ingresar un número válido.");
        }
        return -1;
    }
}
