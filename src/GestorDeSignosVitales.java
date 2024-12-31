import java.util.ArrayList;
import java.util.Random;

public class GestorDeSignosVitales {
    public static void main(String[] args) {
        // creación de la persona
        Persona persona = generarPersonaAleatoria();

        // evaluación de signos vitales de la persona creada
        evaluarSignos(persona);
        System.out.println("\nHorario de Detecciones: \n");
        persona.mostrarMarcasTemporales();

        // pruebas unitarias
        realizarPruebasUnitarias();

        //
    }

    private static void evaluarSignos(Persona persona) {
        System.out.println("\nPersona Generada:\nNombre: " + persona.obtenerNombre() + "\nEdad: " + persona.obtenerEdad());

        // iterar sobre la lista de signos vitales para evaluar cada uno
        for (ParametroDeSalud parametro : persona.obtenerSignosVitales()) {
            System.out.println("\n" + parametro.getClass().getSimpleName() + ": " + parametro.marcaTemporal());

            if (parametro instanceof PulsoCardiaco pulso) {
                System.out.println("\nPulso: " + pulso.obtenerPulso() + " ppm");
                pulso.evaluarRiesgo(pulso.alteracionDetectada());
            }
            else if (parametro instanceof PresionArterial presion) {
                System.out.println("\nPresión Arterial: " + presion.obtenerSistolica() + "/" + presion.obtenerDiastolica() + " mmHg");
                presion.evaluarRiesgo(presion.alteracionDetectada());
            }
            else if (parametro instanceof Temperatura temperatura) {
                System.out.println("\nTemperatura: " + temperatura.obtenerTemperatura() + " " + temperatura.obtenerUnidad());
                temperatura.evaluarRiesgo(temperatura.alteracionDetectada());
            }
        }
    }


    private static void realizarPruebasUnitarias() {
        System.out.println("\n\nPruebas unitarias:");

        // Prueba: Bradicardia
        PulsoCardiaco pulso = new PulsoCardiaco(50);
        System.out.println("\nPrueba 1 - Pulso: " + pulso.obtenerPulso() + "ppm");
        pulso.evaluarRiesgo(pulso.alteracionDetectada());

        // Prueba: Hipertensión
        PresionArterial presion = new PresionArterial(150, 95);
        System.out.println("\nPrueba 2 - Presión Arterial: " + presion.obtenerSistolica() + "/" + presion.obtenerDiastolica() + " mmHg");
        presion.evaluarRiesgo(presion.alteracionDetectada());

        // Prueba: Fiebre
        Temperatura temperatura = new Temperatura(38.5, "C");
        System.out.println("\nPrueba 3 - Temperatura: " + temperatura.obtenerTemperatura() + " " + temperatura.obtenerUnidad());
        temperatura.evaluarRiesgo(temperatura.alteracionDetectada());
    }

    private static Persona generarPersonaAleatoria() {
        Random rand = new Random();

        // datos aleatorios
        String nombre = "Sebastian Heredia";
        int edad = rand.nextInt(100); // Edad aleatoria entre 0 y 99

        int PULSO_CARDIACO = rand.nextInt(210 - 20 + 1) + 20; // 20 a 210 ppm
        int PRESION_SISTOLICA = rand.nextInt(180 - 90 + 1) + 90; // 90 a 180 mmHg
        int PRESION_DIASTOLICA = rand.nextInt((PRESION_SISTOLICA - 60)) + 60; // depende de la sistólica
        double TEMPERATURA = 35 + rand.nextDouble() * 5; // 35 a 40 °C

        // creación de parámetros de salud
        PulsoCardiaco pulso = new PulsoCardiaco(PULSO_CARDIACO);
        PresionArterial presion = new PresionArterial(PRESION_SISTOLICA, PRESION_DIASTOLICA);
        Temperatura temperatura = new Temperatura(TEMPERATURA, "C");

        // creación de lista de signos vitales
        ArrayList<ParametroDeSalud> signosVitales = new ArrayList<>();
        signosVitales.add(pulso);
        signosVitales.add(presion);
        signosVitales.add(temperatura);

        return new Persona(nombre, edad, signosVitales);
    }
}
