package java14;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RecordWith2ndHighestSalaryEmpEx {

    record Employee(String name, String dept, Double salary) {}

    public static void main(String []args) {
        RecordWith2ndHighestSalaryEmpEx re = new RecordWith2ndHighestSalaryEmpEx();
        List<Employee> l = getEmployees();
        re.secondHighSalary(l);
        re.deptWiseHighSalaryEmployee(l);
        re.groupByDeptEmpCountOfSalaryMoreThan(l, 4500.00);
    }

    private static List<Employee> getEmployees() {
        var employee1 = new Employee("emp1", "dept1", 4600.00);
        var employee2 = new Employee("emp2", "dept2", 4300.00);
        var employee3 = new Employee("emp3", "dept1", 4200.00);
        var employee4 = new Employee("emp5", "dept1", 5000.00);
        var employee5 = new Employee("emp6","dept2",  4800.00);
        var employee6 = new Employee("emp4","dept3",  4700.00);
        var employee7 = new Employee("emp7", "dept1", 4300.00);
        var employee8 = new Employee("emp8", "dept2", 4350.00);
        var employee9 = new Employee("emp9", "dept1", 4220.00);
        var employee10 = new Employee("emp10", "dept1", 5030.00);
        var employee11 = new Employee("emp11","dept2",  4850.00);
        var employee12 = new Employee("emp12","dept3",  4750.00);
        List<Employee> l = Arrays.asList(employee1, employee2, employee3, employee4, employee5, employee6,
                employee7, employee8, employee9, employee10, employee11, employee12);
        return l;
    }

    private void groupByDeptEmpCountOfSalaryMoreThan(List<Employee> list, Double salary) {
        Map<String, Long> groupByDeptCount = list.stream()
                .filter(e -> e.salary() > salary)
                .collect(Collectors.groupingBy(Employee::dept,
                        Collectors.counting())
                        );
        System.out.println("group by dept count " + groupByDeptCount);
    }

    private void secondHighSalary(List<Employee> list) {
        String secondHighSalaryEmp = list.stream()
                .sorted(Comparator.comparing(Employee::salary).reversed())
                .skip(1)
                .findFirst()
                .map(Employee::name)
                .orElse(null);
        System.out.println("second high salary emp  " + secondHighSalaryEmp);
    }

    private void deptWiseHighSalaryEmployee(List<Employee> emps) {
        Map<String, Employee> sortedEmps = emps.stream()
                .collect(Collectors.groupingBy(
                        Employee::dept,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Employee::salary)),
                                Optional::get
                        )
                        ));
        System.out.println("sorted employees" + sortedEmps);
    }

}
