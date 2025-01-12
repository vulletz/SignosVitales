import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeartRateTest {

    @Test
    void should_calculate_heart_rate_value_correctly() {
        HeartRate heartRate = new HeartRate(50);
        assertEquals("50", heartRate.getValue(), "El valor del pulso cardíaco no se calculó correctamente");
    }

    @Test
    void should_return_unit_correctly() {
        HeartRate heartRate = new HeartRate(50);
        assertEquals("ppm", heartRate.getUnit(), "La unidad del pulso cardíaco no se retornó correctamente");
    }

    @Test
    void should_calculate_anomaly_correctly() {
        HeartRate heartRate = new HeartRate(50);
        assertEquals("Bradicardia", heartRate.getAnomaly(), "La anomalía del pulso cardíaco no se calculó correctamente");
    }

    @Test
    void should_not_be_normal_when_value_is_outside_acceptable_params() {
        HeartRate heartRate = new HeartRate(40);
        assertFalse(heartRate.isNormal(), "El rango isNormal no se evaluó correctamente como fuera de rango");
    }

    @Test
    void should_be_normal_when_value_is_within_acceptable_params() {
        HeartRate heartRate = new HeartRate(70);
        assertTrue(heartRate.isNormal(), "El rango isNormal no se evaluó correctamente como dentro de rango");
    }
}
