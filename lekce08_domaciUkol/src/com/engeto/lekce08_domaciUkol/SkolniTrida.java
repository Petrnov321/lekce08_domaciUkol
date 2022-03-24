package com.engeto.lekce08_domaciUkol;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class SkolniTrida {

    private char jmeno;
    private int rocnik;
    private Osoba tridniUcitel;
    private List<Student> seznamStudentu;


    public SkolniTrida(char jmeno, int rocnik, Osoba tridniUcitel) {
        this.jmeno = Character.toUpperCase(jmeno);//v případě zadání malého písmena se změní na velké
        this.rocnik = rocnik;
        this.tridniUcitel = tridniUcitel;
        seznamStudentu = new ArrayList<>();
    }

    public char getJmeno() {
        return jmeno;
    }

    public void setJmeno(char jmeno) {
        this.jmeno = jmeno;
    }

    public int getRocnik() {
        return rocnik;
    }

    public void setRocnik(int rocnik) {
        this.rocnik = rocnik;
    }

    public Osoba getTridniUcitel() {
        return tridniUcitel;
    }

    public void setTridniUcitel(Osoba tridniUcitel) {
        this.tridniUcitel = tridniUcitel;
    }

    public List<Student> getSeznamStudentu() {
        return seznamStudentu;
    }

    public void setSeznamStudentu(List<Student> seznamStudentu) {
        this.seznamStudentu = seznamStudentu;
    }

    public void pridejStudenta(Student student){
        seznamStudentu.add(student);
    }



    @Override
    public String toString() {
        String studenti = "";
        int i = 1;
        for (Student student: seznamStudentu) {
            studenti += "# " + i++ + " # " + String.format("ID%03d", student.getId()) + " - " + student.getJmeno() + " " + student.getPrijmeni()  + " (" + student.getRokNarozeni() + ")\n";
        }
        String hlavicka = "####################################\n" +
                "Třída: " + rocnik + "." + jmeno + "(ročník: " + rocnik + ")\n" +
                "Třídní učitel: " + tridniUcitel.getPrijmeni() + ", " + tridniUcitel.getJmeno() + "\n" +
                "Počet studentů: " + seznamStudentu.size() + "\n";

        return  hlavicka + "\n" +
                "####################################\n" +
                studenti;
    }

    public String getDescription(){
        String studenti = "";
        for (Student student: seznamStudentu) {
            studenti += String.format("ID%03d", student.getId()) + ", " + student.getJmeno() + " " + student.getPrijmeni()  + "\n";
        }
        return rocnik + "." + jmeno + ", " + tridniUcitel.getJmeno() + " " + tridniUcitel.getPrijmeni() + "\n" +
                studenti;
    }

    public String ownDescription(){
        String hlavicka = "============================================================\n" +
                "Třída: " + rocnik + "." + jmeno + "\n" +
                "Třídní učitel: " + tridniUcitel.getJmeno() + " " + tridniUcitel.getPrijmeni() + "\n" +
                "============================================================\n";
        String studenti = "";
        int i = 1;
        for (Student student: seznamStudentu) {
            studenti += "|" + i++ + "| " + String.format("ID%03d", student.getId()) + " - " + student.getJmeno() + " " + student.getPrijmeni()  + " - Rok norození: " + student.getRokNarozeni() + "\n";
        }
        return hlavicka + "\n" +
                "Seznam studentů\n" +
                "-------------------------------------------------------\n" +
                studenti +
                "============================================================\n" +
                "Celkový počet žáku: " + seznamStudentu.size();
    }

    public void saveToFile(String output){
        String fileName = "Trida - " + rocnik + "." + jmeno + ".txt";
        try(PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
                writer.println(output);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
