import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Temperatura implements ParametroDeSalud{
    private final double TEMPERATURA;
    private final String UNIDAD;
    private String MARCA_TEMPORAL;

    private static final double TEMPERATURA_BAJA = 36.0;
    private static final double TEMPERATURA_ALTA = 37.5;

    public Temperatura(double temperatura, String unidad){
        this.TEMPERATURA = temperatura;
        this.UNIDAD = unidad;
    }

    public double obtenerTemperatura(){
        return TEMPERATURA;
    }

    public String obtenerUnidad(){
        return UNIDAD;
    }

    @Override
    public boolean esNormal() {
        if(Objects.equals(UNIDAD, "C")){
            if(TEMPERATURA > TEMPERATURA_BAJA && TEMPERATURA < TEMPERATURA_ALTA){
                return true;
            }else return false;
        }else if(Objects.equals(UNIDAD, "K")){
            if(TEMPERATURA-273.15 > TEMPERATURA_BAJA && TEMPERATURA-273.15 < TEMPERATURA_ALTA){
                return true;
            }else return false;
        }else if(Objects.equals(UNIDAD, "F")){
            if( (TEMPERATURA-32)*((double) 5 /9) > TEMPERATURA_BAJA && (TEMPERATURA-32)*((double) 5 /9) < TEMPERATURA_ALTA){
                return true;
            }else return false;
        }else{
            System.out.println("Error: Temperatura sin unidades");
            return false;
        }
    }

    @Override
    public String marcaTemporal() {
        if(Objects.equals(MARCA_TEMPORAL, null)){
            LocalDateTime ahora = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            this.MARCA_TEMPORAL = ahora.format(formato);
            return ahora.format(formato);
        }else{
            return MARCA_TEMPORAL;
        }
    }

    @Override
    public String alteracionDetectada() {
        if (TEMPERATURA < TEMPERATURA_BAJA) {
            return "Hipotermia leve";
        } else if (TEMPERATURA > TEMPERATURA_ALTA) {
            return "Fiebre";
        } else {
            return "Ninguno";
        }
    }

    @Override
    public void evaluarRiesgo(String alteracion) {
        if (Objects.equals(alteracion, "Hipotermia leve")){
            System.out.println("Alteración: "+alteracion+"\n Riesgo: BAJO");
        }else if (Objects.equals(alteracion, "Fiebre")){
            System.out.println("Alteración: "+alteracion+"\n Riesgo: MODERADO");
        }else if (Objects.equals(alteracion, "Ninguno")){
            System.out.println("Sin riesgo inmediato. Mantener monitoreo.");
        }
    }
}
