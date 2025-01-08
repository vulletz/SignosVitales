import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class GestorDeSignosVitales {
    public static void main(String[] args) {
        // creación de la persona
        Persona persona = generarPersonaAleatoria();

        // evaluación de signos vitales de la persona creada
        evaluarSignos(persona);
    }

    private static void evaluarSignos(Persona persona) {
        System.out.println("\nPersona Generada:\nNombre: " + persona.obtenerNombre() + "\nEdad: " + persona.obtenerEdad());

        // iterar sobre la lista de signos vitales para evaluar cada uno
        for (SignoVital parametro : persona.obtenerSignosVitales()) {
            System.out.println("\nFecha: " + generarMarcaTemporal());

            System.out.println("\n" + parametro.obtenerNombre() + ": " + parametro.obtenerValor() + " " + parametro.obtenerUnidad());

            if (parametro.esNormal()){
                System.out.println("Sin riesgo inmediato. Mantener monitoreo.");
            }else{
                parametro.procesarAnomalia(parametro.obtenerAnomalia());
            }

        }
    }

    private static String generarMarcaTemporal(){
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return ahora.format(formato);
    }

    private static Persona generarPersonaAleatoria() {
        Random rand = new Random();

        // datos aleatorios
        String nombre = "Sebastian Heredia";
        int edad = rand.nextInt(100); // Edad aleatoria entre 0 y 99

        int pulsoCardiaco = rand.nextInt(210 - 20 + 1) + 20; // 20 a 210 ppm
        int presionSistolica = rand.nextInt(180 - 90 + 1) + 90; // 90 a 180 mmHg
        int presionDiastolica = rand.nextInt((presionSistolica - 60)) + 60; // depende de la sistólica
        double temperatura = 35 + rand.nextDouble() * 5; // 35 a 40 °C

        // creación de parámetros de salud
        PulsoCardiaco pulso = new PulsoCardiaco(pulsoCardiaco);
        PresionArterial presion = new PresionArterial(presionSistolica, presionDiastolica);
        Temperatura temp = new Temperatura(temperatura, "C");

        // creación de lista de signos vitales
        ArrayList<SignoVital> signosVitales = new ArrayList<>();
        signosVitales.add(pulso);
        signosVitales.add(presion);
        signosVitales.add(temp);

        return new Persona(nombre, edad, signosVitales);
    }
}
