import java.time.LocalDate;
import java.time.Period;

public abstract class Person {

    // Person attributes
    private String name;
    private char gender;
    private String nationality;
    private double heightInCm;
    private double weightInKg;
    private LocalDate dateOfBirth;

    // Default constructor
    public Person() {
    }

    // Parameterized constructor (uses the setters so the validation runs)
    public Person(String name, char gender, String nationality,
                  double heightInCm, double weightInKg, LocalDate dateOfBirth) {
        setName(name);
        setGender(gender);
        setNationality(nationality);
        setHeightInCm(heightInCm);
        setWeightInKg(weightInKg);
        setDateOfBirth(dateOfBirth);
    }

    // Getters
    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public String getNationality() {
        return nationality;
    }

    public double getHeightInCm() {
        return heightInCm;
    }

    public double getWeightInKg() {
        return weightInKg;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    // Setters (final, because the constructor calls them)
    public final void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public final void setGender(char gender) {
        char g = Character.toUpperCase(gender);
        if (g != 'M' && g != 'F') {
            throw new IllegalArgumentException("Gender must be 'M' or 'F'");
        }
        this.gender = g;
    }

    public final void setNationality(String nationality) {
        if (nationality == null || nationality.isBlank()) {
            throw new IllegalArgumentException("Nationality cannot be empty");
        }
        this.nationality = nationality;
    }

    public final void setHeightInCm(double heightInCm) {
        if (heightInCm <= 0) {
            throw new IllegalArgumentException("Height must be positive");
        }
        this.heightInCm = heightInCm;
    }

    public final void setWeightInKg(double weightInKg) {
        if (weightInKg <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        this.weightInKg = weightInKg;
    }

    public final void setDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth == null || dateOfBirth.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Date of birth must be a valid past date");
        }
        this.dateOfBirth = dateOfBirth;
    }

    // Age calculator method (calculated, not stored)
    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    // Role specification method
    public abstract String getRole();

    @Override
    public String toString() {
        return getRole() + ": " + name;
    }
}
