import java.util.Objects;

public class Usuario {
    private final String nombre;
    private final int edad;
    private final String direccion;
    private final String numero;  
    
    public Usuario(String nombre, int edad, String direccion, String numero) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.numero = numero;
    }

    public static Usuario createUser(String nombre, int edad, String direccion, String numero) {
        return new Usuario(nombre, edad, direccion, numero);
    }
}
