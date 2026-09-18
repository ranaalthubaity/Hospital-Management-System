
package HospitalManagementSystem;



/**
 *
 * @author ranaa
 */
public interface Prescribable {
    
    void prescribeMedication(Patient patient, String medication);
    String getPrescriptions();
    
    
}
