
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CharacterManager manager = new CharacterManager();

        // A. Menguji penambahan karakter.
        System.out.println("=== UJI ADD CHARACTER ===");

        Character c1 = new Character("Aragorn", CharacterType.WARRIOR);
        Character c2 = new Character("Gandalf", CharacterType.MAGE, 3);
        Character c3 = new Character("Legolas", CharacterType.ARCHER);
        Character c4 = new Character("Boromir", CharacterType.WARRIOR);

        System.out.println("Aragorn ditambahkan: " + manager.addCharacter(c1));
        System.out.println("Gandalf ditambahkan: " + manager.addCharacter(c2));
        System.out.println("Legolas ditambahkan: " + manager.addCharacter(c3));
        System.out.println("Boromir ditambahkan: " + manager.addCharacter(c4));

        // Nama duplikat harus ditolak.
        Character duplicate = new Character("Aragorn", CharacterType.MAGE);
        System.out.println("Aragorn duplikat ditambahkan: "
                + manager.addCharacter(duplicate));

        // Menguji equals().
        System.out.println("\n=== UJI EQUALS ===");
        System.out.println("Nama Aragorn sama: " + c1.equals(duplicate));

        // Menampilkan seluruh karakter.
        System.out.println("\n=== DAFTAR KARAKTER ===");
        for (Character character : manager.getAllCharacters()) {
            System.out.println(character);
        }

        // Menguji pencarian.
        System.out.println("\n=== UJI FIND BY NAME ===");
        System.out.println("Cari Gandalf: " + manager.findByName("Gandalf"));
        System.out.println("Cari Sauron: " + manager.findByName("Sauron"));

        // Menguji jumlah karakter.
        System.out.println("\n=== JUMLAH KARAKTER ===");
        System.out.println("Total: " + manager.getTotalCharacters());

        // Menguji rata-rata level.
        System.out.println("\n=== RATA-RATA LEVEL ===");
        System.out.println("Rata-rata: " + manager.getAverageLevel());

        // Menguji findByType().
        System.out.println("\n=== KARAKTER TIPE WARRIOR ===");
        for (Character character : manager.findByType(CharacterType.WARRIOR)) {
            System.out.println(character.getName());
        }

        // Menguji fitur baru Bagian C.
        System.out.println("\n=== KARAKTER TERKUAT ===");
        Character strongest = manager.findStrongest();
        System.out.println(strongest == null ? "Belum ada karakter" : strongest);

        // Menguji salinan ArrayList.
        System.out.println("\n=== UJI SALINAN LIST ===");
        ArrayList<Character> copy = manager.getAllCharacters();
        copy.clear();

        System.out.println("Jumlah pada salinan setelah clear: " + copy.size());
        System.out.println("Jumlah pada manager: " + manager.getTotalCharacters());

        // Menguji reference.
        System.out.println("\n=== UJI REFERENCE ===");
        Character a = new Character("ReferenceTest", CharacterType.MAGE);
        Character b = a;
        b.setLevel(8);

        System.out.println("a.getLevel(): " + a.getLevel());
        System.out.println("a == b: " + (a == b));

        // Menguji reference yang independen.
        Character independent = new Character(
                a.getName(), a.getType(), a.getLevel());

        independent.setLevel(2);

        System.out.println("Level a: " + a.getLevel());
        System.out.println("Level independent: " + independent.getLevel());
        System.out.println("a == independent: " + (a == independent));

        // Menguji penghapusan.
        System.out.println("\n=== UJI REMOVE CHARACTER ===");
        System.out.println("Boromir dihapus: " + manager.removeCharacter("Boromir"));
        System.out.println("Boromir dihapus lagi: " + manager.removeCharacter("Boromir"));
        System.out.println("Total setelah penghapusan: "
                + manager.getTotalCharacters());

        // Menguji rata-rata pada list kosong.
        CharacterManager emptyManager = new CharacterManager();
        System.out.println("\n=== UJI LIST KOSONG ===");
        System.out.println("Rata-rata list kosong: "
                + emptyManager.getAverageLevel());
    }
}
