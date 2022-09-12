package comprators;

import domain.ComService;

import java.util.Comparator;

public class SortByPrice implements Comparator<ComService> {

    @Override
    public int compare(ComService o1, ComService o2) {
        return Integer.compare(o1.getPrice(), o2.getPrice());
    }
}
