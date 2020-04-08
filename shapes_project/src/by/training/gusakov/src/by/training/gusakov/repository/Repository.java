package by.training.gusakov.repository;

import by.training.gusakov.entity.Pyramid;

public interface Repository {

    void add(Pyramid pyramid);

    void remove(Pyramid pyramid);

    void update(Pyramid pyramid);

}
