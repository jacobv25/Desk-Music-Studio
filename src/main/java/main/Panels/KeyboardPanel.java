package main.Panels;

import main.Buttons.Keys.KeyboardKey;
import main.Factories.KeyboardKeyFactory;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * This handles the building of a keyboard.
 */
public class KeyboardPanel extends JPanel {

    private ActionListener recordSheetPanel;

    private String[] keys = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C6"};
    private KeyboardKey[] keyboardKeys = new KeyboardKey[keys.length];
    public KeyboardPanel() {}

    public void init() throws MidiUnavailableException {
        KeyboardKeyFactory factory = new KeyboardKeyFactory();
        KeyboardKey keyObj;
        String keyStr, color;
        for(int i = 0; i < keys.length; i++){
            keyStr = keys[i];
            if(keyStr.endsWith("#")){
                color = "Black";
            }
            else {
                color = "White";
            }
            keyObj = factory.createKeyboardKey(color, keyStr, recordSheetPanel  );
            keyboardKeys[i] = keyObj;
            add(keyObj);
        }
    }

    public KeyboardKey[] getKeyboardKeys() {
        return keyboardKeys;
    }

    public void setActionListener(ActionListener recordSheetPanel) {
        this.recordSheetPanel = recordSheetPanel;
    }
}
