package ru.mipt.diht.students.feezboom.CollectionsQL;

/**
 * * Created by avk on 15.11.15.
 **/

import ru.mipt.diht.students.feezboom.CollectionsQL.implementation.Aggregates.Avg;
import ru.mipt.diht.students.feezboom.CollectionsQL.implementation.Aggregates.Count;
import ru.mipt.diht.students.feezboom.CollectionsQL.implementation.Aggregates.Max;
import ru.mipt.diht.students.feezboom.CollectionsQL.implementation.Aggregates.Min;

import java.util.function.Function;

/**
 * Aggregate functions.
 */
public class Aggregates {

    public static <T, R extends Comparable<R>> Function<T, R> max(Function<T, R> expression) {
        return new Max<>(expression);
    }

    public static <T, R extends Comparable<R>> Function<T, R> min(Function<T, R> expression) {
        return new Min<>(expression);
    }

    public static <T> Function<T, Integer> count(Function<T, ?> expression) {
        return new Count<>(expression);
    }

    public static <T> Function<T, Double> avg(Function<T, ? extends Number> expression) {
        return new Avg<>(expression);
    }

}
