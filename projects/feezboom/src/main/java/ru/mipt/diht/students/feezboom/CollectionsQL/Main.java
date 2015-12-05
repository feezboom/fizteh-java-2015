package ru.mipt.diht.students.feezboom.CollectionsQL;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import static ru.mipt.diht.students.feezboom.CollectionsQL.Aggregates.avg;
import static ru.mipt.diht.students.feezboom.CollectionsQL.Aggregates.count;
import static ru.mipt.diht.students.feezboom.CollectionsQL.Main.Student.student;
import static ru.mipt.diht.students.feezboom.CollectionsQL.Conditions.rlike;
import static ru.mipt.diht.students.feezboom.CollectionsQL.OrderByConditions.asc;
import static ru.mipt.diht.students.feezboom.CollectionsQL.OrderByConditions.desc;
import static ru.mipt.diht.students.feezboom.CollectionsQL.Sources.list;
import static ru.mipt.diht.students.feezboom.CollectionsQL.implementation.Statements.FromStmt.from;


public class Main {

@SuppressWarnings("checkstyle:magicnumber")
public static void main(String[] args) {
    Iterable<Statistics>  statistics = new ArrayList<>();

    statistics =
        from(list(
                student("ivanov", LocalDate.parse("1986-08-06"), "494"),
                student("zuev", LocalDate.parse("1986-08-06"), "494")))
                .select(Statistics.class, Student::getGroup, count(Student::getGroup), avg(Student::age))
                .where(rlike(Student::getName, ".*ov").and(s -> s.age() > 20))
                .groupBy(Student::getGroup)
                .having(s -> s.getCount() > 0)
                .orderBy(asc(Student::getGroup), desc(count(Student::getGroup)))
                .limit(100)
                .union()
                .from(list(student("ivanov", LocalDate.parse("1985-08-06"), "494")))
                .selectDistinct(Statistics.class, s -> "all", count(s -> 1), avg(Student::age))
                .execute();

    statistics =
            from(list(student("ivanov", LocalDate.parse("1986-08-06"), "494"),
                    student("ivanov", LocalDate.parse("1986-08-06"), "494")))
                    .select(Statistics.class, Student::getGroup, count(Student::getGroup), avg(Student::age))
                    .execute();

    System.out.println(statistics);
}


    public static class Student {
        private final String name;

        private final LocalDate dateOfBith;

        private final String group;

        public final String getName() {
            return name;
        }

        @SuppressWarnings("checkstyle:hiddenfield")
        public Student(String name, LocalDate dateOfBirth, String group) {
            this.name = name;
            this.dateOfBith = dateOfBirth;
            this.group = group;
        }

        public final LocalDate getDateOfBirth() {
            return dateOfBith;
        }

        public final String getGroup() {
            return group;
        }

        public final long age() {
            return ChronoUnit.YEARS.between(getDateOfBirth(), LocalDateTime.now());
        }

        public static Student student(String name, LocalDate dateOfBirth, String group) {
            return new Student(name, dateOfBirth, group);
        }
    }

    public static class Statistics {

        private final String group;
        private final Long count;
        private final Long age;

        public final String getGroup() {
            return group;
        }

        public final Long getCount() {
            return count;
        }

        public final Long getAge() {
            return age;
        }

        @SuppressWarnings("checkstyle:hiddenfield")
        public Statistics(String group, Long count, Long age) {
            this.group = group;
            this.count = count;
            this.age = age;
        }

        @Override
        public final String toString() {
            return "Statistics{"
                    + "group='" + group + '\''
                    + ", count=" + count
                    + ", age=" + age
                    + '}';
        }
    }
}
