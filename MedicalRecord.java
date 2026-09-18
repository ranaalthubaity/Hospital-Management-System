
package HospitalManagementSystem;

/**
 *
 * @author ranaa
 */
public class MedicalRecord {
    
  //Fields
  private MedicalStaff staff;
  private Patient patient;
  private String treatment;
  private String status;
  
  //Constructor
    public MedicalRecord(MedicalStaff staff, Patient patient, String treatment, String status) {
        this.staff = staff;
        this.patient = patient;
        this.treatment = treatment;
        this.status = status;
    }

  
  //Getters
    public MedicalStaff getStaff() {
        return staff;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getTreatment() {
        return treatment;
    }

    public String getStatus() {
        return status;
    }
  
    //Setter
    public void setStaff(MedicalStaff staff) {
        this.staff = staff;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
  
}
