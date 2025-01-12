import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void should_return_name_correctly() {
        ArrayList<VitalSign> vitalSigns = createVitalSigns();
        Person personTest = new Person("Juan", 21, vitalSigns);

        assertEquals("Juan", personTest.getName(), "El nombre no se retornó correctamente");
    }

    @Test
    void should_return_age_correctly() {
        ArrayList<VitalSign> vitalSigns = createVitalSigns();
        Person personTest = new Person("Juan", 21, vitalSigns);

        assertEquals(21, personTest.getAge(), "La edad no se retornó correctamente");
    }

    @Test
    void should_return_vital_signs_correctly() {
        ArrayList<VitalSign> vitalSigns = createVitalSigns();
        Person personTest = new Person("Juan", 21, vitalSigns);

        assertEquals(vitalSigns, personTest.getVitalSigns(), "Los signos vitales no se retornaron correctamente");
    }

    @Test
    void should_return_health_status_correctly() {
        ArrayList<VitalSign> vitalSigns = createVitalSigns();
        Person personTest = new Person("Juan", 21, vitalSigns);

        assertFalse(personTest.isHealthy(), "El estado de salud no se evaluó correctamente");
    }

    private ArrayList<VitalSign> createVitalSigns() {
        HeartRate pulse = new HeartRate(150);
        BloodPressure pressure = new BloodPressure(100, 70);
        Temperature temp = new Temperature(38, "C");

        ArrayList<VitalSign> vitalSigns = new ArrayList<>();
        vitalSigns.add(pulse);
        vitalSigns.add(pressure);
        vitalSigns.add(temp);

        return vitalSigns;
    }
}
