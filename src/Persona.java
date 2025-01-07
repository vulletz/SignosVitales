import java.util.ArrayList;

public class Persona {
    private final String nombre;
    private final int edad;
    private final ArrayList<SignoVital> signosVitales;

    public Persona(String nombre, int edad, ArrayList<SignoVital> signosVitales) {
        this.nombre = nombre;
        this.edad = edad;
        this.signosVitales = signosVitales;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public int obtenerEdad() {
        return edad;
    }

    public ArrayList<SignoVital> obtenerSignosVitales() {
        return signosVitales;
    }

}
