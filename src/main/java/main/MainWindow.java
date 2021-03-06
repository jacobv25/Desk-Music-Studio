package main;

import main.Menus.ChooseInstrumentMenu;
import main.Panels.KeyBoardButtonsPanel;
import main.Panels.KeyboardPanel;
import main.Panels.NoteRecordSheetPanel;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.*;

public class MainWindow extends JFrame {

    KeyboardPanel keyboardPanel;
    KeyBoardButtonsPanel keyBoardButtonsPanel;
    NoteRecordSheetPanel noteRecordSheetPanel;
    ChooseInstrumentMenu chooseInstrumentMenu;

    public MainWindow() throws MidiUnavailableException {

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        chooseInstrumentMenu = new ChooseInstrumentMenu();
        menuBar.add(chooseInstrumentMenu);

        noteRecordSheetPanel = new NoteRecordSheetPanel();
        keyboardPanel = new KeyboardPanel();
        keyBoardButtonsPanel = new KeyBoardButtonsPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(keyboardPanel, SOUTH);
        add(keyBoardButtonsPanel, CENTER);
        add(noteRecordSheetPanel, NORTH);
        keyBoardButtonsPanel.addActionListenersToRecordAndPlayButtons(noteRecordSheetPanel);
        keyboardPanel.setActionListener(noteRecordSheetPanel);
        keyboardPanel.init();
        chooseInstrumentMenu.setItemListeners(keyboardPanel.getKeyboardKeys());
        setVisible(true);
        pack();
    }

    public static void main(String[] args) throws MidiUnavailableException {
        SwingUtilities.invokeLater(
                () -> {
                    try {
                        new MainWindow();
                    } catch (MidiUnavailableException e) {
                        e.printStackTrace();
                    }
                }
        );
    }
}
