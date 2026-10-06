import constants.TipoEmpleado;

public class Empleado extends Usuario {
    private TipoEmpleado tipoEmpleado;

    public Empleado(String nombre, int edad, String direccion,
                    String numero, TipoEmpleado tipoEmpleado) {
        super(nombre, edad, direccion, numero);
        this.tipoEmpleado = tipoEmpleado;
    }

    public TipoEmpleado getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void cobrar(Orden orden) {
        orden.getCliente().pagar();
        System.out.println("El empleado cobró la orden");
    }

    public void entrar() {
        System.out.println("Entró a trabajar");
    }

    public void salir() {
        System.out.println("Salió del trabajo");
    }
}