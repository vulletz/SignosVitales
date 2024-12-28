public class EvaluadorDeSignosVitales {
    private static final int PULSO_BAJO = 60;
    private static final int PULSO_MODERADO = 100;
    private static final int PULSO_ALTO = 120;
    private static final int PRESION_SISTOLICA_ALTA = 140;
    private static final int PRESION_SISTOLICA_BAJA = 90;
    private static final int PRESION_DIASTOLICA_ALTA = 90;
    private static final int PRESION_DIASTOLICA_BAJA = 60;
    private static final double TEMPERATURA_BAJA = 36.0;
    private static final double TEMPERATURA_ALTA = 37.5;

    public String evaluarPulso(int PULSO_CARDIACO) {
        if (PULSO_CARDIACO < PULSO_BAJO) {
            return "Pulso: " + PULSO_CARDIACO + " ppm\n" + "Pulso debajo de lo normal.\n" + "Riesgo: Bajo. Puede ser bradicardia.\n";
        } else if (PULSO_CARDIACO > PULSO_ALTO) {
            return "Pulso: " + PULSO_CARDIACO + " ppm\n" + "Pulso muy alto de lo normal.\n" + "Riesgo: Alto. Puede ser taquicardia grave.\n";
        } else if (PULSO_CARDIACO > PULSO_MODERADO) {
            return "Pulso: " + PULSO_CARDIACO + " ppm\n" + "Pulso poco alto de lo normal.\n" + "Riesgo: Moderado. Puede ser taquicardia.\n";
        } else {
            return "Pulso: " + PULSO_CARDIACO + " ppm\n" + "Pulso dentro del rango normal.\n" + "Riesgo: Bajo. Mantener monitoreo.\n";
        }
    }

    public String evaluarTemperatura(double TEMPERATURA) {
        if (TEMPERATURA < TEMPERATURA_BAJA) {
            return "Temperatura: " + TEMPERATURA + " °C\n" + "Temperatura por debajo de lo normal.\n" + "Riesgo: Bajo. Puede ser hipotermia leve.\n";
        } else if (TEMPERATURA > TEMPERATURA_ALTA) {
            return "Temperatura: " + TEMPERATURA + " °C\n" + "Temperatura elevada.\n" + "Riesgo: Moderado. Puede ser fiebre.\n";
        } else {
            return "Temperatura: " + TEMPERATURA + " °C\n" + "Temperatura dentro del rango normal.\n" + "Riesgo: Bajo. Mantener monitoreo.\n";
        }
    }

    public String evaluarPresionArterial(int PRESION_SISTOLICA, int PRESION_DIASTOLICA){
        if (PRESION_SISTOLICA > PRESION_SISTOLICA_ALTA || PRESION_DIASTOLICA > PRESION_DIASTOLICA_ALTA) {
            return "Presión arterial: " + PRESION_SISTOLICA + "/" + PRESION_DIASTOLICA + " mmHg\n" + "Presión arterial alta.\n" + "Riesgo: Alto. Puede ser hipertensión.\n";
        } else if (PRESION_SISTOLICA < PRESION_SISTOLICA_BAJA || PRESION_DIASTOLICA < PRESION_DIASTOLICA_BAJA) {
            return "Presión arterial: " + PRESION_SISTOLICA + "/" + PRESION_DIASTOLICA + " mmHg\n" + "Presión arterial baja." + "Riesgo: Alto. Puede ser hipotensión.\n";
        } else {
            return "Presión arterial: " + PRESION_SISTOLICA + "/" + PRESION_DIASTOLICA + " mmHg\n" + "Riesgo: Bajo. Mantener monitoreo.\n";
        }
    }
}
