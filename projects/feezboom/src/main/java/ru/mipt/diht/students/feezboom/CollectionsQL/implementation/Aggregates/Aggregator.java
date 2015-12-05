package ru.mipt.diht.students.feezboom.CollectionsQL.implementation.Aggregates;

import java.util.List;
import java.util.function.Function;

/**
 * * Created by avk on 05.12.15.
 **/
public interface Aggregator<T, R> extends Function<T, R> {
    R apply(List<T> elements);
}
