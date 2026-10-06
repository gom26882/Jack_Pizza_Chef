import java.util.Arrays;
import java.util.Objects;
import constants.EstadoOrden;

public class Orden {
    private Pizza[] pizzas;
    private final Cliente cliente;
    private EstadoOrden estadoOrden = EstadoOrden.RECIBIDO;

    public Orden(Cliente cliente, Pizza... pizzas) {
        this.cliente = cliente;
        this.pizzas = Arrays.copyOf(Objects.requireNonNull(pizzas), pizzas.length);
        for (Pizza pizza : this.pizzas) Objects.requireNonNull(pizza);
    }

    public void agregarPizza(Pizza pizza) {
        Objects.requireNonNull(pizza);
        Pizza[] nuevas = Arrays.copyOf(pizzas, pizzas.length + 1);
        nuevas[pizzas.length] = pizza;
        pizzas = nuevas;
    }

    public Pizza[] getPizzas() { return Arrays.copyOf(pizzas, pizzas.length); }
    public Cliente getCliente() { return cliente; }
    public EstadoOrden getEstadoOrden() { return estadoOrden; }
    public void iniciarPreparacion() {
        estadoOrden = EstadoOrden.PREPARACION;
        System.out.println("Orden en preparación: " + this);
    }
    public void entregarOrden() {
        estadoOrden = EstadoOrden.ENTREGADO;
        System.out.println("Orden entregada: " + this);
    }
    public void cancelarOrden() {
        pizzas = new Pizza[0];
        System.out.println("Orden cancelada: " + this);
    }
}
