package com.bridgelabz.serialization;

import java.io.*;
import java.util.*;

// Employee class
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Override toString for displaying employee details
    @Override
    public String toString() {
        return "Employee [ID=" + id + ", Name=" + name + ", Department=" + department + ", Salary=" + salary + "]";
    }
}

public class Serialization {

    // Serialize the list of employees to a file
    public static void serializeEmployees(List<Employee> employees, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(employees);
            System.out.println("Employees have been serialized to " + fileName);
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }
    }

    // Deserialize the list of employees from a file
    public static List<Employee> deserializeEmployees(String fileName) {
        List<Employee> employees = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            employees = (List<Employee>) ois.readObject();
            System.out.println("Employees have been deserialized from " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        }
        return employees;
    }

    public static void main(String[] args) {
        String fileName = "employees.txt";

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "prakul", "HR", 50000));
        employees.add(new Employee(2, "parth", "Finance", 60000));
        employees.add(new Employee(3, "parag", "IT", 70000));

        // Serialize the list of employees
        serializeEmployees(employees, fileName);

        // Deserialize the list of employees
        List<Employee> deserializedEmployees = deserializeEmployees(fileName);

        // Display the deserialized employees
        if (deserializedEmployees != null) {
            for (Employee emp : deserializedEmployees) {
                System.out.println(emp);
            }
        }
    }
}

