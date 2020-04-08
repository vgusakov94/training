package by.training.gusakov.repository;

import by.training.gusakov.entity.Pyramid;

import java.util.ArrayList;
import java.util.List;

public class PyramidRepository implements Repository {

    private List<Pyramid> pyramidList;

    public PyramidRepository() {
        pyramidList = new ArrayList<>();
    }

    public List<Pyramid> pyramidList() {
        return pyramidList;
    }

    @Override
    public void add(Pyramid pyramid) {
        pyramidList.add(pyramid);
    }

    @Override
    public void remove(Pyramid pyramid) {
        pyramidList.remove(pyramid);
    }

    @Override
    public void update(Pyramid pyramid) {
        if (!pyramidList.contains(pyramid)) {
            pyramidList.add(pyramid);
        }
    }

}
