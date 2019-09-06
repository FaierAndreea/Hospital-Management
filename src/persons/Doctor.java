package persons;

import java.text.SimpleDateFormat;

public class Doctor extends Person{
    private int id;
    private String speciality;
    private static final String password="12345";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
    //constructor


    public Doctor(int id,String fullname, String gender, int age, String address, String phone, String bloodtype, String speciality) {
        super(fullname, gender, age, address, phone, bloodtype);
        this.speciality=speciality;
        this.id=id;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Speciality : "+speciality);
    }

    public void seePacient(Patient p, String disease, String medName, int nrPills){
        System.out.println("Examine the patient");
        p.addDiagnose(disease);
        p.addPrescription(medName,nrPills);
    }
}
