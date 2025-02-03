package com.exercici0400;

import java.util.ArrayList;

abstract public class Component implements Renderable {

    protected int x;
    protected int y;
    protected int width;
    protected int height;

    public Component(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    abstract public ArrayList<String> render();
}
