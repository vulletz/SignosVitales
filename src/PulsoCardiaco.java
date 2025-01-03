import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class PulsoCardiaco implements ParametroDeSalud{
    private final int PULSO;
    private String MARCA_TEMPORAL;

    private static final int PULSO_BAJO = 60;
    private static final int PULSO_MODERADO = 100;
    private static final int PULSO_ALTO = 120;

    public PulsoCardiaco(int pulso) {
        this.PULSO = pulso;
    }

    public int obtenerPulso(){
        return PULSO;
    }

    @Override
    public boolean esNormal() {
        if(PULSO > PULSO_BAJO && PULSO < PULSO_MODERADO){
            return true;
        }else {
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
        if (PULSO < PULSO_BAJO) {
            return "Bradicardia";
        } else if (PULSO > PULSO_ALTO) {
            return "Taquicardia severa";
        } else if (PULSO > PULSO_MODERADO) {
            return "Taquicardia leve";
        } else {
            return "Ninguno";
        }
    }

    @Override
    public void evaluarRiesgo(String alteracion) {
        if (Objects.equals(alteracion, "Bradicardia")){
            System.out.println("Alteración: "+alteracion+"\n Riesgo: BAJO");
        }else if (Objects.equals(alteracion, "Taquicardia severa")){
            System.out.println("Alteración: "+alteracion+"\n Riesgo: ALTO");
        }else if (Objects.equals(alteracion, "Taquicardia leve")){
            System.out.println("Alteración: "+alteracion+"\n Riesgo: MODERADO");
        }else if (Objects.equals(alteracion, "Ninguno")){
            System.out.println("Sin riesgo inmediato. Mantener monitoreo.");
        }
    }
}
