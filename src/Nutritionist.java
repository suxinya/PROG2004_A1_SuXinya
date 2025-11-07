public class Nutritionist extends HealthProfessional {
    // 1. Subclass specific instance variables (distinguishing nutritionists from general practitioners)
    private String dietarySpecialty; // Dietary expertise

    // 2. Default construction method
    public Nutritionist() {
        super();
        this.dietarySpecialty = "Not set";
    }

    // 3. Parameterized construction method
    public Nutritionist(int id, String name, String specialization, String dietarySpecialty) {
        super(id, name, specialization); // Call parent class construction
        this.dietarySpecialty = dietarySpecialty;
    }

    // 4. Rewrite printing method (reflecting the uniqueness of subclasses)
    @Override
    public void printDetails() {
        super.printDetails(); // Reuse parent class code
        System.out.println("Medical personnel type: Nutritionist");
        System.out.println("Dietary expertise：" + this.dietarySpecialty);
        System.out.println("======================");
    }

    // 5. Getter and Setter
    public String getDietarySpecialty() {
        return dietarySpecialty;
    }

    public void setDietarySpecialty(String dietarySpecialty) {
        this.dietarySpecialty = dietarySpecialty;
    }
}
