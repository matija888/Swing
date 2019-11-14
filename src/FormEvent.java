import java.util.EventObject;

public class FormEvent extends EventObject {
    private String name;
    private String occupation;
    private int ageCategory;
    private int empoloyeeCategory;
    private String gender;

    public String getGender() {
        return gender;
    }

    public int getEmpoloyeeCategory() {
        return empoloyeeCategory;
    }

    public int getAgeCategory() {
        return ageCategory;
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

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source, String name, String occupation, int ageCat, int empoloyeeCat, String gender) {
        super(source);

        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCat;
        this.empoloyeeCategory = empoloyeeCat;
        this.gender = gender;
    }
}
