public class AssistantCoach extends Coach {
    private String specialty;

    public AssistantCoach() {
        super();
        this.specialty = "General";
    }

    public AssistantCoach(String name, String dateOfBirth, double height, double weight,
                          String nationality, String gender, int yearsExperience,
                          Team team, String specialty) {
        super(name, dateOfBirth, height, weight, nationality, gender, yearsExperience, team);
        this.specialty = "General";
        setSpecialty(specialty);
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        if (specialty == null || specialty.trim().isEmpty()) {
            System.out.println("Specialty cannot be empty.");
        } else {
            this.specialty = specialty.trim();
        }
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Specialty: " + specialty);
    }

    @Override
    public String getRole() {
        return "Assistant Coach";
    }
}
