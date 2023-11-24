package com.example.hackathon2.Data;

public class Window {
    private int id;
    private String numArduino;
    private String name;
    private double temperature;
    private double vlazhnost;
    private double gaz;
    private boolean windowsAreOpened;
    private boolean windowsAreBlocked;
    private int idDevice;
    private int user;

    // Конструктор класса
    public Window(int id, String numArduino, String name, double temperature, double vlazhnost,
                  double gaz, boolean windowsAreOpened, boolean windowsAreBlocked,
                  int idDevice, int user) {
        this.id = id;
        this.numArduino = numArduino;
        this.name = name;
        this.temperature = temperature;
        this.vlazhnost = vlazhnost;
        this.gaz = gaz;
        this.windowsAreOpened = windowsAreOpened;
        this.windowsAreBlocked = windowsAreBlocked;
        this.idDevice = idDevice;
        this.user = user;
    }

    // Геттеры и сеттеры для полей класса

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumArduino() {
        return numArduino;
    }

    public void setNumArduino(String numArduino) {
        this.numArduino = numArduino;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getVlazhnost() {
        return vlazhnost;
    }

    public void setVlazhnost(double vlazhnost) {
        this.vlazhnost = vlazhnost;
    }

    public double getGaz() {
        return gaz;
    }

    public void setGaz(double gaz) {
        this.gaz = gaz;
    }

    public boolean isWindowsAreOpened() {
        return windowsAreOpened;
    }

    public void setWindowsAreOpened(boolean windowsAreOpened) {
        this.windowsAreOpened = windowsAreOpened;
    }

    public boolean isWindowsAreBlocked() {
        return windowsAreBlocked;
    }

    public void setWindowsAreBlocked(boolean windowsAreBlocked) {
        this.windowsAreBlocked = windowsAreBlocked;
    }

    public int getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(int idDevice) {
        this.idDevice = idDevice;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public Window() {

    }
}

