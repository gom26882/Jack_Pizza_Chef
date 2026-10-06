import java.util.Scanner;
import constants.TipoCliente;
import constants.TipoEmpleado;
import constants.TipoMasa;
import constants.TipoSalsa;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Datos del cliente");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Edad: ");
        int edad = Integer.parseInt(scanner.nextLine());

        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        System.out.print("Telefono: ");
        String numero = scanner.nextLine();

        System.out.print("Tipo de cliente (FRECUENTE, VIP, NUEVO): ");
        TipoCliente tipoCliente = TipoCliente.valueOf(scanner.nextLine().toUpperCase());

        Cliente cliente = new Cliente(
            nombre, edad, direccion, numero, tipoCliente
        );

        System.out.println("\nCrear pizza");

        System.out.print("Tipo de masa (DELGADA, GRUESA): ");
        TipoMasa masa = TipoMasa.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Tipo de salsa (NORMAL, PICANTE, DE_AJO, BLANCA): ");
        TipoSalsa salsa =  TipoSalsa.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("cuantos toppings quieres? ");
        int cantidadToppings = Integer.parseInt(scanner.nextLine());

        String[] toppings = new String[cantidadToppings];

        for (int i = 0; i < cantidadToppings; i++) {
            System.out.print("Topping " + (i + 1) + ": ");
            toppings[i] = scanner.nextLine();
        }

        Pizza pizza = Pizza.createPizza(false, masa, salsa, toppings);

        Orden orden = new Orden(cliente);
        cliente.pedirPizza(orden, pizza);

        Empleado cajero = new Empleado(
            "Luis", 30, "Ciudad", "5555-5678", TipoEmpleado.CAJERO
        );

        Cocina cocina = new Cocina(cajero);

        System.out.println("\nORDENNNNN");
        cocina.prepararOrden(orden);
        cajero.cobrar(orden);
        cocina.entregarOrden(orden);

        System.out.println("Estado final: " + orden.getEstadoOrden());

        scanner.close();
    }
}