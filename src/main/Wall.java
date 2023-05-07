package main;

public class Wall extends Unit{
    private String color = "#B3B3B3";
    public String getColor(){
        return color;
    }
    public boolean canBrake(){
        return false;
    }
}
