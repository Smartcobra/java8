package employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        List<Employee> list= new ArrayList<>();
        list.add(new Employee(101,"siva","active",203.00,new Department(10,"Mech") ));
        list.add(new Employee(102,"amit","inactive",204.90,new Department(11,"etc") ));
        list.add(new Employee(103,"asu","active",205.00,new Department(12,"csc") ));
        list.add(new Employee(104,"satya","active",222.10,new Department(11,"it") ));
        list.add(new Employee(105,"somu","inactive",252.23,new Department(12,"Mech") ));
        list.add(new Employee(106,"hari","active",300.45,new Department(10,"ele") ));
        list.add(new Employee(107,"abi","active",233.15,new Department(11,"Mech") ));
        list.add(new Employee(108,"asis","active",345.10,new Department(12,"etc") ));
        list.add(new Employee(109,"minu","inactive",342.90,new Department(10,"Mech") ));
        list.add(new Employee(110,"mitu","active",232.00,new Department(10,"etc") ));


        Map<Department, List<Employee>> collect = list.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.toList()));
        List<List<Employee>> collect1 = collect.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
        System.out.print(collect1);
    }
}
