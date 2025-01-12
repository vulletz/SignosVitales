import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BloodPressureTest {

    @Test
    void should_calculate_value_correctly() {
        BloodPressure bloodPressure = new BloodPressure(150, 95);
        assertEquals("150/95", bloodPressure.getValue(), "El valor de presión arterial no se calculó correctamente");
    }

    @Test
    void should_return_unit_correctly() {
        BloodPressure bloodPressure = new BloodPressure(150, 95);
        assertEquals("mmHg", bloodPressure.getUnit(), "La unidad de presión arterial no se retornó correctamente");
    }

    @Test
    void should_calculate_anomaly_correctly() {
        BloodPressure bloodPressure = new BloodPressure(150, 95);
        assertEquals("Hipertensión", bloodPressure.getAnomaly(), "La anomalía no se calculó correctamente");
    }

    @Test
    void should_not_be_normal_when_value_is_outside_acceptable_params() {
        BloodPressure bloodPressure = new BloodPressure(150, 95);
        assertFalse(bloodPressure.isNormal(), "El rango isNormal no se evaluó correctamente como fuera de rango");
    }

    @Test
    void should_be_normal_when_value_is_within_acceptable_params() {
        BloodPressure bloodPressure = new BloodPressure(120, 80);
        assertTrue(bloodPressure.isNormal(), "El rango isNormal no se evaluó correctamente como dentro de rango");
    }

    @Test
    void should_return_systolic_correctly() {
        BloodPressure bloodPressure = new BloodPressure(150, 95);
        assertEquals(150, bloodPressure.getSystolic(), "El valor sistólico no se retornó correctamente");
    }

    @Test
    void should_return_diastolic_correctly() {
        BloodPressure bloodPressure = new BloodPressure(150, 95);
        assertEquals(95, bloodPressure.getDiastolic(), "El valor diastólico no se retornó correctamente");
    }
}
