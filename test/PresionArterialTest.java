import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PresionArterialTest {

    @Test
    void testPresionArterial(){
        PresionArterial presion = new PresionArterial(150, 95);
        assertAll(
                () -> assertEquals("150/95", presion.obtenerValor()),
                () -> assertEquals("mmHg", presion.obtenerUnidad()),
                () -> assertEquals("Hipertensión", presion.obtenerAnomalia()),
                () -> assertEquals(false, presion.esNormal()),
                () -> assertEquals(150, presion.obtenerSistolica()),
                () -> assertEquals(95, presion.obtenerDiastolica())
        );
    }
}