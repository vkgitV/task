package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

public class Person extends AppCompatActivity {

    private String name;
    private String Empid;
    private GENDER gender;
    private String nationality;

    public Person(){
        super();
    }

    public Person(String name,String Empid, GENDER gender, String nationality){
        this.name=name;
        this.Empid=Empid;
        this.gender=gender;
        this.nationality=nationality;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public GENDER getGender()
    {
        return gender;
    }
    public void setGender(GENDER gender)
    {
        this.gender = gender;
    }
    public String getNationality()
    {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    enum GENDER{MALE, FEMALE};
}