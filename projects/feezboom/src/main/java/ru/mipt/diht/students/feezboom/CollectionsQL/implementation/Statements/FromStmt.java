package ru.mipt.diht.students.feezboom.CollectionsQL.implementation.Statements;

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
        // Here FROM is required
        // Here we return FromStmt initialized with input collection
        // T - type of elements in collection
        return new FromStmt<>(iterable);
    }

    @SafeVarargs
    public final <R> SelectStmt<T, R> select(Class<R> classToReturn, Function<T, ?>... functions) {
        // Here SELECT is required
        // We return select statement
        // Which was calculated with input parameters
        // Class<R> some result class, which we want to get after execution
        // In our task it is class, named Statistics
        // Function <T, ?>... means varargs list of functions
        // It will be converted to Functions<T, ?>[]
        return new SelectStmt<>(elements, classToReturn, false, functions);
    }

    @SafeVarargs
    public final <R> SelectStmt<T, R> selectDistinct(Class<R> classToReturn, Function<T, ?>... functions) {
        // Here SELECT DISTINCT is required
        // All the same, but distinct.
        return new SelectStmt<>(elements, classToReturn, true, functions);
    }
}

//знак вопроса
//В определении шаблона или при генерации можно использовать знак вопроса.
//        ? - указывает на любой класс. классы, но сама специфика класса для них не важна;
//        ? extends T - определяет множество классов потомков от T;
//        ? super T - определяет множество родительских классов класса T.
