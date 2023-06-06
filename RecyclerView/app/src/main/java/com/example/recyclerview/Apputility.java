package com.example.recyclerview;

import static com.example.recyclerview.Person.GENDER.FEMALE;
import static com.example.recyclerview.Person.GENDER.MALE;

import android.app.Person;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class AppUtility extends AppCompatActivity {
    private String [] names;
    private String [] Empid;
    private String [] genders;
    private String [] nationalities;

    private Context context;

    private List<Person> people;

    private static AppUtility appUtility;

    private AppUtility(Context context){
        this.context=context;
        names=context.getResources().getStringArray(R.array.names);
        Empid = context.getResources().getStringArray(R.array.Empid);
        genders = context.getResources().getStringArray(R.array.genders);
        nationalities=context.getResources().getStringArray(R.array.nationalities);
        people=new ArrayList<Person>();
        for(int i=0;i<names.length;i++){
            Person person=new Person(names[i],Empid[i],
                    !genders[i].equalsIgnoreCase("male")?FEMALE : MALE,
                    nationalities[i]);

        }
}
    public static AppUtility getAppUtility(Context context){
        if(appUtility == null){
            appUtility=new AppUtility(context);
        }
        return appUtility;
    }

    public List<Person> getPeople() {
        return this.people;
    }
    public String[] getNames(){
        return names;
    }
    public  String[] getGender(){return genders;}
    public  String[] getNationality(){return nationalities;}
    public String[] getEmpid(){return Empid;}
}
