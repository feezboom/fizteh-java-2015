package ru.mipt.diht.students.feezboom.CollectionsQL.implementation.Aggregates;

import java.util.List;
import java.util.function.Function;

/**
 * * Created by avk on 05.12.15.
 **/
@SuppressWarnings("checkstyle:designforextension")
public class Avg<T> implements Aggregator<T, Double> {
    private Function<T, ? extends Number> ourFunction;

    public Avg(Function<T, ? extends Number> expression) {
        ourFunction = expression;
    }

    @Override
    public Double apply(List<T> elements) {
        double avg = 0;
        for (T element : elements) {
            avg = avg + ourFunction.apply(element).doubleValue();
        }
        return avg / elements.size();
    }

    @Override
    public Double apply(T t) {
        return null;
    }
}
