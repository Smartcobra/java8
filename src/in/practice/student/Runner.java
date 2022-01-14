package in.practice.student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {
    public static void main(String[] args) {
        Student student1 = new Student(
                "Jayesh",
                20,
                new Address("1234"),
                Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));

        Student student2 = new Student(
                "Khyati",
                20,
                new Address("1235"),
                Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

        Student student3 = new Student(
                "Jason",
                20,
                new Address("1236"),
                Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));

        List<Student> students = Arrays.asList(student1, student2, student3);
        /////////////////////////////////////////////////////////////////////////////////////////
        TempStudent tmpStud1 = new TempStudent(
                "Jayesh1",
                201,
                new Address("12341"),
                Arrays.asList(new MobileNumber("12331"), new MobileNumber("12341")));

        TempStudent tmpStud2 = new TempStudent(
                "Khyati1",
                202,
                new Address("12351"),
                Arrays.asList(new MobileNumber("11111"), new MobileNumber("33331"), new MobileNumber("12331")));
        List<TempStudent> tmpStudents = Arrays.asList(tmpStud1, tmpStud2);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /// -------------Questions----------------//
        //Get student with exact match name "jayesh"
        Optional<Student> jayesh = students.stream().filter(t -> t.getName().equals("Jayesh")).findFirst();
        //System.out.println(jayesh.get().getName());

        ///Get student with matching address "1235"
        Optional<Student> first = students.stream().filter(t -> t.getAddress().getZipcode().equals("1235")).findFirst();
        //System.out.println(first.get().getName());

        ///Get all student having mobile numbers 3333.
        List<String> collect = students.stream().filter(t -> t.getMobileNumbers().stream().anyMatch(m -> m.getNumber().equals("3333")))
                .map(Student::getName).collect(Collectors.toList());
        collect.forEach(System.out::print);

        ///Get all student having mobile number 1233 and 1234
        List<String> collect1 = students.stream().filter(t -> t.getMobileNumbers().stream()
                        .allMatch(m1 -> m1.getNumber().equals("1233") || m1.getNumber().equals("1234")))
                .map(Student::getName)
                .collect(Collectors.toList());
        collect1.forEach(System.out::print);


        /////Create a List<Student> from the List<TempStudent>
        List<Student> studentList = tmpStudents.stream()
                .map(tempStudent -> new Student(tempStudent.name, tempStudent.age, tempStudent.address, tempStudent.mobileNumbers))
                .collect(Collectors.toList());

        //Conditionally apply Filter condition, say if flag is enabled then.
        boolean startsWithJ = true;
        Stream<Student> sorted = null;
        Stream<Student> nameStartsWithJ = students.stream().filter(student -> student.getName().startsWith("j"));

        if (startsWithJ) {
            sorted = nameStartsWithJ.sorted(Comparator.comparing(Student::getName));
        }
        sorted.forEach(System.out::print);
    }
}
