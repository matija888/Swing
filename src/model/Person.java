package model;
import java.io.Serializable;

public class Person implements Serializable {
    private static int count = 0;

    private int id;
    private String name;
    private String occupation;
    private AgeCategory ageCategory;
    private EmployeeCategory empoloyeeCategory;
    private Gender gender;

    public Person(String name, String occupation, AgeCategory ageCategory, EmployeeCategory empoloyeeCategory, Gender gender) {
        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCategory;
        this.empoloyeeCategory = empoloyeeCategory;
        this.gender = gender;

        this.id = count;
        count++;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(AgeCategory ageCategory) {
        this.ageCategory = ageCategory;
    }

    public EmployeeCategory getEmpoloyeeCategory() {
        return empoloyeeCategory;
    }

    public void setEmpoloyeeCategory(EmployeeCategory empoloyeeCategory) {
        this.empoloyeeCategory = empoloyeeCategory;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
