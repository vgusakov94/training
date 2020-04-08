package by.training.gusakov.observer;

import by.training.gusakov.entity.Pyramid;

import java.util.EventObject;

public class PyramidEvent extends EventObject {

    public PyramidEvent(Object source) {
        super(source);
    }

    @Override
    public Pyramid getSource() {
        return (Pyramid) super.getSource();
    }
}
