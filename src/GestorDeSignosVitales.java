import java.util.Random;

public class GestorDeSignosVitales {
    public static void main(String[] args) {
        // creación de signos vitales
        SignosVitales signosVitales = generarSignosVitalesAleatorios();
        Persona persona = new Persona("Sebastian Heredia", 23, signosVitales);

        // evaluación de signos vitales de persona creada
        evaluarSignos(persona);
        System.out.println("\nHorario de Detecciones: \n");
        signosVitales.mostrarMarcasTemporales();

        // pruebas unitarias
        realizarPruebasUnitarias();

    }

    private static void evaluarSignos(Persona persona) {
        System.out.println("\nPersona Generada:\nNombre: " + persona.obtenerNombre() + "\nEdad: " + persona.obtenerEdad());
        SignosVitales signosVitales = persona.obtenerSignosVitales();

        PulsoCardiaco pulso = signosVitales.obtenerPulsoCardiaco();
        System.out.println("\nPulso: " + pulso.obtenerPulso()+"ppm");
        pulso.evaluarRiesgo(pulso.alteracionDetectada());

        PresionArterial presion = signosVitales.obtenerPresionArterial();
        System.out.println("\nPresión Arterial: " + presion.obtenerSistolica() + "/" + presion.obtenerDiastolica() + " mmHg");
        presion.evaluarRiesgo(presion.alteracionDetectada());

        Temperatura temperatura = signosVitales.obtenerTemperatura();
        System.out.println("\nTemperatura: " + temperatura.obtenerTemperatura() + " " + temperatura.obtenerUnidad());
        temperatura.evaluarRiesgo(temperatura.alteracionDetectada());
    }

    private static void realizarPruebasUnitarias() {
        System.out.println("\n\nPruebas unitarias:");

        // Prueba: Bradicardia
        PulsoCardiaco pulso = new PulsoCardiaco(50);
        System.out.println("\nPrueba 1 - Pulso: " + pulso.obtenerPulso()+"ppm");
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

    private static SignosVitales generarSignosVitalesAleatorios() {
        Random rand = new Random();

        int PULSO_CARDIACO = rand.nextInt(210 - 20 + 1) + 20; // 20 a 210 ppm
        int PRESION_SISTOLICA = rand.nextInt(180 - 90 + 1) + 90; // 90 a 180 mmHg
        int PRESION_DIASTOLICA = rand.nextInt((PRESION_SISTOLICA - 60)) + 60; // depende de la sistólica
        double TEMPERATURA = 35 + rand.nextDouble() * 5; // 35 a 40 °C

        PulsoCardiaco pulso = new PulsoCardiaco(PULSO_CARDIACO);
        PresionArterial presion = new PresionArterial(PRESION_SISTOLICA, PRESION_DIASTOLICA);
        Temperatura temperatura = new Temperatura(TEMPERATURA, "C");

        return new SignosVitales(pulso, presion, temperatura);
    }
}
