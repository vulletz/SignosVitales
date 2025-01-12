import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class VitalSignsManager {
    public static void main(String[] args) {
        // creación de la persona
        Person person = generateRandomPerson();

        // evaluación de signos vitales de la persona creada
        evaluateSigns(person);
    }

    private static void evaluateSigns(Person person) {
        System.out.println("\nPersona Generada:\nNombre: " + person.getName() + "\nEdad: " + person.getAge());

        // iterar sobre la lista de signos vitales para evaluar cada uno
        for (VitalSign parameter : person.getVitalSigns()) {
            System.out.println("\nFecha: " + generateTimestamp());
            System.out.println("\n" + parameter.getName() + ": " + parameter.getValue() + " " + parameter.getUnit());
            System.out.println("\nAnomalia detectada: " + parameter.getAnomaly());
        }
        if (person.isHealthy()) {
            System.out.println("El Paciente " + person.getName() + " está saludable.");
        } else {
            System.out.println("El Paciente " + person.getName() + " tiene signos vitales fuera de rango.");
        }
    }

    private static String generateTimestamp(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return now.format(format);
    }

    private static Person generateRandomPerson() {
        Random rand = new Random();

        // datos aleatorios
        String name = "Sebastian Heredia";
        int age = rand.nextInt(100); // Edad aleatoria entre 0 y 99

        int heartRate = rand.nextInt(210 - 20 + 1) + 20; // 20 a 210 ppm
        int systolicPressure = rand.nextInt(180 - 90 + 1) + 90; // 90 a 180 mmHg
        int diastolicPressure = rand.nextInt((systolicPressure - 60)) + 60; // depende de la sistólica
        double temperature = 35 + rand.nextDouble() * 5; // 35 a 40 °C

        // creación de parámetros de salud
        HeartRate rate = new HeartRate(heartRate);
        BloodPressure pressure = new BloodPressure(systolicPressure, diastolicPressure);
        Temperature temp = new Temperature(temperature, "C");

        // creación de lista de signos vitales
        ArrayList<VitalSign> vitalSigns = new ArrayList<>();
        vitalSigns.add(rate);
        vitalSigns.add(pressure);
        vitalSigns.add(temp);

        return new Person(name, age, vitalSigns);
    }
}
