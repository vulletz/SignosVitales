public class BloodPressure implements VitalSign {
    private final int systolic;
    private final int diastolic;

    private static final int HIGH_SYSTOLIC_PRESSURE = 140;
    private static final int LOW_SYSTOLIC_PRESSURE = 90;
    private static final int HIGH_DIASTOLIC_PRESSURE = 90;
    private static final int LOW_DIASTOLIC_PRESSURE = 60;

    public BloodPressure(int systolic, int diastolic) {
        this.systolic = systolic;
        this.diastolic = diastolic;
    }

    public int getSystolic(){
        return systolic;
    }
    public int getDiastolic(){
        return diastolic;
    }

    public String getValue() { return systolic + "/" + diastolic; }

    @Override
    public String getName(){
        return "Presión Arterial";
    }

    @Override
    public String getUnit(){
        return "mmHg";
    }

    @Override
    public boolean isNormal() {
        return systolic >= LOW_SYSTOLIC_PRESSURE && systolic <= HIGH_SYSTOLIC_PRESSURE
                && diastolic >= LOW_DIASTOLIC_PRESSURE && diastolic <= HIGH_DIASTOLIC_PRESSURE;
    }

    @Override
    public String getAnomaly() {
        if (systolic > HIGH_SYSTOLIC_PRESSURE || diastolic > HIGH_DIASTOLIC_PRESSURE) {
            return "Hipertensión";
        }
        if (systolic < LOW_SYSTOLIC_PRESSURE || diastolic < LOW_DIASTOLIC_PRESSURE) {
            return "Hipotensión";
        }
        return "Ninguno";
    }
}
