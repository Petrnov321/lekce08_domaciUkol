package com.engeto.lekce08_domaciUkol;

public class Student extends Osoba {

    private int rokNarozeni;
    private int id;

    public Student(String jmeno, String prijmeni, int rokNarozeni, int id) {
        super(jmeno, prijmeni);
        this.rokNarozeni = rokNarozeni;
        this.id = id;
    }

    public int getRokNarozeni() {
        return rokNarozeni;
    }

    public void setRokNarozeni(int rokNarozeni) {
        this.rokNarozeni = rokNarozeni;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
