package employee2;



import employee.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        List<Employee2> list= new ArrayList<>();
        list.add(new Employee2(101,"siva","active",203.00, "clerk" ));
        list.add(new Employee2(102,"amit","inactive",204.90,"manager" ));
        list.add(new Employee2(103,"asu","active",205.00,"peon" ));
        list.add(new Employee2(104,"satya","active",222.10,"manager" ));
        list.add(new Employee2(105,"somu","inactive",252.23,"manager" ));
        list.add(new Employee2(106,"hari","active",300.45,"manager"));
        list.add(new Employee2(107,"abi","active",233.15,"peon" ));
        list.add(new Employee2(108,"asis","active",345.10,"clerk" ));
        list.add(new Employee2(109,"minu","inactive",342.90,"peon" ));
        list.add(new Employee2(110,"mitu","active",232.00,"clerk"));
        Map<String,List<Employee2>> map1=groupByJobTitle(list);
        for(Map.Entry<String,List<Employee2>> map:map1.entrySet()){
            System.out.println(map.getKey()+"->"+map.getValue().toString());
        }
    }
    //group an array of employee records into a data map organized by job title.

    //Traditional way
    public static Map<String,List<Employee2>> groupByJobTitle( List<Employee2> employee2List){
        Map<String,List<Employee2>> resultMap= new HashMap<>();
        List<Employee2> subEmpList=null;

        for(Employee2 emp:employee2List ){

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
}
