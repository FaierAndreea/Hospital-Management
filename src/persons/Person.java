package persons;

public abstract class Person {
    private String fullname;
    private String gender;
    private int age;
    private String address;
    private String phone;
    private String bloodtype;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBloodtype() {
        return bloodtype;
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }
    //constructor
    public Person(String fullname, String gender, int age, String address, String phone, String bloodtype) {
        this.fullname = fullname;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.bloodtype = bloodtype;
    }

    public void displayInfo(){
        System.out.println("Name : "+fullname+"\nGender : "+gender+
                "\nAge : "+age+ "\nAddress : "+address+ "\nPhone : "+phone
                +"\nBlood Type : "+bloodtype);
    }
}
