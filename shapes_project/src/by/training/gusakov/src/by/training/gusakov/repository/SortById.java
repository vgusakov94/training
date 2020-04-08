package by.training.gusakov.repository;

import by.training.gusakov.entity.Pyramid;
import by.training.gusakov.repository.comparator.PyramidComparator;

public class SortById implements PyramidComparator {

    @Override
    public int compare(Pyramid pr1, Pyramid pr2) {

        return pr1.getPointID().compareTo(pr2.getPointID());
    }

}
