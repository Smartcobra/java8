package in.practice.employee;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Client {
    public static void main(String[] args) {
        List<Employee> list= new ArrayList<>();
        list.add(new Employee(101,"siva","active",203.00, "clerk" ));
        list.add(new Employee(102,"amit","inactive",204.90,"manager" ));
        list.add(new Employee(103,"asu","active",205.00,"peon" ));
        list.add(new Employee(104,"satya","active",222.10,"manager" ));
        list.add(new Employee(105,"somu","inactive",252.23,"manager" ));
        list.add(new Employee(106,"hari","active",300.45,"manager"));
        list.add(new Employee(107,"abi","active",233.15,"peon" ));
        list.add(new Employee(108,"asis","active",345.10,"clerk" ));
        list.add(new Employee(109,"minu","inactive",342.90,"peon" ));
        list.add(new Employee(110,"mitu","active",232.00,"clerk"));
        Map<String,List<Employee>> map1=groupByJobTitle_java8(list);
        for(Map.Entry<String,List<Employee>> map:map1.entrySet()){
            System.out.println(map.getKey()+"->"+map.getValue().toString());
        }
        double sal = averageSalary(list);
        System.out.println(sal);
    }
    //group an array of employee records into a data map organized by job title.

    //Traditional way
    public static Map<String,List<Employee>> groupByJobTitle(List<Employee> employee2List){
        Map<String,List<Employee>> resultMap= new HashMap<>();
        List<Employee> subEmpList=null;

        for(Employee emp:employee2List ){
            if(resultMap.containsKey(emp.getJob())){
                subEmpList=resultMap.get(emp.getJob());
            }else{
                subEmpList=new ArrayList<>();
            }
            subEmpList.add(emp);
            resultMap.put(emp.getJob(),subEmpList);

        }

        return resultMap;
    }
    //using getOrDefault()
    public static Map<String,List<Employee>> groupByJobTitle2(List<Employee> employees) {
        Map<String, List<Employee>> resultMap2 = new HashMap<>();
        for (Employee emp : employees) {
            List<Employee> empSubList = resultMap2.getOrDefault(emp.getJob(), new ArrayList<Employee>());
            empSubList.add(emp);
            resultMap2.put(emp.getJob(), empSubList);

        }
        return resultMap2;
    }
    //using java 8 stream
    public static Map<String,List<Employee>> groupByJobTitle_java8(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getJob)) ;
    }

    //average salary
    public static double averageSalary(List<Employee> employees){
        int sum=0;
        int count=0;
        for(Employee emp :employees ){
            sum +=emp.getSalary();
            count++;
        }
        return sum/count;
    }

    //average salary java8
    public static double averageSalary_java8(List<Employee> employees){
        return employees.stream().mapToDouble(t->t.getSalary()).average().getAsDouble();
    }



}
