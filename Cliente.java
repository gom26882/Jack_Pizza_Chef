import constants.TipoCliente;

public class Cliente extends Usuario {
    private TipoCliente tipoCliente;

    public Cliente(String nombre, int edad, String direccion, String numero, TipoCliente tipoCliente) {
        super(nombre, edad, direccion, numero);
        this.tipoCliente = tipoCliente;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void pedirPizza(Orden orden, Pizza pizza) {
        orden.agregarPizza(pizza);
        System.out.println("El cliente pidió una pizza");
    }

    public void pagar() {
        System.out.println("El cliente pagó la pizza");
    }
}