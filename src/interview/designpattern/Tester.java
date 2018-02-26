package interview.designpattern;

public class Tester {
    public static void main(String[] args) {
//        new Logger(new Tx(new CodingTask())).run();

        Employee employee = new Employee("zhangsan",20000);

        Employee emp1 = Employee.createBuilder().build();
        System.out.println(emp1);
        emp1 = Employee.createBuilder().withName("zzy").withSalary(10000).build();
        System.out.println(emp1);

        emp1 = Employee.createBuilder().form(employee).withSalary(25000).build();
        System.out.println(employee);
        System.out.println(emp1);

    }
}
