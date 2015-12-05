package ru.mipt.diht.students.feezboom.CollectionsQL.implementation.Aggregates;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
/**
 * * Created by avk on 05.12.15.
 **/
@SuppressWarnings("checkstyle:designforextension")
public class Count<T> implements Aggregator<T, Integer> {
    private Function<T, ?> ourFunction;

    public Count(Function<T, ?> expression) {
        ourFunction = expression;
    }

    @Override
    public Integer apply(T t) {
        return null;
    }

    @Override
    public Integer apply(List<T> elements) {
        Set<Object> set =
                elements.stream()
                        .filter(element -> ourFunction.apply(element) != null)
                        .map(ourFunction::apply)
                        .collect(Collectors.toSet());
        return set.size();
    }
}
