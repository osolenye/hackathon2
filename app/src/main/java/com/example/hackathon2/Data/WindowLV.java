package com.example.hackathon2.Data;

public class WindowLV {
    private String name;
    private String numArduino;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumArduino() {
        return numArduino;
    }

    public void setNumArduino(String numArduino) {
        this.numArduino = numArduino;
    }

    public WindowLV(String name, String numArduino) {
        this.name = name;
        this.numArduino = numArduino;
    }
}
