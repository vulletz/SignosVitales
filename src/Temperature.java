public class Temperature implements VitalSign {
    private final double temperature;
    private final String unit;

    private static final double LOW_TEMPERATURE = 36.0;
    private static final double HIGH_TEMPERATURE = 37.5;

    public Temperature(double temperature, String unit){
        this.temperature = temperature;
        this.unit = unit;
    }

    public String getValue(){
        return String.valueOf(temperature);
    }

    @Override
    public String getName(){
        return "Temperatura";
    }

    @Override
    public String getUnit(){
        return unit;
    }

    @Override
    public boolean isNormal() {
        double tempCelsius = convertToCelsius(temperature, unit);
        return tempCelsius >= LOW_TEMPERATURE && tempCelsius <= HIGH_TEMPERATURE;
    }

    @Override
    public String getAnomaly() {
        double tempCelsius = convertToCelsius(temperature, unit);
        if (tempCelsius < LOW_TEMPERATURE) {
            return "Hipotermia leve";
        }
        if (tempCelsius > HIGH_TEMPERATURE) {
            return "Fiebre";
        }
        return "Ninguno";
    }

    private double convertToCelsius(double temperature, String unit) {
        return switch (unit) {
            case "C" -> temperature;
            case "K" -> temperature - 273.15;
            case "F" -> (temperature - 32) * 5 / 9;
            default -> throw new IllegalArgumentException("Unidad no reconocida");
        };
    }
}
