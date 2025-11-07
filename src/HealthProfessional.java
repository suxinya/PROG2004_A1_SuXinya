public class HealthProfessional {
    // 1. Instance variable
    private int id;
    private String name;
    private String specialization; // Shared additional attributes: Professional field.

    // 2. Default construction method
    public HealthProfessional() {
        this.id = 0;
        this.name = "Not set";
        this.specialization = "Not set";
    }

    // 3. Parameterized construction method
    public HealthProfessional(int id, String name, String specialization) {
        // Data verification: ID cannot be negative
        if (id > 0) {
            this.id = id;
        } else {
            System.out.println("ID must be a positive number, set to default value of 0");
            this.id = 0;
        }
        this.name = name;
        this.specialization = specialization;
    }

    // 4. Print all instance variables
    public void printDetails() {
        System.out.println("=== Details of medical professionals ===");
        System.out.println("ID：" + this.id);
        System.out.println("Name：" + this.name);
        System.out.println("Professional field：" + this.specialization);
    }

    // 5. Getter 和 Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            System.out.println("ID must be a positive number");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
