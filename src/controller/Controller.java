package controller;

import gui.FormEvent;
import model.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Controller {
    Database db = new Database();

    public List<Person> getPeople() {
        return db.getPeople();
    }

    public void addPerson(FormEvent event) {
        String name = event.getName();
        String occupation = event.getOccupation();
        int ageCat = event.getAgeCategory();
        String empCat = event.getEmpoloyeeCategory();
        boolean isUs = event.isUsCitizen();
        String gender = event.getGender();

        AgeCategory ageCategory = null;

        switch (ageCat) {
            case 1:
                ageCategory = AgeCategory.child;
                break;
            case 2:
                ageCategory = AgeCategory.adult;
                break;
            case 3:
                ageCategory = AgeCategory.senior;
                break;
        }

        EmployeeCategory employeeCategory;

        if(empCat.equals("employed")) {
            employeeCategory = EmployeeCategory.employed;
        } else if(empCat.equals("self-employed")) {
            employeeCategory = EmployeeCategory.selfEmployed;
        } else if(empCat.equals("unemployed")) {
            employeeCategory = EmployeeCategory.unemployed;
        } else {
            employeeCategory = EmployeeCategory.other;
        }

        Gender genderCat;
        if(gender.equals("male")) {
            genderCat = Gender.male;
        } else {
            genderCat = Gender.female;
        }

        Person person = new Person(name, occupation, ageCategory, employeeCategory, genderCat);
        db.addPerson(person);
    }

    public void saveToFile(File file) throws IOException {
        db.saveToFile(file);
    }

    public void loadFromFile(File file) throws IOException {
        db.loadFromFile(file);
    }
}
