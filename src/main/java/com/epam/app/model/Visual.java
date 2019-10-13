package com.epam.app.model;

public class Visual {
    private String color;
    private double transparency;
    private int engraving;

    public Visual() {
    }

    public Visual(String color, double transparency, int engraving) {
        this.color = color;
        this.transparency = transparency;
        this.engraving = engraving;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getTransparency() {
        return transparency;
    }

    public void setTransparency(double transparency) {
        this.transparency = transparency;
    }

    public int getEngraving() {
        return engraving;
    }

    public void setEngraving(int engraving) {
        this.engraving = engraving;
    }

    @Override
    public String toString() {
        return "Visual{" +
                "color='" + color + '\'' +
                ", transparency=" + transparency +
                ", engraving=" + engraving +
                '}';
    }
}
