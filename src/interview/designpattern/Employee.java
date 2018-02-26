package interview.designpattern;


public class Employee {
    private final int salary;

    private final String name;

    public Employee(String name, int salary) {
        this.salary = salary;
        this.name = name;
    }

    public static Builder createBuilder() {
        return Builder.getBuilder();
    }

    public static class Builder {

        private Employee employee;

        private static final Builder builder = new Builder();

        private Builder() {
        }

        public  Builder form(Employee employee) {
            builder.setEmployee(employee);
            return builder;
        }

        public  Builder withSalary(int salary) {
            Employee employee = builder.getEmployee();
            if (employee == null) {
                employee = new Employee(null,salary);
            } else {
                employee = new Employee(employee.getName(),salary);
            }
            builder.setEmployee(employee);
            return builder;
        }

        public  Builder withName(String name) {
            Employee employee = builder.getEmployee();
            if (employee == null) {
                employee = new Employee(name,0);
            } else {
                employee = new Employee(name,employee.getSalary());
            }
            builder.setEmployee(employee);
            return builder;
        }

        public Employee build() {
            return builder.getEmployee();
        }


        public Employee getEmployee() {
            return employee;
        }

        public void setEmployee(Employee employee) {
            this.employee = employee;
        }

        public static Builder getBuilder() {
            return builder;
        }
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", name='" + name + '\'' +
                '}';
    }
}
