package persons;

import procedures.Diagnose;
import procedures.LabTest;
import procedures.Prescription;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Patient extends Person {
    private int id;
    private List<Diagnose> diagnoses = new ArrayList<Diagnose>();
    private List<Prescription> prescriptions= new ArrayList<Prescription>();
    private List<LabTest> labTests= new ArrayList<LabTest>();
    private int nr_diagnoses;
    private int nr_prescriptions;
    private int nr_labTests;

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public List<Diagnose> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(List<Diagnose> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public List<LabTest> getLabTests() {
        return labTests;
    }

    public void setLabTests(List<LabTest> labTests) {
        this.labTests = labTests;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNr_diagnoses() {
        return nr_diagnoses;
    }

    public void setNr_diagnoses(int nr_diagnoses) {
        this.nr_diagnoses = nr_diagnoses;
    }

    public int getNr_prescriptions() {
        return nr_prescriptions;
    }

    public void setNr_prescriptions(int nr_prescriptions) {
        this.nr_prescriptions = nr_prescriptions;
    }

    public int getNr_labTests() {
        return nr_labTests;
    }

    public void setNr_labTests(int nr_labTests) {
        this.nr_labTests = nr_labTests;
    }

    public void addDiagnose(String diseaseName){
        Diagnose d=new Diagnose(diseaseName);
        diagnoses.add(nr_diagnoses,d);
        nr_diagnoses++;
    }

    public void curedDisease(int index){
        diagnoses.remove(nr_diagnoses-1);
        nr_diagnoses--;
    }

    public void addPrescription(String medicineName, int nrPills){
        Prescription p=new Prescription(medicineName,nrPills);
        prescriptions.add(nr_prescriptions,p);
        nr_prescriptions++;
    }

    public void endPrescription(int index){
        prescriptions.remove(index);
        nr_prescriptions--;
    }

    public void displayInfo() {
        System.out.println("PatientID : "+id);
        super.displayInfo();
    }

    public void takeLabTest(LabTest labTest) {
        labTests.add(nr_labTests,labTest);
        nr_labTests++;
    }

    public void buyMeds(){
        System.out.println("Buying medication");
    }
    //constructor
    public Patient(int id, String fullname, String gender, int age, String address, String phone, String bloodtype) {
        super(fullname,gender,age,address, phone, bloodtype);
        this.id=id;
        nr_diagnoses=0;
        nr_prescriptions=0;
        nr_labTests=0;
    }

    public void printDiagnoses(){
        for (int i=0; i<nr_diagnoses;i++){
            System.out.println("Has: "+diagnoses.get(i).getDisease());
        }
        for (int i=0;i<nr_prescriptions; i++){
            System.out.println("Gets "+prescriptions.get(i).getMedicine()+", "+prescriptions.get(i).getPillsPerDay()+" pills/day ");
        }
        for (int i=0;i<nr_labTests;i++){
            System.out.println("Test for "+labTests.get(i).getTestName()+" is "+labTests.get(i).isResult());
        }
    }
}

class Sortbypills implements Comparator<Prescription>
{
    public int compare(Prescription a, Prescription b)
    {
        return a.getPillsPerDay() - b.getPillsPerDay();
    }
}