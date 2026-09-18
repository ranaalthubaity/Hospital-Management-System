

package HospitalManagementSystem;

import java.util.ArrayList;

/**
 *
 * @author ranaa
 */
public class HospitalSystem {
    // List to store all medical staff members (Doctors, Nurses, and Surgeons)
    private ArrayList<MedicalStaff> staffList;
    
    // List to store all registered patients in the hospital
    private ArrayList<Patient> patientList;
    
    // List to store medical records that link staff members to patients
    private ArrayList<MedicalRecord> records;
    

    //Initializes the ArrayLists to manage staff, patients, and records.
    public HospitalSystem(){
    staffList = new ArrayList<>();
    patientList = new ArrayList<>();
    records = new ArrayList<>();
    
    }
    
 // #1 ----------------------------------------
    
public String addDoctor( String staffId, String name, double salary ,String specialty, int yearsOfExperience) {
    // Creates a Doctor object and stores it in the staffList.
    Doctor doctor = new Doctor(staffId, name, salary, specialty, yearsOfExperience);
    
    staffList.add(doctor); //// Add the new doctor to the global staff list
    
    // Return confirmation message
    return "Doctor " + name + " added successfully.";
}


// #2 ----------------------------------------

 public String addNurse( String staffId, String name, double salary,String shift, String department) {
    // Create a new Nurse instance using the provided information
     Nurse nurse = new Nurse(staffId, name, salary, shift, department);
     
     staffList.add(nurse); // Add the nurse to the staffList 
     
   // Return confirmation for the output file
     return "Nurse " + name + " added successfully.";
 
 }
 // #3 ----------------------------------------      
 public String addSurgeon( String staffId, String name, double salary , String surgeryType, int operatingRoom) {
 Surgeon surgeon = new Surgeon(staffId, name, salary, surgeryType, operatingRoom);
 
   // Add the surgeon to the general staff list
   staffList.add(surgeon);
        
   // Return success message matching the expected output format
   return "Surgeon " + name + " added successfully.";
 
 }
 // #4 ---------------------------------------- 
 public String addPatient(String patientId ,String name, int age, String diagnosis){
 // Create a new Patient object to store their medical information
        Patient patient = new Patient(patientId, name, age, diagnosis);
        
        // Add the patient to the dedicated PatientList
        patientList.add(patient);
        
        // Return confirmation for the output file
        return "Patient " + name + " added successfully.";
 }
   
// Helper method to find a staff member by their ID
    private MedicalStaff findStaff(String staffId) {
        // Loop through the staff list to find a match
        for (MedicalStaff s : staffList) {
            // Check if the current staff ID matches the one we are looking for
            if (s.getStaffId().equals(staffId)) {
                return s; // Return the staff member if found
            }
        }
        return null; // Return null if the staff member is not in the list
    }

    // Helper method to find a patient by their ID
    private Patient findPatient(String patientId) {
        // Search through the patient list one by one
        for (Patient p : patientList) {
            // Compare the IDs using the equals method
            if (p.getPatientId().equals(patientId)) {
                return p; // Return the patient object
            }
        }
        return null; // Return null if the patient is not found
    }
    
   // Helper method to find a medical record by staff ID and patient ID
    private MedicalRecord findRecord(String staffId, String patientId) {
        // Loop through the records list to find a match
        for (MedicalRecord r : records) {
            // Check if both staff ID and patient ID match the record
            if (r.getStaff().getStaffId().equals(staffId) && 
                r.getPatient().getPatientId().equals(patientId)) {
                return r; // Return the medical record if found
            }
        }
        return null; // Return null if no matching record is found
    }
 
 // #5 ----------------------------------------
 public String assignStaff(String staffId ,String patientId, String treatment){
     // Find the staff and patient objects using their IDs
        MedicalStaff staff = findStaff(staffId);
        Patient patient = findPatient(patientId);
        
        // Create a new medical record to link them together
            MedicalRecord record = new MedicalRecord(staff, patient, treatment ,"Active");
            
            // Add the new record to the records list
            records.add(record);
        
 return "Staff " + staffId + " assigned to patient " + patient.getName() + " successfully.";
 }
 
 // #6 ----------------------------------------
  public String prescribe(String staffId ,String patientId, String medication){
      // First, find the staff and the patient
        MedicalStaff staff = findStaff(staffId);
        Patient patient = findPatient(patientId);
     
        // Check if both exist
        if (staff instanceof Prescribable) {
            
            ((Prescribable) staff).prescribeMedication(patient, medication);
        String Type = (staff instanceof Surgeon)? "Surgeon" : "Doctor";
        
        
 return Type +" " + staff.getName() + " prescribed " + medication + " to " + patient.getName() + " successfully.";
 }
        else {
        return "Error: Staff member " + staff.getName() + " is not authorized to prescribe medication.";
           
        }
  }
  
  
 // #7 ----------------------------------------
   
    public String scheduleOperation(String staffId, String patientId, String data) {
        MedicalStaff s = findStaff(staffId);
        Patient p = findPatient(patientId);

        // Check if both exist
        if (s != null && p != null) {
            if (s instanceof Operable) {
                ((Operable) s).scheduleOperation(p, data);
                
                MedicalRecord r = findRecord(staffId, patientId);
                if (r != null) {
                    r.setStatus("scheduled");
                }
                return "Operation scheduled for " + p.getName() + " by Surgeon " + s.getName() + " on " + data + ".";
            }
            // If the staff is not a Surgeon
            return "Error: Staff member " + s.getName() + " is not authorized to schedule operations.";
        }
        
        // This is the safety return if IDs are wrong
        return "Error: Operation could not be scheduled.";
    }

// #8 ----------------------------------------
    public String completeOperation(String staffId, String patientId) {
        // Find the staff and patient objects
        MedicalStaff s = findStaff(staffId);
        Patient p = findPatient(patientId);
        
        // Find the medical record using staff and patient IDs
        MedicalRecord r = findRecord(staffId, patientId);

        // Check if staff and patient exist
        if (s != null && p != null) {
            // Check if the staff member is a Surgeon
            if (s instanceof Operable) {
                // Check if the record was found
                if (r != null) {
                    // Complete the operation and update status
                    ((Operable) s).completeOperation(p);
                    r.setStatus("Completed");
                    
                    return "Operation for " + p.getName() + " by Surgeon " + s.getName() + " completed successfully.";
                }
            } else {
                // If the staff is not a Surgeon (Matches the image logic)
                return "Error: Staff member " + s.getName() + " is not authorized to complete operations.";
            }
        }
        
        // Default error message
        return "Error: Operation could not be completed.";
    }

  // #9 -----------------------------------------
public String printAllStaff() {
    StringBuilder sb = new StringBuilder();
    sb.append("===============================================================\n");
    sb.append(String.format("%-10s %-20s %-10s %-15s\n", "ID", "Name", "Type", "Salary"));
    sb.append("===============================================================\n");

    
    // Loop through all staff members in the staff list
    for (MedicalStaff s : staffList) {
       
         // Determine the type of staff (Doctor, Nurse, or Surgeon)
        String type = "";
        if (s instanceof Doctor) type = "Doctor";
        else if (s instanceof Nurse) type = "Nurse";
        else if (s instanceof Surgeon) type = "Surgeon";

         // Print basic staff information (ID, Name, Type, Salary)
        sb.append(String.format("%-10s %-20s %-10s $%-15.2f\n", 
                s.getStaffId(), s.getName(), type, s.getSalary()));

          // Cast to Doctor to access doctor-specific attributes
        if (s instanceof Doctor) {
            Doctor d = (Doctor) s;
            sb.append(String.format("   Specialty: %s | Experience: %d years\n", 
                    d.getSpecialty(), d.getYearsOfExperience()));
        } 
          // Cast to Nurse to access nurse-specific attributes
        else if (s instanceof Nurse) {
            Nurse n = (Nurse) s;
            sb.append(String.format("   Shift: %s | Department: %s\n", 
                    n.getShift(), n.getDepartment()));
        } 
           // Cast to Surgeon to access surgeon-specific attributes
        else if (s instanceof Surgeon) {
            Surgeon sur = (Surgeon) s;
            sb.append(String.format("   Surgery Type: %s | Operating Room: %d\n", 
                    sur.getSurgeryType(), sur.getOperatingRoom()));
        }
    }
    
    sb.append("===============================================================\n");
    return sb.toString();
}
 
 
  
 // #10 ----------------------------------------
  public String printAllPatients(){
      StringBuilder sb = new StringBuilder();
      
    sb.append("===============================================================\n");
    sb.append(String.format("%-10s %-20s %-10s %-15s\n", "ID", "Name", "Age", "Diagnosis"));
    sb.append("===============================================================\n");
    
       // Loop through all patients in the patient list
    for (Patient p : patientList) {
 
        // print each patient's info
        sb.append(String.format("%-10s %-20s %-10d %-15s\n", 
                p.getPatientId(), p.getName(), p.getAge(), p.getDiagnosis()));
    }
    
    sb.append("===============================================================\n");
    return sb.toString();

 }
  
 // #11 ----------------------------------------
public String printPatientRecords(String patientId){

    // find the patient using id
    Patient p = findPatient(patientId);

    // if patient not found show error
    if (p == null) {
        return "Error: Patient not found.";
    }

  
    StringBuilder sb = new StringBuilder();

    // print title with patient name and id
    sb.append("--------- Medical Records for Patient: ")
      .append(p.getName())
      .append(" (ID: ").append(patientId)
      .append(") ---------\n");

    // loop through all records
    for (MedicalRecord r : records) {

        // check if record belongs to this patient
        if (r.getPatient().getPatientId().equals(patientId)) {

            // get staff from record
            MedicalStaff s = r.getStaff();

          
            sb.append("-------------------------------------------------------------\n");
            sb.append("Staff         : ").append(s.getName())
              .append(" (ID: ").append(s.getStaffId()).append(")\n");

            // check type of staff
            if (s instanceof Doctor) {
                Doctor d = (Doctor) s;

                sb.append("Staff Type    : Doctor\n");
                sb.append("Treatment     : ").append(r.getTreatment()).append("\n");
                sb.append("Status        : ").append(r.getStatus()).append("\n");
                sb.append("Specialty     : ").append(d.getSpecialty()).append("\n");
                sb.append("Experience    : ").append(d.getYearsOfExperience()).append(" years\n");

            } else if (s instanceof Nurse) {
                Nurse n = (Nurse) s;

                sb.append("Staff Type    : Nurse\n");
                sb.append("Treatment     : ").append(r.getTreatment()).append("\n");
                sb.append("Status        : ").append(r.getStatus()).append("\n");
                sb.append("Shift         : ").append(n.getShift()).append("\n");
                sb.append("Department    : ").append(n.getDepartment()).append("\n");

            } else if (s instanceof Surgeon) {
                Surgeon surg = (Surgeon) s;

                sb.append("Staff Type    : Surgeon\n");
                sb.append("Treatment     : ").append(r.getTreatment()).append("\n");
                sb.append("Status        : ").append(r.getStatus()).append("\n");
                sb.append("Surgery Type  : ").append(surg.getSurgeryType()).append("\n");
                sb.append("Operating Room: ").append(surg.getOperatingRoom()).append("\n");
            }

            // print duties for all staff
            sb.append("Duties        : ").append(s.getDuties()).append("\n");

          
            sb.append("-------------------------------------------------------------\n");
        }
    }

    
    return sb.toString();
}
 }
 
        

