package ru.mipt.diht.students.feezboom.CollectionsQL.implementation.Statements;

/**
 ** Created by avk on 15.11.15.
 **/
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SelectStmt<T, R> {

    private List<T> elements;
    private Class<R> classToReturn;
    private boolean isDistinct;
    private Function<T, ?>[] ourFunctions;

    @SafeVarargs
    @SuppressWarnings("checkstyle:hiddenfield")
    public SelectStmt(List<T> ourElements, Class<R> ourClass, boolean isDistinct, Function<T, ?>... functions) {
        //Elements from FromStmt
        this.elements = new ArrayList<>();
        this.elements.addAll(ourElements.stream().collect(Collectors.toList()));
        this.classToReturn = ourClass;
        this.isDistinct = isDistinct;
        this.ourFunctions = functions;
    }

    public final WhereStmt<T, R> where(Predicate<T> predicate) {
        throw new UnsupportedOperationException();
    }

    public final Stream<R> stream() {
        throw new UnsupportedOperationException();
    }

    public class WhereStmt<T, R> {
        @SafeVarargs
        public final WhereStmt<T, R> groupBy(Function<T, ?>... expressions) {
            throw new UnsupportedOperationException();
        }

        @SafeVarargs
        public final WhereStmt<T, R> orderBy(Comparator<T>... comparators) {
            throw new UnsupportedOperationException();
        }

        public final WhereStmt<T, R> having(Predicate<R> condition) {
            throw new UnsupportedOperationException();
        }

        public final WhereStmt<T, R> limit(int amount) {
            throw new UnsupportedOperationException();
        }

        public final UnionStmt union() {
            throw new UnsupportedOperationException();
        }
    }

    public final Iterable<R> execute() {
        //Here we return result of query
        for (T element : elements) {
            //todo
            System.out.println("Hello, Checkstyle!");
        }
        return new ArrayList<>();
    }
}
