package com.example.myapplication;

import androidx.lifecycle.ViewModel;

public class StateViewModel extends ViewModel{
    int licznik = 0;
    String text1;
    boolean checkb;
    boolean sweety; //fox

    public int getcount(){
        return licznik;}
    public void incrementCount(){
        licznik++;}

    public void checkbOn(){
        checkb = true;}
    public void checkbOff(){
        checkb = false;}
    public boolean getcheckb(){
        return checkb;}

    public void updateEditText(String input){
        text1 = input;}
    public String setEditText(){
        return text1;}
    public void sweetyOn(){
        sweety = true;}
    public void sweetyOff(){
        sweety = false;}
    public boolean getsweety() {
        return sweety;}
}
