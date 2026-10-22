
package com.unpri.charactermanager.model;

import java.util.Objects;

public class Character {
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attack;
    private int mana;
    private int id;

    private static int totalCharacterCreated = 0;

    // Constructor pertama: membuat karakter dengan nilai awal.
    public Character(String name, CharacterType type) {
        this.name = name;
        this.type = type;
        this.level = 1;
        this.hitPoints = 100;
        this.attack = 10;
        this.mana = 0;

        totalCharacterCreated++;
        this.id = totalCharacterCreated;
    }

    // Constructor kedua: membuat karakter dengan level tertentu.
    public Character(String name, CharacterType type, int level) {
        this.name = name;
        this.type = type;
        setLevel(level);
        this.mana = 0;

        totalCharacterCreated++;
        this.id = totalCharacterCreated;
    }

    public int getId() {
        return id;
    }

    public static int getTotalCharacterCreated() {
        return totalCharacterCreated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException(
                "Level harus minimal 1."
            );
        }

        this.level = level;
        this.hitPoints = 100 + (level - 1) * 20;
        this.attack = 10 + (level - 1) * 5;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException(
                "Mana tidak boleh negatif."
            );
        }

        this.mana = mana;
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }

    // Dua karakter dianggap sama jika namanya sama.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Character)) {
            return false;
        }

        Character other = (Character) obj;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", level=" + level +
                ", hitPoints=" + hitPoints +
                ", attack=" + attack +
                ", mana=" + mana +
                '}';
    }
}
