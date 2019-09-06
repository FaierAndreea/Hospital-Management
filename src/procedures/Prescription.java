package procedures;

public class Prescription {
    private String medicine;
    private int pillsPerDay;

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public int getPillsPerDay() {
        return pillsPerDay;
    }

    public void setPillsPerDay(int pillsPerDay) {
        this.pillsPerDay = pillsPerDay;
    }

    //constructor
    public Prescription(String medicine, int pillsPerDay) {
        this.medicine = medicine;
        this.pillsPerDay = pillsPerDay;
    }
}
