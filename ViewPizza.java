
import javax.swing.*;
import java.awt.*;
import constants.*;

public class ViewPizza extends JFrame {

    private JTextField nombre, edad, direccion, telefono, toppings;
    private JComboBox<TipoCliente> tipoCliente;
    private JComboBox<TipoMasa> masa;
    private JComboBox<TipoSalsa> salsa;

    public ViewPizza() {

        setTitle("JACK'S PIZZERIA");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(0, 2, 10, 10));

        add(new JLabel("Nombre:"));
        nombre = new JTextField();
        add(nombre);

        add(new JLabel("Edad:"));
        edad = new JTextField();
        add(edad);

        add(new JLabel("Direccion:"));
        direccion = new JTextField();
        add(direccion);

        add(new JLabel("Telefono:"));
        telefono = new JTextField();
        add(telefono);

        add(new JLabel("Tipo de cliente:"));
        tipoCliente = new JComboBox<>(TipoCliente.values());
        add(tipoCliente);

        add(new JLabel("Tipo de masa:"));
        masa = new JComboBox<>(TipoMasa.values());
        add(masa);

        add(new JLabel("Tipo de salsa:"));
        salsa = new JComboBox<>(TipoSalsa.values());
        add(salsa);

        add(new JLabel("Toppingsseparados por coma:"));
        toppings = new JTextField();
        add(toppings);

        JButton boton = new JButton("Realizar orden");
        add(boton);

        boton.addActionListener(accionar -> realizarOrden());
        setVisible(true);
    }

    private void realizarOrden() {
            Cliente cliente = new Cliente(
                nombre.getText(),
                Integer.parseInt(edad.getText().trim()),
                direccion.getText(),
                telefono.getText(),
                (TipoCliente) tipoCliente.getSelectedItem()
            );

            String texto = toppings.getText().trim();

            String[] ingredientes = texto.isEmpty()
                ? new String[0]
                : texto.split("\\s*,\\s*");

            Pizza pizza = Pizza.createPizza(
                false,
                (TipoMasa) masa.getSelectedItem(),
                (TipoSalsa) salsa.getSelectedItem(),
                ingredientes
            );

            Orden orden = new Orden(cliente);
            cliente.pedirPizza(orden, pizza);

            JOptionPane.showMessageDialog(
                this,
                "Orden realizada\n\n"
                + "Cliente: " + nombre.getText()
                + "\nPizza: " + pizza
                + "\nEstado: " + orden.getEstadoOrden()
            );
    }
}
