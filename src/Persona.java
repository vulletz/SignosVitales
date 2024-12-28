public class Persona {
    private final String NOMBRE;
    private final int EDAD;
    private SignosVitales signosVitales;

    public Persona(String nombre, int edad, SignosVitales signosVitales) {
        this.NOMBRE = nombre;
        this.EDAD = edad;
        this.signosVitales = signosVitales;
    }

    public String obtenerNombre(){
        return NOMBRE;
    }

    public int obtenerEdad(){
        return EDAD;
    }

    public SignosVitales obtenerSignosVitales() {
        return signosVitales;
    }

    public void establecerSignosVitales(SignosVitales signosVitales) {
        this.signosVitales = signosVitales;
    }

    public void evaluarRiesgos() {
        signosVitales.evaluarRiesgos();
    }

    public boolean sonSignosVitalesNormales() {
        return signosVitales.sonSignosVitalesNormales();
    }

    public void mostrarMarcasTemporales() {
        signosVitales.mostrarMarcasTemporales();
    }
}
