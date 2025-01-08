import java.util.Objects;

public class Temperatura implements SignoVital {
    private final double temperatura;
    private final String unidad;

    private static final double TEMPERATURA_BAJA = 36.0;
    private static final double TEMPERATURA_ALTA = 37.5;

    public Temperatura(double temperatura, String unidad){
        this.temperatura = temperatura;
        this.unidad = unidad;
    }

    public String obtenerValor(){
        return String.valueOf(temperatura);
    }

    @Override
    public String obtenerNombre(){
        return "Temperatura";
    }

    @Override
    public String obtenerUnidad(){
        return unidad;
    }

    @Override
    public boolean esNormal() {
        double tempCelsius = convertirACelsius(temperatura, unidad);
        return tempCelsius >= TEMPERATURA_BAJA && tempCelsius <= TEMPERATURA_ALTA;
    }

    @Override
    public String obtenerAnomalia() {
        if (temperatura < TEMPERATURA_BAJA) {
            return "Hipotermia leve";
        } else if (temperatura > TEMPERATURA_ALTA) {
            return "Fiebre";
        } else {
            return "Ninguno";
        }
    }

    @Override
    public void procesarAnomalia(String alteracion)  {
        if (Objects.equals(alteracion, "Hipotermia leve")){
            System.out.println("Alteración: "+alteracion+"\n Riesgo: BAJO");
        }else if (Objects.equals(alteracion, "Fiebre")){
            System.out.println("Alteración: "+alteracion+"\n Riesgo: MODERADO");
        }
    }

    private double convertirACelsius(double temperatura, String unidad) {
        switch (unidad) {
            case "C":
                return temperatura;
            case "K":
                return temperatura - 273.15;
            case "F":
                return (temperatura - 32) * 5 / 9;
            default:
                throw new IllegalArgumentException("Unidad no reconocida");
        }
    }
}
