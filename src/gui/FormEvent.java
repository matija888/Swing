package gui;

import java.util.EventObject;

public class FormEvent extends EventObject {
    private String name;
    private String occupation;
    private int ageCategory;
    private String empoloyeeCategory;
    private String gender;
    private boolean usCitizen;

    public boolean isUsCitizen() {
        return usCitizen;
    }

    public void setUsCitizen(boolean usCitizen) {
        this.usCitizen = usCitizen;
    }

    public String getGender() {
        return gender;
    }

    public String getEmpoloyeeCategory() {
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

    public FormEvent(Object source, String name, String occupation, int ageCat, String empoloyeeCat, String gender, boolean checkCitizenship) {
        super(source);

        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCat;
        this.empoloyeeCategory = empoloyeeCat;
        this.gender = gender;
        this.usCitizen = checkCitizenship;
    }
}
