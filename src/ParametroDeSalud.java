interface ParametroDeSalud {
    boolean esNormal();
    String marcaTemporal();
    String alteracionDetectada();
    void evaluarRiesgo(String alteracion);
}
