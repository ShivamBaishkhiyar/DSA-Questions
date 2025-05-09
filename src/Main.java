import employee.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "Yanksha", 28, 123, "F", "HR", "Blore", 2020));
        empList.add(new Employee(2, "Francesca", 29, 120, "F", "HR", "Hyderabad", 2015));
        empList.add(new Employee(3, "Ramesh", 30, 115, "M", "HR", "Chennai", 2014));
        empList.add(new Employee(4, "Melanie", 32, 125, "F", "HR", "Chennai", 2013));
        empList.add(new Employee(5, "Padma", 22, 150, "F", "IT", "Noida", 2013));
        empList.add(new Employee(6, "Milad", 27, 140, "M", "IT", "Gurugram", 2017));
        empList.add(new Employee(7, "Uzma", 26, 130, "F", "IT", "Pune", 2016));
        empList.add(new Employee(8, "Ali", 23, 145, "M", "IT", "Trivandam", 2015));
        empList.add(new Employee(9, "Ram", 25, 160, "M", "IT", "Blore", 2010));

        // Group the Employees by city.
        Map<String, List<Employee>> empByCity;
        empByCity = empList.stream().collect(Collectors.groupingBy(Employee::getCity));
        System.out.println("Employees grouped by city :: \n" + empByCity);

        // Group the Employees by age.
        Map<Integer, List<Employee>> empByAge = empList.stream().collect(Collectors.
                groupingBy(Employee::getAge));
        System.out.println("Employees grouped by age :: \n" + empByAge);

        // Find the count of male and female employees present in the organization.
        Map<String, Long> noOfMaleAndFemaleEmployees = empList.stream()
                .collect(Collectors.groupingBy
                        (Employee::getGender, Collectors.counting()));
        System.out.println("Count of male and female employees present in the organization:: \n" + noOfMaleAndFemaleEmployees);

        // Print the names of all departments in the organization.
        System.out.println("Names of all departments in the organization ");
        empList.stream().map(Employee::getDeptName).distinct().
                forEach(System.out::println);

        // Print employee details whose age is greater than 28.
        System.out.println("Employee details whose age is greater than 28");
        empList.stream().filter(e -> e.getAge() > 28).collect(Collectors.toList()).
                forEach(System.out::println);

        // Find maximum age of employee.
        OptionalInt max = empList.stream().mapToInt(Employee::getAge).max();
        if (max.isPresent())
            System.out.println("Maximum age of Employee: " + max.getAsInt());

        // Print Average age of Male and Female Employees.
        Map<String, Double> avgAge = empList.stream().collect(Collectors.groupingBy
                (Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println("Average age of Male and Female Employees:: " + avgAge);

        // Print the number of employees in each department.
        Map<String, Long> countByDept = empList.stream().collect(Collectors.groupingBy
                (Employee::getDeptName, Collectors.counting()));
        System.out.println("No of employees in each department");
        for (Map.Entry<String, Long> entry : countByDept.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // Find the oldest employee by age.
        Optional<Employee> oldestEmp = empList.stream().max(Comparator.comparingInt(Employee::getAge));
        Employee oldestEmployee = oldestEmp.get();
        System.out.println("Oldest employee details:: \n" + oldestEmployee);

        // Find the longest serving employees in the organization.
        Optional<Employee> seniorEmp = empList.stream().sorted(Comparator
                .comparingInt(Employee::getYearOfJoining)).findFirst();
        System.out.println("Longest-serving employee:" + seniorEmp.get());

        // Find the longest serving employee in each department
        System.out.println("\n--- Oldest Employee per Department ---");
        empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,
                        Collectors.minBy(Comparator.comparing(Employee::getYearOfJoining))))
                .forEach((dept, empOpt) -> empOpt.ifPresent(emp ->
                        System.out.println(dept + " -> " + emp.getName() + " (DOJ: " + emp.getYearOfJoining() + ")")));


        // Find the youngest employee in the organisation
        System.out.println("\n--- Youngest Employee per Department ---");
        empList.stream().collect(Collectors.
                groupingBy(Employee::getDeptName, Collectors.maxBy(Comparator.comparing(Employee::getYearOfJoining))))
                .forEach((dept, empOpt) -> empOpt.ifPresent(emp ->
                        System.out.println(dept + " -> " + emp.getName() + " (DOJ: " + emp.getYearOfJoining() + ")")));

        //13. Find the youngest female employee.

        Optional<Employee> youngestEmp = empList.stream().filter(e -> e.getGender() == "F")
                .min(Comparator.comparingInt(Employee::getAge));
        Employee youngestEmployee = youngestEmp.get();
        System.out.println("Youngest Female employee details:: \n" + youngestEmployee);
        // 14. Find employees whose age is greater than 30 and less than 30.

        System.out.println("Employees whose age is greater than 25 and less than 25");
        Map<Boolean, List<Employee>> partitionEmployeesByAge =
                empList.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 30));

        Set<Map.Entry<Boolean, List<Employee>>> empSet = partitionEmployeesByAge.entrySet();

        for (Map.Entry<Boolean, List<Employee>> entry : empSet) {
            if (Boolean.TRUE.equals(entry.getKey())) {
                System.out.println("Employees greater than 30 years ::" + entry.getValue());
            } else {
                System.out.println("Employees less than 30 years ::" + entry.getValue());
            }
        }
        // 15. Find the department name which has the highest number of employees.

                Map.Entry<String, Long> maxNoOfEmployeesInDept = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting())).
                entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println("Max no of employees present in Dept :: " + maxNoOfEmployeesInDept.getKey());
        // 16. Find if there any employees from HR Department.

        Optional<Employee> emp = empList.stream().filter(e -> e.getDeptName().equalsIgnoreCase("HR"))
                .findAny();
        emp.ifPresent(employee -> System.out.println("Found employees from HR department " + employee));
       // 17. Find the department names that these employees work for, where the number of employees in the department is over 3.

        System.out.println("Department names where the number of employees in the department is over 3 :: ");
        empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting())).
                entrySet().stream().filter(entry -> entry.getValue() > 3).forEach(System.out::println);
        // 18 . Find distinct department names that employees work for.

        System.out.println("Distinct department names that employees work for:: ");
        empList.stream().map(Employee::getDeptName).distinct().
                forEach(System.out::println);
        // 19. Find all employees who lives in ‘Blore’ city, sort them by their name and print the names of employees.

        empList.stream().filter(e -> e.getCity().equalsIgnoreCase("Blore"))
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(e -> System.out.println("Employees staying in Blore:: " + e.getName()));
        // 20. No of employees in the organisation.

        System.out.println("No of employees in the organisation :: " + empList.stream().count());
        // 21. Find employee count in every department

        Map<String, Long> employeeCountInDepartmentMap = empList.stream().collect(Collectors.
                groupingBy(Employee::getDeptName, Collectors.counting()));
        System.out.print("Employee department and its count :- \n"
                + employeeCountInDepartmentMap);
        // 22. Find the department which has the highest number of employees.

        Optional<Map.Entry<String, Long>> deptNameWithHighestEmp = employeeCountInDepartmentMap.entrySet().stream().max(Map.Entry.comparingByValue());
        if (deptNameWithHighestEmp.isPresent()) {
            System.out.println("Department which has the highest number of employees " + deptNameWithHighestEmp.get());
        }
        // 23. Sorting a Stream by age and name fields.

        System.out.println("Sorting based on name and age:: ");
        Comparator<Employee> comparator1 = Comparator.comparing(Employee::getName);
        Comparator<Employee> comparator2 = Comparator.comparingInt(Employee::getAge);
        empList.stream().sorted(comparator1.thenComparing(comparator2)).forEach(System.out::println);
        // 24. Print average and total salary of the organization.

        DoubleSummaryStatistics empSalary = empList.stream().collect(Collectors
                .summarizingDouble(Employee::getSalary));

        System.out.println("Average Salary in the organisation = " + empSalary.getAverage());
        System.out.println("Total Salary in the organisation  = " + empSalary.getSum());
        // 25. Print Average salary of each department.

        System.out.println("Print Average salary of each department");
        Map<String, Double> avgSalary = empList.stream().collect(Collectors.groupingBy
                (Employee::getDeptName,
                        Collectors.averagingDouble(Employee::getSalary)));
        Set<Map.Entry<String, Double>> entrySet = avgSalary.entrySet();
        for (Map.Entry<String, Double> entry : entrySet) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        // 26. Print Average salary by gender in each department .

        System.out.println("\n--- Average Salary by Gender in Department ---");
        Map<String, Map<String, Double>> avgSalaryByGenderPerDept = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary))));
        avgSalaryByGenderPerDept.forEach((dept, genderAvg) -> genderAvg.forEach((gender, avg) -> System.out.println(dept + " - " + gender + ": ₹" + avg)));

        // 27. To get a list of employees from each department whose salary is greater than the average salary of their department

//        empList.stream()
//                .filter(e -> e.getSalary() > averageMap.get(e.getDeptName()))
//                .collect(Collectors.groupingBy(Employee::getDeptName))
//                .forEach((dept, empListAboveAvg) -> {
//                    System.out.println("Employees in Department who salary greater than average salary: " + dept);
//                    empListAboveAvg.forEach(e -> System.out.println("  " + e.getName() + " – >" + e.getSalary()));
//                });
        // 28. Find Highest salary in the organisation.

        Optional<Employee> empHighest = empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .findFirst();

        System.out.println("Highest Salary in the organisation : " + empHighest.get().getSalary());
        // 29. Find Second-Highest salary in the organisation.

                Optional<Employee> emp2 = empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary)
                .reversed()).skip(1).findFirst();
        System.out.println("Second Highest Salary in the organisation : " + emp2.get().getSalary());
        // 30. Nth Highest salary.

        int n = 10;// this can be any nth number the highest salary
        Optional<Employee> emp4 = empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary)
                .reversed()).skip(n-1).findFirst();
        System.out.println("Second Highest Salary in the organisation : " + emp4.get().getSalary());
        // 31. Print the top 3 highest salary earned employees

        empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).limit(3).forEach(e -> System.out.println("Top earner: " + e.getName() + " – ₹" + e.getSalary()));
        // 32. Find highest paid salary in the organisation based on gender.

        Map<String, Optional<Employee>> highestPaidMFEmployee = empList.stream().collect(Collectors.groupingBy(Employee::getGender,
                Collectors.maxBy((t1, t2) -> (int) (t1.getSalary() - t2.getSalary()))));
        System.out.println("Highest paid male and female employee in the organisation: " + highestPaidMFEmployee);
        // 33. Find lowest paid salary in the organisation

        empList.stream().min(Comparator.comparingDouble(Employee::getSalary)).ifPresent(e -> System.out.println("Lowest paid employee in the organisation: " + e.getName()));
        // 34. Find lowest paid salary in the organisation based on the gender.

                Map<String, Optional<Employee>> lowestPaidMFEmployee = empList.stream().collect(Collectors.groupingBy(Employee::getGender,
                Collectors.minBy((t1, t2) -> (int) (t1.getSalary() - t2.getSalary()))));

        System.out.println("Lowest paid male and female employee : " + lowestPaidMFEmployee);
        // 35. Sort the employees salary in the organisation in ascending order

        System.out.println("Sorting the organisation's employee salary in ascending order ");
        empList.stream().sorted(Comparator.comparingLong(Employee::getSalary)).toList().forEach(System.out::println);
        // 36. Sort the employees salary in the organisation in descending order.

        System.out.println("Sorting the organisation's employee salary in descending order ");
        empList.stream().sorted(Comparator.comparingLong(Employee::getSalary).reversed()).toList().
                forEach(System.out::println);
        // 37. Highest salary based on department.

                System.out.println("Highest salary dept wise:: \n" + empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.collectingAndThen(Collectors.toList(),
                        list -> list.stream().max(Comparator.comparingDouble(Employee::getSalary))))));
        // 38. Lowest paid based on department

//        Map<String, Optional<Employee>> lowestEmployeeInDept = empList.stream().collect(Collectors.groupingBy(Employee::getDepName, Collectors.minBy(Comparator.comparing(Employee::getSalary))));
//        lowestEmployeeInDept.forEach((dept, emp) -> emp.ifPresent(e -> System.out.println("lowest paid dept wise "+dept + " -> " + e.getName() + "::" + e.getSalary())));
        // 39. Print lowest paid employee in the organisation

        empList.stream().min(Comparator.comparingDouble(Employee::getSalary)).ifPresent(e -> System.out.println("Lowest paid employee: " + e.getName()));
        // 40. List of employee’s second highest record based on department

        System.out.println("Highest second salary dept wise:: \n" + empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,
                Collectors.collectingAndThen(Collectors.toList(),
                        list -> list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst()))));
        // 41. Sort the employees salary in each department in ascending order

        System.out.println("Sorting the department wise employee salary in ascending order:: ");
        Map<String, Stream<Employee>> sortedEmployeeAsc = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,
                Collectors.collectingAndThen(Collectors.toList(),
                        list -> list.stream().sorted(Comparator.comparingDouble(Employee::getSalary)))));

        sortedEmployeeAsc.forEach((k,v)->{
            System.out.println(k);
            System.out.println(v.collect(Collectors.toList()));
        });
        // 42. Sort the employees salary in each department in descending order

        System.out.println("Sorting the department wise employee salary in descending order ");
        Map<String, Stream<Employee>> sortedEmployeeDesc = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,
                Collectors.collectingAndThen(Collectors.toList(),
                        list -> list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()))));

        sortedEmployeeDesc.forEach((k,v)->{
            System.out.println(k);
            System.out.println(v.collect(Collectors.toList()));
        });
        // 43. Print the no of Male and Female in each department

        System.out.println("\n--- No of Male and Female in the department ---");
        Map<String, Map<String, Long>> genderMapByDept = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.groupingBy(Employee::getGender, Collectors.counting())));
        genderMapByDept.forEach((dept, genderCnt) -> System.out.println(dept + " -> " + genderCnt));
        // 44. Find list of employees whose age is less than 30 in Department HR

        empList.stream().filter(e -> e.getAge() < 30 && e.getDeptName().equalsIgnoreCase("HR")).map(Employee::getName).forEach(name -> System.out.println("Young in Dev: " + name));
        // 45. Find the employees whose name start with J.

        empList.stream().filter(e -> e.getName().toLowerCase().startsWith("j")).map(Employee::getName).forEach(name -> System.out.println("Name starts with J: " + name));
    }
}