package edu.hw2.Task2;

public class Square extends Rectangle {
    public void setSize(int size) {
        super.setWidth(size);
        super.setHeight(size);
    }

    @Override
    public void setWidth(int width) {
        setSize(width);
    }

    @Override
    public void setHeight(int height) {
        setSize(height);
    }
}
