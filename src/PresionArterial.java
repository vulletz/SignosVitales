import java.util.Objects;

public class PresionArterial implements SignoVital {
    private final int sistolica;
    private final int diastolica;

    private static final int PRESION_SISTOLICA_ALTA = 140;
    private static final int PRESION_SISTOLICA_BAJA = 90;
    private static final int PRESION_DIASTOLICA_ALTA = 90;
    private static final int PRESION_DIASTOLICA_BAJA = 60;

    public PresionArterial(int sistolica, int diastolica) {
        this.sistolica = sistolica;
        this.diastolica = diastolica;
    }

    public int obtenerSistolica(){
        return sistolica;
    }
    public int obtenerDiastolica(){
        return diastolica;
    }

    public String obtenerValor() { return sistolica + "/" + diastolica; }

    @Override
    public String obtenerNombre(){
        return "Presión Arterial";
    }

    @Override
    public String obtenerUnidad(){
        return "mmHg";
    }

    @Override
    public boolean esNormal() {
        if (sistolica > PRESION_SISTOLICA_ALTA || diastolica > PRESION_DIASTOLICA_ALTA) {
            return false;
        } else if (sistolica < PRESION_SISTOLICA_BAJA || diastolica < PRESION_DIASTOLICA_BAJA) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String obtenerAnomalia() {
        if (sistolica > PRESION_SISTOLICA_ALTA || diastolica > PRESION_DIASTOLICA_ALTA) {
            return "Hipertensión";
        } else if (sistolica < PRESION_SISTOLICA_BAJA || diastolica < PRESION_DIASTOLICA_BAJA) {
            return "Hipotensión";
        } else {
            return "Ninguno";
        }
    }

    @Override
    public void procesarAnomalia(String alteracion) {
        if (Objects.equals(alteracion, "Hipertensión") || Objects.equals(alteracion, "Hipotensión")){
            System.out.println("Alteración: "+alteracion+"\n Riesgo: ALTO");
        }
    }
}
