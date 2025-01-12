import java.util.ArrayList;

public class Person {
    private final String name;
    private final int age;
    private final ArrayList<VitalSign> vitalSigns;

    public Person(String name, int age, ArrayList<VitalSign> vitalSigns) {
        this.name = name;
        this.age = age;
        this.vitalSigns = vitalSigns;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<VitalSign> getVitalSigns() {
        return vitalSigns;
    }

    public boolean isHealthy() {
        return vitalSigns.stream().allMatch(VitalSign::isNormal);
    }
}
