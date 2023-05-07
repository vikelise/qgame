package main.ui;

import main.Gate;

import javax.swing.*;
import java.awt.*;


public class GateWidget extends JPanel {
    Gate gate;
    public GateWidget(Gate gate){
        this.gate = gate;
        if(gate.getColor() == "blue") {
            setBackground(Color.decode("#8DC2FF"));
        }else if(gate.getColor()=="red")
        {
            setBackground(Color.decode("#F4A2A2"));
        }
    }

}
