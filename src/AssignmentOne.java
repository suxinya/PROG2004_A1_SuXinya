public class AssignmentOne {
    // Main method: Program entrance
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
    }
}
