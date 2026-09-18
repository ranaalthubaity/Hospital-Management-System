
package HospitalManagementSystem;

/**
 *
 * @author ranaa
 */
public class Patient {
    
    //Fields
    private String patientId;
    private String name;
    private int age;
    private String diagnosis;
    
    //Constructor
    public Patient(String patientId ,String name, int age, String diagnosis){
    this.patientId = patientId;
    this.name = name;
    this.age = age;
    this.diagnosis = diagnosis;
    
    }
    
    //Getters
    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }
    
}
