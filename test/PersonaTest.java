import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {

    @Test
    void testPersona(){
        // creación de parámetros de salud
        PulsoCardiaco pulso = new PulsoCardiaco(150);
        PresionArterial presion = new PresionArterial(100, 70);
        Temperatura temp = new Temperatura(38, "C");

        // creación de lista de signos vitales
        ArrayList<SignoVital> signosVitales = new ArrayList<>();
        signosVitales.add(pulso);
        signosVitales.add(presion);
        signosVitales.add(temp);

        Persona personaTest = new Persona("Juan", 21, signosVitales);

        assertAll(
                () -> assertEquals("Juan", personaTest.obtenerNombre()),
                () -> assertEquals(21, personaTest.obtenerEdad()),
                () -> assertEquals(signosVitales, personaTest.obtenerSignosVitales())
        );
    }
}