import constants.TipoMasa;
import constants.TipoSalsa;
import java.util.Arrays;

public class Pizza {
    private boolean pizzaPersonalizada;
    private TipoMasa tipoMasa;
    private TipoSalsa tipoSalsa;
    private String[] toppings;

    private Pizza(boolean pizzaPersonalizada, TipoMasa tipoMasa,
                TipoSalsa tipoSalsa, String[] toppings) {
        this.pizzaPersonalizada = pizzaPersonalizada;
        this.tipoMasa = tipoMasa;
        this.tipoSalsa = tipoSalsa;
        this.toppings = toppings;
    }

    public static Pizza createPizza(boolean pizzaPersonalizada,
                                    TipoMasa tipoMasa,
                                    TipoSalsa tipoSalsa,
                                    String[] toppings) {
        return new Pizza(pizzaPersonalizada, tipoMasa, tipoSalsa, toppings);
    }

    public void agregarIngrediente(String ingrediente) {
        String[] nuevos = Arrays.copyOf(toppings, toppings.length + 1);
        nuevos[toppings.length] = ingrediente;
        toppings = nuevos;
    }

    public void agregarIngrediente(String ingrediente, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            agregarIngrediente(ingrediente);
        }
    }

    @Override
    public String toString() {
        return "Masa: " + tipoMasa
            + ", salsa: " + tipoSalsa
            + ", toppings: " + Arrays.toString(toppings);
    }
}