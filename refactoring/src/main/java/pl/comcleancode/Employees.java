package pl.comcleancode;

public class Employees {

    private String name;

    private String salary;
    private Sex sex;

    public enum Sex {
        M, K;
    }

    Employees(String name, String salary, Sex sex) {
        this.name = name;
        this.salary = salary;
        this.sex = sex;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
