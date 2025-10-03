package menuInicio;
import java.util.Scanner;

public class MenuInicio {

    public static void main(String[] args) {
        menuDeOpciones();
    }

    public static void menuDeOpciones(){
        String op;
        Scanner sc = new Scanner(System.in);

        do {
            encabezado();
            op = sc.nextLine();
            switch (op){
                case "1":
                    ManejarProductos.agregarProducto();
                    break;

                case "2":
                    ManejarProductos.listarProductos();
                    break;

                case "3":
                    ManejarProductos.buscarProducto();
                    System.out.println("¿Desea actualizar el producto?");
                    break;

                case "4":
                    ManejarProductos.eliminarProducto();
                    break;

                case "5":
                    ManejarPedidos.crearPedido();
                    break;

                case "6":
                    ManejarPedidos.listarPedidos();
                    break;

                case "7":
                    break;

                default:
                    System.out.println("El valor ingresado no es válido");
            }

            if (!op.equals("7")) {
                op = eleccionContinuar(); // solo preguntar si no es salir
            }

        } while (!op.equals("7"));
        System.out.println("Programa finalizado");
    }

    public static void encabezado(){
        System.out.println("===========================================");
        System.out.println("|| Sistema de gestión de pedidos TECHLAB ||");
        System.out.println("===========================================");
        System.out.println();
        System.out.println("1) Agregar producto");
        System.out.println("2) Listar productos");
        System.out.println("3) Buscar/actualizar producto");
        System.out.println("4) Eliminar producto");
        System.out.println("5) Crear un pedido");
        System.out.println("6) Listar pedidos");
        System.out.println("7) Salir");
        System.out.println();
        System.out.print("Ingrese una opción: ");
    }

    public static String eleccionContinuar(){
        Scanner sc = new Scanner(System.in);
        String opSalida;

        while (true) {// bucle infinito hasta que el return lo corte
            System.out.print("¿Desea continuar? S/N: ");
            opSalida = sc.nextLine().trim().toLowerCase();

            switch (opSalida){
                case "s":
                    return "0"; // cualquier valor distinto de "7" para seguir; el return corta el bucle
                case "n":
                    return "7"; // fuerza salida del bucle exterior
                default:
                    System.out.println("El valor ingresado no es válido");
            }
        }
    }
}