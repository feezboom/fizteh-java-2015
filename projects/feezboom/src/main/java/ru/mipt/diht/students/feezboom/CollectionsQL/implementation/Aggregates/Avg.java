package ru.mipt.diht.students.feezboom.CollectionsQL.implementation.Aggregates;

import java.util.List;
import java.util.function.Function;

/**
 * * Created by avk on 05.12.15.
 **/
@SuppressWarnings("checkstyle:designforextension")
public class Avg<T> implements Aggregator<T, Double> {
    private Function<T, Double> ourFunction;

    @Override
    public Double apply(List<T> elements) {
        double avg = 0;
        int numberOfElements = 0;
        for (T element : elements) {
            numberOfElements++;
            avg += ourFunction.apply(element);
        }
        return avg / numberOfElements;
    }

    @Override
    public Double apply(T t) {
        return null;
    }
}
