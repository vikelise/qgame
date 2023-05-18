package main.ui;

import main.Gate;

import javax.swing.*;

public class GateWidget extends JPanel {
    private Gate gate;
    private String GATE_COLOR;
    public GateWidget(Gate g){
        this.gate = g;
        setColor();
    }

    private void setColor(){
        if(gate.getColor() == "red")
            GATE_COLOR = "#F4A2A2";
        if(gate.getColor() == "blue")
            GATE_COLOR = "#8DC2FF";
        if(gate.getColor()=="green")
            GATE_COLOR = "#9CE073";
    }

    public String getColor(){return GATE_COLOR;}


}
