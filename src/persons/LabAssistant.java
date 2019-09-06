package persons;

import procedures.LabTest;

public class LabAssistant extends Person {
    public LabAssistant(String fullname, String gender, int age, String address, String phone, String bloodtype) {
        super(fullname, gender, age, address, phone, bloodtype);
    }

    public LabTest doLabTest(String tname){
        System.out.println("Getting samples ");
        double res=Math.random();
        LabTest labTest = new LabTest(tname);
        if(res>0.5) labTest.setResult(false);
        else labTest.setResult(true);
        return labTest;
    }

    public void displayInfo() {
        super.displayInfo();
    }
}
