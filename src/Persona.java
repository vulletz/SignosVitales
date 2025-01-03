import java.util.ArrayList;

public class Persona {
    private final String NOMBRE;
    private final int EDAD;
    private final ArrayList<ParametroDeSalud> signosVitales;

    public Persona(String nombre, int edad, ArrayList<ParametroDeSalud> signosVitales) {
        this.NOMBRE = nombre;
        this.EDAD = edad;
        this.signosVitales = signosVitales;
    }

    public String obtenerNombre() {
        return NOMBRE;
    }

    public int obtenerEdad() {
        return EDAD;
    }

    public ArrayList<ParametroDeSalud> obtenerSignosVitales() {
        return signosVitales;
    }

    public void mostrarMarcasTemporales() {
        for (ParametroDeSalud parametro : signosVitales) {
            System.out.println(parametro.marcaTemporal());
        }
    }
}
