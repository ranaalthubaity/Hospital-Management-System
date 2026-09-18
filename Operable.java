
package HospitalManagementSystem;

/**
 *
 * @author ranaa
 */
public interface Operable {
    void scheduleOperation(Patient patient, String date);
    void completeOperation(Patient patient);
    
}
