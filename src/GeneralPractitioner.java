public class GeneralPractitioner extends HealthProfessional {
    // 1. Subclass specific instance variables (distinguishing general practitioners from other types)
    private int consultationDuration; // Reception duration (unit: minutes)

    // 2. Default construction method
    public GeneralPractitioner() {
        super(); // Call the non parametric construction of the parent class HealthProfessional
        this.consultationDuration = 15; // Default 15 minutes
    }

    // 3. Constructed with parameters (initializes all variables, including parent class properties)
    public GeneralPractitioner(int id, String name, String specialization, int consultationDuration) {
        // Call the parent class with parameter construction to initialize the parent class properties.
        super(id, name, specialization);
        // Data verification: The duration cannot be less than 5 minutes.
        if (consultationDuration >= 5) {
            this.consultationDuration = consultationDuration;
        } else {
            System.out.println("The reception time cannot be less than 5 minutes, which has been set as the default 15 minutes.");
            this.consultationDuration = 15;
        }
    }

    // 4. Rewrite printing method (including subclass specific attributes)
    @Override
    public void printDetails() {
        super.printDetails(); // Call the parent class printing method to avoid code duplication.
        System.out.println("Medical personnel type: General practitioner");
        System.out.println("Reception duration:" + this.consultationDuration + " Minute/position");
        System.out.println("======================");
    }

    // 5. Getter and Setter
    public int getConsultationDuration() {
        return consultationDuration;
    }

    public void setConsultationDuration(int consultationDuration) {
        if (consultationDuration >= 5) {
            this.consultationDuration = consultationDuration;
        } else {
            System.out.println("The reception time cannot be less than 15 minutes.");
        }
    }
}
