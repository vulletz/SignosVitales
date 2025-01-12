public class HeartRate implements VitalSign {
    private final int pulse;

    private static final int LOW_PULSE = 60;
    private static final int MODERATE_PULSE = 100;
    private static final int HIGH_PULSE = 120;

    public HeartRate(int pulse) {
        this.pulse = pulse;
    }

    public String getValue(){
        return String.valueOf(pulse);
    }

    @Override
    public String getName(){
        return "Pulso Cardiaco";
    }

    @Override
    public String getUnit(){
        return "ppm";
    }

    @Override
    public boolean isNormal() {
        return pulse >= LOW_PULSE && pulse <= MODERATE_PULSE;
    }

    @Override
    public String getAnomaly() {
        if (pulse < LOW_PULSE) {
            return "Bradicardia";
        }
        if (pulse > HIGH_PULSE) {
            return "Taquicardia severa";
        }
        if (pulse > MODERATE_PULSE) {
            return "Taquicardia leve";
        }
        return "Ninguno";
    }
}
