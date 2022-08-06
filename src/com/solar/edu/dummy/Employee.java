package com.solar.edu.dummy;

public class Employee {
    private String firstName;
    private String lastName;
    private int age;
    private int id;

    public Employee(String firstName, String lastName, int age, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.id = id;
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
        int result = this.firstName.hashCode();

        result = 31 * result + this.lastName.hashCode();
        result = 67 * result * this.age;
        result = 137 * result + this.id;

        return result;
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
