import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PulsoCardiacoTest {

    @Test
    void testPulsoCardiaco(){
        PulsoCardiaco pulso = new PulsoCardiaco(50);
        assertAll(
                () -> assertEquals("50", pulso.obtenerValor()),
                () -> assertEquals("ppm", pulso.obtenerUnidad()),
                () -> assertEquals("Bradicardia", pulso.obtenerAnomalia())
        );
    }

}