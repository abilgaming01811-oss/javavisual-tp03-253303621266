
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {
    public static void main(String[] args) {

        // Membuat tiga karakter menggunakan dua constructor.
        Character c1 = new Character(
            "Aragorn", CharacterType.WARRIOR
        );

        Character c2 = new Character(
            "Gandalf", CharacterType.MAGE, 3
        );

        Character c3 = new Character(
            "Legolas", CharacterType.ARCHER
        );

        // Menampilkan tiga karakter.
        System.out.println("=== DAFTAR KARAKTER ===");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        // Demo level up.
        System.out.println("\n=== DEMO LEVEL UP ===");
        c1.setLevel(2);
        System.out.println(c1);

        // Mini-Challenge: mana dan isAlive().
        Character c4 = new Character(
            "Elrond", CharacterType.HEALER
        );

        c4.setMana(50);

        System.out.println("\n=== MINI-CHALLENGE ===");
        System.out.println(c4);
        System.out.println("Mana Elrond: " + c4.getMana());
        System.out.println("Elrond masih hidup: " + c4.isAlive());
    }
}
