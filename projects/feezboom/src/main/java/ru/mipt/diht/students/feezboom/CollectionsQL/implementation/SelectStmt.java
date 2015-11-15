package ru.mipt.diht.students.feezboom.CollectionsQL.implementation;

/**
 * * Created by avk on 15.11.15.
 **/
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class SelectStmt<T, R> {

    @SafeVarargs
    public SelectStmt(Function<T, R>... s) {
        throw new UnsupportedOperationException();
    }

    public final WhereStmt<T, R> where(Predicate<T> predicate) {
        throw new UnsupportedOperationException();
    }

    public final Iterable<R> execute() {
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
}
