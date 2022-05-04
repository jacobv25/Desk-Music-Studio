package main.Menus;

import javax.swing.*;

public class ChooseInstrumentMenu extends JMenu {
    private ButtonGroup buttonGroup;
    private JRadioButtonMenuItem radioButtonMenuItem;
    public ChooseInstrumentMenu(){
        setText("Choose Instrument");
        buttonGroup = new ButtonGroup();
        radioButtonMenuItem = new JRadioButtonMenuItem("Piano");
        radioButtonMenuItem.setSelected(true);
        buttonGroup.add(radioButtonMenuItem);
        add(radioButtonMenuItem);
    }

}