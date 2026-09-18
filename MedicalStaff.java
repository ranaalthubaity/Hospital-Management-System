

package HospitalManagementSystem;

/**
 *
 * @author ranaa
 */
public abstract class MedicalStaff {
    //Fields
    private String staffId;
    private String name;
    private double salary;

    //Constructor
    public MedicalStaff(String staffId, String name, double salary) {
        this.staffId = staffId;
        this.name = name;
        this.salary = salary;
        
    }
    
    
    //Getters
    public String getStaffId() {
        return staffId;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
    
    public abstract String getDuties ();
    
    
    
         

}
