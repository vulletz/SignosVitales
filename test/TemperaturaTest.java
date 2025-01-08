import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperaturaTest {

    @Test
    void testTemperatura(){
        Temperatura temperaturaTest = new Temperatura(38.5, "C");
        assertAll(
                () -> assertEquals("Temperatura", temperaturaTest.obtenerNombre()),
                () -> assertEquals("Fiebre", temperaturaTest.obtenerAnomalia()),
                () -> assertEquals("38.5", temperaturaTest.obtenerValor()),
                () -> assertEquals("C", temperaturaTest.obtenerUnidad())
        );

    }

}