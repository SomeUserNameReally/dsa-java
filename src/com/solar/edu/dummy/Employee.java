package com.solar.edu.dummy;

import java.util.HashSet;
import java.util.Set;

public class Employee {
    private static Set<Integer> allEmployees;

    private String firstName;
    private String lastName;
    private int age;
    private int id;

    public Employee(String firstName, String lastName, int age, int id) {
        if (Employee.allEmployees == null) {
            Employee.allEmployees = new HashSet<>();
        }

        if (Employee.allEmployees.contains(id)) {
            throw new IllegalArgumentException("Cannot instantiate distinct employees with matching id");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.id = id;
        Employee.allEmployees.add(id);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee: " + this.firstName + " " + this.lastName + ", age: " + this.age + " (id: " + this.id + ")";
    }

    @Override
    public int hashCode() {
        int hash = this.firstName.hashCode();

        hash = 31 * hash + this.lastName.hashCode();
        hash = 67 * hash * this.age;
        hash = 137 * hash + this.id;

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }

        Employee e = (Employee) obj;
        return this.id == e.id;
    }
}
