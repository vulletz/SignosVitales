import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {

    @Test
    void should_return_name_correctly() {
        Temperature temperatureTest = new Temperature(38.5, "C");
        assertEquals("Temperatura", temperatureTest.getName(), "El nombre no se retornó correctamente");
    }

    @Test
    void should_return_anomaly_correctly() {
        Temperature temperatureTest = new Temperature(38.5, "C");
        assertEquals("Fiebre", temperatureTest.getAnomaly(), "La anomalía no se evaluó correctamente");
    }

    @Test
    void should_return_value_correctly() {
        Temperature temperatureTest = new Temperature(38.5, "C");
        assertEquals("38.5", temperatureTest.getValue(), "El valor no se retornó correctamente");
    }

    @Test
    void should_return_unit_correctly() {
        Temperature temperatureTest = new Temperature(38.5, "C");
        assertEquals("C", temperatureTest.getUnit(), "La unidad no se retornó correctamente");
    }

    @Test
    void should_not_be_normal_when_value_is_outside_acceptable_params() {
        Temperature temperatureTest = new Temperature(38.5, "C");
        assertFalse(temperatureTest.isNormal(), "El rango isNormal no se evaluó correctamente como fuera de rango");
    }

    @Test
    void should_be_normal_when_value_is_within_acceptable_params() {
        Temperature temperatureTest = new Temperature(36.5, "C");
        assertTrue(temperatureTest.isNormal(), "El rango isNormal no se evaluó correctamente como dentro de rango");
    }
}
