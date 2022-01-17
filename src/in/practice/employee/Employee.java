package in.practice.employee;

public class Employee {

    private int id;
    private String name;
    private String status;
    private double salary;
    private String job;

    public Employee(int id, String name, String status, double salary, String job) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.salary = salary;
        this.job = job;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Employee2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", salary=" + salary +
                ", job='" + job + '\'' +
                '}';
    }
}
