import persons.Doctor;
import persons.LabAssistant;
import persons.Patient;
import procedures.LabTest;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
//        File file = new File("output.csv");
//        file.createNewFile();
//        FileWriter writer = new FileWriter(file);
//
//        Patient p1 = new Patient(1, "John Locke", "Male", 52, "str. NameS nr. 5", "123456", "A+");
//        Doctor d1 = new Doctor(1,"Jack Shephard", "Male", 34, "str. NameS nr. 45", "654321", "O-", "spinal surgeon");
//        d1.seePacient(p1, "mental disease", "Ibuprofen", 2);
//        d1.seePacient(p1, "smth", "da", 1);
//        p1.displayInfo();
//        LabAssistant l1 = new LabAssistant("Juliet Burke", "Female", 31, "str. NameS nr. 44", "987654", "AB-");
//        LabTest lab1 = l1.doLabTest("Aids");
//        p1.takeLabTest(lab1);
//        p1.printDiagnoses();
//        Collections.sort(p1.getPrescriptions(), new Sortbypills());
//        p1.printDiagnoses();
//
//        List<Patient> records = new ArrayList<Patient>();
//        records.add(p1);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//        String time = dateFormat.format(new Date());
//        writer.write("addPatient," + time + '\n');
//        try (BufferedReader br = new BufferedReader(new FileReader("patientsfile.csv"))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] values = line.split(",");
//                int id = Integer.parseInt(values[0]);
//                int age = Integer.parseInt(values[3]);
//                String name = values[1];
//                String gender = values[2];
//                String address = values[4];
//                String phone = values[5];
//                String bloodt = values[6];
//                Patient pat = new Patient(id, name, gender, age, address, phone, bloodt);
//                records.add(pat);
//                SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//                String time1 = dateFormat1.format(new Date());
//                writer.write("addPatient," + time1 + '\n');
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        for (int i = 0; i < records.size(); i++) {
//            records.get(i).displayInfo();
//            System.out.println("\n");
//        }
//        writer.flush();
//        writer.close();

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartPage().setVisible(true);
            }
        });
    }

    }
