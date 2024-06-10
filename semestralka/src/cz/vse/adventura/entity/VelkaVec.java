package cz.vse.adventura.entity;

//Tato VelkáVěc je označení pro třídu, jenž představuje ve hře věc, která nelze dát do batohu či s hýbat v prostoru.
// (nábytek, velký věci atd.)

//Dědičnost tříd.
//V rámci 5.DÚ
public class VelkaVec extends Vec{

    public VelkaVec(String nazev, String popis) {
        super(nazev, popis);
        this.isMoveable = false;
    }

    @Override
    public String getNazev() {
        return super.getNazev();
    }

}
