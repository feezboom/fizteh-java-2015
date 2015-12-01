package ru.mipt.diht.students.feezboom.CollectionsQL.implementation;

/**
 * * Created by avk on 15.11.15.
 **/
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FromStmt<T> {
    private List<T> elements;

    public FromStmt(Iterable<T> iterable) {
        elements = new ArrayList<>();
        for (T element : iterable) {
            elements.add(element);
        }
    }

    public static <T> FromStmt<T> from(Iterable<T> iterable) {
        return new FromStmt<>(iterable);
    }

    @SafeVarargs
    public final <R> SelectStmt<T, R> select(Class<R> classToReturn, Function<T, ?>... functions) {
        return new SelectStmt<>(elements, classToReturn, false, functions);
    }

    @SafeVarargs
    public final <R> SelectStmt<T, R> selectDistinct(Class<R> classToReturn, Function<T, ?>... functions) {
        return new SelectStmt<>(elements, classToReturn, true, functions);
    }
}
