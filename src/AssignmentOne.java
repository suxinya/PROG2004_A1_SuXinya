import java.util.ArrayList;
import java.util.Iterator;

public class AssignmentOne {
    // Main method: Program entrance
    private static ArrayList<Appointment> appointmentList = new ArrayList<>();
    public static void main(String[] args) {
        // ------------------------------
        // Part 3 – Using classes and objects
        // ------------------------------
        System.out.println("【Part 3：Display of medical professionals】");

        // 1. Create 3 general practitioner objects
        GeneralPractitioner gp1 = new GeneralPractitioner(101, "Dr. Zhang", "General practice", 15);
        GeneralPractitioner gp2 = new GeneralPractitioner(102, "Dr. Li", "General practice", 20);
        GeneralPractitioner gp3 = new GeneralPractitioner(-103, "Dr. Wang", "General practice", 5); // Verification of negative test ID

        // 2. Create 2 nutritionist objects
        Nutritionist diet1 = new Nutritionist(201, "Nutritionist Chen", "Clinical Nutrition", "Diabetes diet management");
        Nutritionist diet2 = new Nutritionist(202, "Nutritionist Liu", "Public Nutrition", "Child nutrition guidance");

        // 3. Call the printing method to display all object details
        gp1.printDetails();
        gp2.printDetails();
        gp3.printDetails();
        diet1.printDetails();
        diet2.printDetails();

        System.out.println("------------------------------");

        // ------------------------------
        // Part 5 – Collection of appointments
        // ------------------------------
        System.out.println("\n【Part 5：Appointment Collection Management Display】");
        System.out.println("==================================");

        // 1. Create 2 appointments for general practitioners
        createAppointment("Jack", "0412345678", "09:30", gp1);
        createAppointment("Lucy", "0487654321", "14:00", gp2);

        // 2. Create 2 nutritionist appointments
        createAppointment("Luca", "0411223344", "10:15", diet1);
        createAppointment("Jenny", "0455667788", "15:30", diet2);

        // 3. Invalid test appointment
        createAppointment("Mike", "12345", "16:00", diet1);

        // 4. Print existing appointments
        System.out.println("\n【Part 5-1：All appointment lists】");
        printExistingAppointments();

        // 5. Cancel an appointment
        System.out.println("\n【Part 5-2：Cancel reservation (phone number: 0412345678)】");
        cancelBooking("0412345678");

        // 6. Print the appointment again and display the updated list
        System.out.println("\n【Part 5-3：Cancelled appointment list】");
        printExistingAppointments();

        System.out.println("------------------------------");
    }

    // ------------------------------
    // Part5 Core Method: Create Appointment
    // ------------------------------
    /**
     * @param patientName Patient's name
     * @param patientMobile Patient's mobile phone number (10 digits)
     * @param timeSlot Medical consultation period (HH: mm format)
     * @param doctor Appointment of medical personnel (parent type, supporting subcategories such as GP/nutritionist)
     * @return True: Created successfully; False: Creation failed
     */
    public static boolean createAppointment(String patientName, String patientMobile, String timeSlot, HealthProfessional doctor) {
        // Verification 1: Required information cannot be empty
        if (patientName == null || patientName.isEmpty()) {
            System.out.println("Failed to create appointment: Patient name cannot be empty");
            return false;
        }
        if (doctor == null) {
            System.out.println("Failed to create appointment: Invalid doctor object");
            return false;
        }

        // Verification 2: Phone Number Format
        if (!patientMobile.matches("\\d{10}")) {
            System.out.println("Failed to create appointment: Patient" + patientName + "the phone number(" + patientMobile + ")Format error (requires 10 digits)");
            return false;
        }

        // Verification 3: Time Format (HH: mm)
        if (!timeSlot.matches("\\d{2}:\\d{2}")) {
            System.out.println("Failed to create appointment: Patient" + patientName + "the time period(" + timeSlot + ")Format error (HH: mm required)");
            return false;
        }

        // Verification 4: Time periods are not repeated
        for (Appointment appt : appointmentList) {
            if (appt.getSelectedDoctor().getId() == doctor.getId() && appt.getTimeSlot().equals(timeSlot)) {
                System.out.println("Failed to create appointment: Doctor" + doctor.getName() + "at" + timeSlot + "time slot has been reserved");
                return false;
            }
        }

        // All verifications passed, create an appointment and add it to the collection
        Appointment newAppt = new Appointment(patientName, patientMobile, timeSlot, doctor);
        appointmentList.add(newAppt);
        System.out.println("Appointment created successfully: Patient" + patientName + " → " + doctor.getName() + "(" + timeSlot + ")");
        return true;
    }

    // ------------------------------
    // Part5 Core method: Print all appointments
    // ------------------------------
    public static void printExistingAppointments() {
        if (appointmentList.isEmpty()) {
            System.out.println("There are currently no appointment records available");
            return;
        }

        System.out.println("Existing appointments total " + appointmentList.size() + " about:");
        for (int i = 0; i < appointmentList.size(); i++) {
            System.out.println("\n[" + (i + 1) + "Appointment No.]");
            appointmentList.get(i).printAppointment();
        }
    }

    // ------------------------------
    // Part5 Core method: Cancel reservation
    // ------------------------------
    public static void cancelBooking(String mobile) {
        // Safely delete using iterators (to avoid Concurrent ModifierException)
        Iterator<Appointment> iterator = appointmentList.iterator();
        boolean isCancelled = false;

        while (iterator.hasNext()) {
            Appointment appt = iterator.next();
            if (appt.getPatientMobile().equals(mobile)) {
                // Obtain cancelled appointment information
                String patientName = appt.getPatientName();
                String doctorName = appt.getSelectedDoctor().getName();
                String timeSlot = appt.getTimeSlot();

                iterator.remove(); // Safely delete appointment
                System.out.println("Cancelled appointment successfully: Patient" + patientName + " → " + doctorName + "(" + timeSlot + ")");
                isCancelled = true;
                break; // Assuming one phone number corresponds to one appointment
            }
        }

        if (!isCancelled) {
            System.out.println("Cancel appointment failed:not found phone number " + mobile + "of the appointment");
        }
    }
}
