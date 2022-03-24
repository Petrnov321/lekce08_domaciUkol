package com.engeto.lekce08_domaciUkol;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //inicializace učitele a žáků
        Osoba tridniUcitel = new Osoba("Samuel", "Jackson");
        Student student1 = new Student("Petr", "Novosad", 1984, 1);
        Student student2 = new Student("Honza", "Horák", 1983, 2);
        Student student3 = new Student("Josef", "Novák", 1985, 122);

        //vytvoření školní třídy a přidání studentů
        SkolniTrida pataC = new SkolniTrida('c', 5, tridniUcitel);
        pataC.pridejStudenta(student1);
        pataC.pridejStudenta(student2);
        pataC.pridejStudenta(student3);

        System.out.println(pataC.toString());//výpis prvního formátu
        System.out.println(pataC.getDescription());// výpis druhého formátu
        System.out.println(pataC.ownDescription());//výpis vlastního formátu

        pataC.saveToFile(pataC.ownDescription());//uložení vlastního formátu do souboru
    }
}
