package com.example.singleton;

public class SingleTon {
String editValue;
    private static final SingleTon instance=new SingleTon();
    public static  SingleTon getInstance(){
        return instance;
    }
    private SingleTon(){}
    public void setText(String editValue)
    {
        this.editValue=editValue;
    }
    public String getText(){
        return editValue;
    }

}
