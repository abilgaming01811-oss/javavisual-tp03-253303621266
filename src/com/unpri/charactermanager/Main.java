
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        CharacterManager manager = new CharacterManager();

        // Menambahkan lima karakter.
        manager.addCharacter(
            new Character("Aragorn", CharacterType.WARRIOR, 5)
        );

        manager.addCharacter(
            new Character("Gandalf", CharacterType.MAGE, 10)
        );

        manager.addCharacter(
            new Character("Legolas", CharacterType.ARCHER, 8)
        );

        manager.addCharacter(
            new Character("Boromir", CharacterType.WARRIOR, 6)
        );

        manager.addCharacter(
            new Character("Frodo", CharacterType.ARCHER, 4)
        );

        // Membuat GUI pada Event Dispatch Thread.
        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow(manager);
            window.setVisible(true);
        });
    }
}
