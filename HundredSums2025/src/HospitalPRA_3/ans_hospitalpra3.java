package HospitalPRA_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class ans_hospitalpra3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        ArrayList<Doctor> docList = new ArrayList<>();

        for(int i = 0; i<n; i++){
            Doctor d = new Doctor();
            d.setDocId(sc.nextInt()); sc.nextLine();
            d.setDocName(sc.nextLine());
            d.setSpecial(sc.nextLine());
            int m = sc.nextInt(); sc.nextLine();

            ArrayList<Patient> patientList = new ArrayList<>();
            for(int j = 0; j<m; j++){
                Patient a = new Patient();
                a.setPatientID(sc.nextInt());sc.nextLine();
                a.setPatientName(sc.nextLine());
                a.setIllness(sc.nextLine());

                patientList.add(a);
            }
            d.setPatientList(patientList);
            docList.add(d);
        }
        
        int docIdToFind = sc.nextInt(); sc.nextLine();
        String specialToFind = sc.nextLine();
        Doctor d = new Doctor();
        ArrayList<String> ansDoc = d.getUniqueIllnesses(docList, docIdToFind);
        if(ansDoc.isEmpty()){
            System.out.println("Doctor Not Found");
        }
        else{
            for(String dis: ansDoc){
                System.out.println(dis);

            }
        }
        ArrayList<String> specialDoc = d.getDoctorsBySpecialization(docList, specialToFind);
        if(specialDoc.isEmpty()){
            System.out.println("No Doctors Found");
        }
        else{
            for(String s: specialDoc){
                System.out.println(s);
            }
        }
        sc.close();
    }

    
}
class Doctor{
    int docId;
    String docName;
    String special;
    ArrayList<Patient> PatientList; //= new ArrayList<>();
    public int getDocId() {
        return docId;
    }
    public void setDocId(int docId) {
        this.docId = docId;
    }
    public String getDocName() {
        return docName;
    }
    public void setDocName(String docName) {
        this.docName = docName;
    }
    public String getSpecial() {
        return special;
    }
    public void setSpecial(String special) {
        this.special = special;
    }
    public ArrayList<Patient> getPatientList() {
        return PatientList;
    }
    public void setPatientList(ArrayList<Patient> patientList) {
        PatientList = patientList;
    }

    ArrayList<String> getUniqueIllnesses(ArrayList<Doctor> docList, int idToFind){
        HashSet<String> illSet = new HashSet();
        for(Doctor d: docList){
            if(d.getDocId()==idToFind){
                ArrayList<Patient> patientList = d.getPatientList();
                if(patientList !=null){
                    for(Patient p: patientList){
                        illSet.add(p.getIllness());

                    }
                }
            }
        }
        ArrayList<String> ansDoc = new ArrayList<>(illSet);
        Collections.sort(ansDoc);
        return ansDoc;
    }
    ArrayList<String> getDoctorsBySpecialization(ArrayList<Doctor> docList, String SpecialToFind){
        ArrayList<String> ansList = new ArrayList<>();
        for(Doctor d: docList){
            if(d.getSpecial().equalsIgnoreCase(SpecialToFind)){
                ansList.add(d.getDocName());
            }
        }

        return ansList;
    }

    

}
class Patient{
    int patientID;
    String patientName;
    String illness;
    public int getPatientID() {
        return patientID;
    }
    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }
    public String getPatientName() {
        return patientName;
    }
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    public String getIllness() {
        return illness;
    }
    public void setIllness(String illness) {
        this.illness = illness;
    }


}