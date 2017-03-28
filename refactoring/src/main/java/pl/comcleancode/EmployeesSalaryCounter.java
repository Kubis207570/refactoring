package pl.comcleancode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.comcleancode.Employees.Sex;

public class EmployeesSalaryCounter {

    public List<Employees> generateEmployeesList() {
        List<Employees> employeesList;
        employeesList = new LinkedList<>();
        employeesList.add(new Employees("Marek", "2301", Sex.M));
        employeesList.add(new Employees("Grazyna", "1703",Sex.K));
        employeesList.add(new Employees("John", "12330", Sex.M));
        employeesList.add(new Employees("Helena", "300", Sex.K));
        return employeesList;
    }

    public Integer getMeanSalary(Sex sex, List<Employees> employeesList) {
        int sum = countSum(employeesList, sex);
        int amount = countAmount(employeesList, sex);

        int mean = sum / amount;
        return mean;
    }

    private int countSum(List<Employees> employeesList, Sex sex) throws NumberFormatException {
        int sum=0;
        for (Employees employee : employeesList) {
            if (employee.getSex().equals(sex) ) {
                sum += Integer.parseInt(employee.getSalary());
            }
        }
        return sum;
    }
    
    private int countAmount(List<Employees> employeesList, Sex sex) throws NumberFormatException {
        int among=0;
        for (Employees employee : employeesList) {
            if (employee.getSex().equals(sex) ) {
                among ++;
            }
        }
        return among;
    }

    public static void main(String[] args) {

        EmployeesSalaryCounter employeesSalaryCounter = new EmployeesSalaryCounter();
        System.out.println("Srednia pensja dla mezczyzn to: ");
        List<Employees> employeesList=employeesSalaryCounter.generateEmployeesList();
        Integer meanForMen = employeesSalaryCounter.getMeanSalary(Sex.M, employeesList);
        System.out.println(meanForMen);
        System.out.println("A dla kobiet to: ");
        Integer meanForWomen = employeesSalaryCounter.getMeanSalary(Sex.K, employeesList);
        System.out.println(meanForWomen);

        writeToFile(meanForMen, meanForWomen);

    }

    private static void writeToFile(Integer meanForMen, Integer meanForWomen) {
        //Zapiszmy do pliku
        File file = new File("something.txt");
        FileWriter fw;
        try {
            fw = new FileWriter(file);

            if (meanForMen > meanForWomen) {
                fw.write(meanForMen.toString());
            } else {
                fw.write(meanForWomen.toString());
            }

            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(EmployeesSalaryCounter.class.getName()).log(Level.SEVERE, "Exception during write file", ex);
        }
    }
}
