
package HospitalManagementSystem;

import java.util.ArrayList;


public class Surgeon extends MedicalStaff implements Prescribable , Operable {
    
   //Fields
    private String surgeryType;
    private int operatingRoom;
    private ArrayList<String> Prescriptions;
    private ArrayList<String> Operation;

     //Constructor
    public Surgeon( String staffId, String name, double salary , String surgeryType, int operatingRoom) {
        super(staffId, name, salary);
        this.surgeryType = surgeryType;
        this.operatingRoom = operatingRoom;
        this.Prescriptions = new ArrayList<>(); 
        this.Operation = new ArrayList<>();
    }

    //Getters
    public String getSurgeryType() {
        return surgeryType;
    }

    public int getOperatingRoom() {
        return operatingRoom;
    }
    
    
     
    @Override
    public void prescribeMedication(Patient patient, String medication){
       Prescriptions.add(medication+" for "+ patient.getName());
    
    }
    
    @Override
    public String getDuties (){
        // add completed operation
     return"Perform surgical operations, prescribe medication, and manage surgical cases.";
     
     }

    
    @Override
    public String getPrescriptions () {
    StringBuilder sb = new StringBuilder ();
    
    // loop through prescriptions
for (int i = 0; i < Prescriptions.size (); i++) {
       sb.append(Prescriptions.get (i));
       
   if (i < Prescriptions.size() - 1) {
    sb. append (", ");
   }
}
return sb.toString();
    }
    
    @Override
  // add scheduled operation
    public void scheduleOperation(Patient patient, String date){
    Operation.add("Schedualed : " + patient.getName() + " on " + date);
    }
    
    @Override
     // add completed operation
     public void completeOperation(Patient patient){
    Operation.add("Completed surgery for  " + patient.getName() );
    
    }
}


        
