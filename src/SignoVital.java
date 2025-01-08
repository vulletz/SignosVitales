interface SignoVital {
    String obtenerNombre();
    String obtenerUnidad();
    String obtenerValor();
    String obtenerAnomalia();
    void procesarAnomalia(String anomalia);
    boolean esNormal();
}
