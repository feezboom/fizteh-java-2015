package ru.mipt.diht.students.feezboom.CollectionsQL.implementation.Aggregates;

import java.util.List;
import java.util.function.Function;

/**
 * * Created by avk on 05.12.15.
 **/
@SuppressWarnings("checkstyle:designforextension")
public class Max<T, R extends Comparable<R>> implements Aggregator<T, R> {
    private Function<T, R> ourFunction;

    public Max(Function<T, R> expression) {
        ourFunction = expression;
    }

    @Override
    public R apply(List<T> elements) {
        T max = elements.get(0);
        for (T t : elements) {
            if (ourFunction.apply(t).compareTo(ourFunction.apply(max)) > 0) {
                max = t;
            }
        }
        return ourFunction.apply(max);
    }

    @Override
    public R apply(T t) {
        return null;
    }
}
