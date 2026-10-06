public class Cocina {
    private Empleado empleado;
    private Orden[] espera = new Orden[5];
    private int cantidad;

    public Cocina(Empleado empleado) {
        this.empleado = empleado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public int getCantidadPendiente() {
        return cantidad;
    }

    public void prepararOrden(Orden orden) {
        if (cantidad < espera.length) {
            espera[cantidad] = orden;
            cantidad++;
            orden.iniciarPreparacion();
            System.out.println("Preparando pizza: " + orden.getPizzas()[0]);
        } else {
            System.out.println("La cocina está llena");
        }
    }

    public void entregarOrden(Orden orden) {
        orden.entregarOrden();
        cantidad--;
    }

    public void espaciosDisponibles() {
        System.out.println("Espacios disponibles en la cocina: " + (espera.length - cantidad));
    }
}