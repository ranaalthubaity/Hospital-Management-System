
package HospitalManagementSystem;

/**
 *
 * @author ranaa
 */
public class Nurse extends MedicalStaff {
    //fields
     private String shift ;
     private String department;

     //Constructor
    public Nurse( String staffId, String name, double salary,String shift, String department) {
        super(staffId, name, salary);
        this.shift = shift;
        this.department = department;
    }
    //Getters
    public String getShift() {
        return shift;
    }

    public String getDepartment() {
        return department;
    }
     
    
     @Override
    public String getDuties(){
        
    return"Provide patient care, assist medical staff, and monitor patient conditions.";
    
    }
     
}
