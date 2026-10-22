
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

import java.util.ArrayList;
import java.util.Objects;

public class CharacterManager {
    private final ArrayList<Character> characters = new ArrayList<>();

    // Menambahkan karakter jika nama belum terdaftar.
    public boolean addCharacter(Character character) {
        if (character == null) {
            return false;
        }

        if (findByName(character.getName()) != null) {
            return false;
        }

        characters.add(character);
        return true;
    }

    // Mencari karakter berdasarkan nama.
    public Character findByName(String name) {
        for (Character character : characters) {
            if (Objects.equals(character.getName(), name)) {
                return character;
            }
        }
        return null;
    }

    // Menghapus karakter berdasarkan nama.
    public boolean removeCharacter(String name) {
        Character character = findByName(name);

        if (character == null) {
            return false;
        }

        characters.remove(character);
        return true;
    }

    // Menghitung karakter yang tersimpan.
    public int getTotalCharacters() {
        return characters.size();
    }

    // Mengembalikan salinan list, bukan list internal.
    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characters);
    }

    // Menghitung rata-rata level karakter.
    public double getAverageLevel() {
        if (characters.isEmpty()) {
            return 0.0;
        }

        int totalLevel = 0;

        for (Character character : characters) {
            totalLevel += character.getLevel();
        }

        return (double) totalLevel / characters.size();
    }

    // Mencari semua karakter berdasarkan tipe.
    public ArrayList<Character> findByType(CharacterType type) {
        ArrayList<Character> result = new ArrayList<>();

        for (Character character : characters) {
            if (character.getType() == type) {
                result.add(character);
            }
        }

        return result;
    }

    /**
     * Mencari karakter dengan attack tertinggi.
     * Jika nilainya sama, karakter pertama yang ditemukan dipilih.
     *
     * @return karakter dengan attack tertinggi, atau null jika kosong
     */
    public Character findStrongest() {
        if (characters.isEmpty()) {
            return null;
        }

        Character strongest = characters.get(0);

        for (Character character : characters) {
            if (character.getAttack() > strongest.getAttack()) {
                strongest = character;
            }
        }

        return strongest;
    }
}
