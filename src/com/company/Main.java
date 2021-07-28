package com.company;


import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.println("How many employees will be registered? ");
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {

            System.out.println();
            System.out.println("Employee #" + (i + 1) + ": ");
            System.out.print("id: ");
            Integer id = sc.nextInt();
            while (hasId(list, id)){
                System.out.println("Id already taken! Try again: ");
                id = sc.nextInt();
            }

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, salary);

            list.add(emp);

        }
        System.out.println();
        System.out.println("Enter the employee id that will have salary increase: ");
        int idSalary = sc.nextInt();

        //Employee emp = list.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);

        //Integer pos = position(list, idSalary);

        while (!hasSalary(list, idSalary)){
            System.out.println("Id already taken! Try again: ");
            idSalary = sc.nextInt();
        }

        System.out.println("Enter the percentage: ");
        double percentage = sc.nextDouble();
        list.get(idSalary).increaseSalary(percentage);


        System.out.println("List of Employees: ");
        for (Employee e : list) {
            System.out.println(e);
        }

        sc.close();
    }

    public static boolean hasId(List<Employee> list, int id){
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
        }

    public static boolean hasSalary(List<Employee> list, int idSalary) {
        Employee emp = list.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);
        return emp != null;
        }
}
