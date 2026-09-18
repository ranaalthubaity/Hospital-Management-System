
package HospitalManagementSystem;

import java.util.ArrayList;


public class Doctor extends MedicalStaff implements Prescribable {
    
     //Fields
     private String specialty;
     private int yearsOfExperience;
     private ArrayList<String> prescriptions;

      // constructor to initialize doctor info
    public Doctor( String staffId, String name, double salary ,String specialty, int yearsOfExperience) {
        super(staffId, name, salary);
        this.specialty = specialty;
        this.yearsOfExperience = yearsOfExperience;
        this.prescriptions = new ArrayList <>();
        
    }
 // return doctor's specialty
    public String getSpecialty() {
        return specialty;
    }

    // return years of experience
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
     
     
     @Override
     public void prescribeMedication(Patient patient, String medication){
     prescriptions.add(medication+" for  "+ patient.getName());
     
         
     } 
     
     @Override
     public String getPrescriptions (){
     StringBuilder Sbuilder = new StringBuilder();
     
      // loop through all prescriptions
     for(int i =0 ;i<prescriptions.size();i++){
    Sbuilder.append(prescriptions.get(i));
    if(i<prescriptions.size() - 1)
        Sbuilder.append(" , ");
    
     }
      return Sbuilder.toString();
     }
     
     
     @Override
     public String getDuties (){
     // return doctor's duties
     return"Diagnose patients, prescribe medication, and provide specialist care.";
     
     }
    
}
