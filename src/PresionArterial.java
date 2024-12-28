import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class PresionArterial implements ParametroDeSalud{
    private final int SISTOLICA;
    private final int DIASTOLICA;
    private String MARCA_TEMPORAL;

    private static final int PRESION_SISTOLICA_ALTA = 140;
    private static final int PRESION_SISTOLICA_BAJA = 90;
    private static final int PRESION_DIASTOLICA_ALTA = 90;
    private static final int PRESION_DIASTOLICA_BAJA = 60;

    public PresionArterial(int sistolica, int diastolica) {
        this.SISTOLICA = sistolica;
        this.DIASTOLICA = diastolica;
    }

    public int obtenerSistolica(){
        return SISTOLICA;
    }

    public int obtenerDiastolica(){
        return DIASTOLICA;
    }

    @Override
    public boolean esNormal() {
        if (SISTOLICA > PRESION_SISTOLICA_ALTA || DIASTOLICA > PRESION_DIASTOLICA_ALTA) {
            return false;
        } else if (SISTOLICA < PRESION_SISTOLICA_BAJA || DIASTOLICA < PRESION_DIASTOLICA_BAJA) {
            return false;
        } else {
            return true;
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
        if (SISTOLICA > PRESION_SISTOLICA_ALTA || DIASTOLICA > PRESION_DIASTOLICA_ALTA) {
            return "Hipertensión";
        } else if (SISTOLICA < PRESION_SISTOLICA_BAJA || DIASTOLICA < PRESION_DIASTOLICA_BAJA) {
            return "Hipotensión";
        } else {
            return "Ninguno";
        }
    }

    @Override
    public void evaluarRiesgo(String alteracion) {
        if (Objects.equals(alteracion, "Hipertensión") || Objects.equals(alteracion, "Hipotensión")){
            System.out.println("Alteración: "+alteracion+"\n Riesgo: ALTO");
        }else if (Objects.equals(alteracion, "Ninguno")){
            System.out.println("Sin riesgo inmediato. Mantener monitoreo.");
        }
    }
}
