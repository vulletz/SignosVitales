public class SignosVitales {
    private final PulsoCardiaco pulsoCardiaco;
    private final PresionArterial presionArterial;
    private final Temperatura temperatura;

    public SignosVitales(PulsoCardiaco pulsoCardiaco, PresionArterial presionArterial, Temperatura temperatura) {
        this.pulsoCardiaco = pulsoCardiaco;
        this.presionArterial = presionArterial;
        this.temperatura = temperatura;
    }

    // Métodos para acceder a cada parámetro individual
    public PulsoCardiaco obtenerPulsoCardiaco() {
        return pulsoCardiaco;
    }

    public PresionArterial obtenerPresionArterial() {
        return presionArterial;
    }

    public Temperatura obtenerTemperatura() {
        return temperatura;
    }

    // Métodos para verificar si todos los parámetros son normales
    public boolean sonSignosVitalesNormales() {
        return pulsoCardiaco.esNormal() && presionArterial.esNormal() && temperatura.esNormal();
    }

    public void evaluarRiesgos() {
        pulsoCardiaco.evaluarRiesgo(pulsoCardiaco.alteracionDetectada());
        presionArterial.evaluarRiesgo(presionArterial.alteracionDetectada());
        temperatura.evaluarRiesgo(temperatura.alteracionDetectada());
    }

    public void mostrarMarcasTemporales() {
        System.out.println("Pulso: " + pulsoCardiaco.marcaTemporal());
        System.out.println("Presión Arterial: " + presionArterial.marcaTemporal());
        System.out.println("Temperatura: " + temperatura.marcaTemporal());
    }
}
