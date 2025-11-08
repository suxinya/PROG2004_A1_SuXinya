public class Appointment {
    // 1. Instance variable
    private String patientName;
    private String patientMobile;  // Patient's mobile phone number (used to cancel appointments)
    private String timeSlot;       // Medical consultation period
    private HealthProfessional selectedDoctor; // Appointed doctor (parent type, supports polymorphism)

    // 2. Default construction method
    public Appointment() {
        this.patientName = "Not set";
        this.patientMobile = "Not set";
        this.timeSlot = "Not set";
        this.selectedDoctor = new HealthProfessional();
    }

    // 3. Parameterized construction method (initialize all variables)
    public Appointment(String patientName, String patientMobile, String timeSlot, HealthProfessional selectedDoctor) {
        this.patientName = patientName;
        // Data verification: The phone number must be a 10 digit number
        if (patientMobile.matches("\\d{10}")) {
            this.patientMobile = patientMobile;
        } else {
            System.out.println("The format of the phone number is incorrect, it has been set to“Not set”");
            this.patientMobile = "Not set";
        }
        // Data validation: The time format must be HH: mm
        if (timeSlot.matches("\\d{2}:\\d{2}")) {
            this.timeSlot = timeSlot;
        } else {
            System.out.println("Time format error (HH: mm required), set to“Not set”");
            this.timeSlot = "Not set";
        }
        this.selectedDoctor = selectedDoctor;
    }

    // 4. Print appointment details
    public void printAppointment() {
        System.out.println("=== Appointment Details ===");
        System.out.println("Patient Name:" + this.patientName);
        System.out.println("Patient's mobile phone number:" + this.patientMobile);
        System.out.println("Medical consultation period:" + this.timeSlot);
        System.out.println("Appointment doctor：" + this.selectedDoctor.getName() + "（" + this.selectedDoctor.getSpecialization() + "）");
        System.out.println("======================");
    }

    // 5. Getter
    public String getPatientMobile() {
        return patientMobile;
    }

    public HealthProfessional getSelectedDoctor() {
        return selectedDoctor;
    }
}
