import java.util.Objects;

public class PulsoCardiaco implements SignoVital {
    private final int pulso;

    private static final int PULSO_BAJO = 60;
    private static final int PULSO_MODERADO = 100;
    private static final int PULSO_ALTO = 120;

    public PulsoCardiaco(int pulso) {
        this.pulso = pulso;
    }

    public String obtenerValor(){
        return String.valueOf(pulso);
    }

    @Override
    public String obtenerNombre(){
        return "Pulso Cardiaco";
    }

    @Override
    public String obtenerUnidad(){
        return "ppm";
    }

    @Override
    public boolean esNormal() {
        if(pulso > PULSO_BAJO && pulso < PULSO_MODERADO){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String obtenerAnomalia() {
        if (pulso < PULSO_BAJO) {
            return "Bradicardia";
        } else if (pulso > PULSO_ALTO) {
            return "Taquicardia severa";
        } else if (pulso > PULSO_MODERADO) {
            return "Taquicardia leve";
        } else {
            return "Ninguno";
        }
    }

    @Override
    public void procesarAnomalia(String alteracion)  {
        if (Objects.equals(alteracion, "Bradicardia")){
            System.out.println("Alteración: "+alteracion+"\n Riesgo: BAJO");
        }else if (Objects.equals(alteracion, "Taquicardia severa")){
            System.out.println("Alteración: "+alteracion+"\n Riesgo: ALTO");
        }else if (Objects.equals(alteracion, "Taquicardia leve")){
            System.out.println("Alteración: "+alteracion+"\n Riesgo: MODERADO");
        }
    }
}
