package ru.mipt.diht.students.feezboom.CollectionsQL.implementation.Aggregates;

import java.util.List;
import java.util.function.Function;

/**
 * * Created by avk on 05.12.15.
 **/
@SuppressWarnings("checkstyle:designforextension")
public class Min<T, R extends Comparable<R>> implements Aggregator<T, R> {
    private Function<T, R> ourFunction;

    public Min(Function<T, R> expression) {
        ourFunction = expression;
    }

    @Override
    public R apply(T t) {
        return null;
    }

    @Override
    public R apply(List<T> elements) {
        T min = elements.get(0);
        for (T element : elements) {
            if (ourFunction.apply(min).compareTo(ourFunction.apply(element)) > 0) {
                min = element;
            }
        }
        return ourFunction.apply(min);
    }
}
