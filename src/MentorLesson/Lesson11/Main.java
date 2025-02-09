package MentorLesson.Lesson11;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;


public class Main {

    static final String INSERT_DEPARTMENT = "insert into department(id, department_name) values(?, ?)";
    static final String INSERT_EMPLOYEE = "insert into employee(id, name, salary, department_id) values(?, ?, ?,?)";
    static final String SELECT_EMPLOYEEID = "select * from employee where department_id = ?";
    static final String UPDATE_EMPLOYEESALARY = "update employee set salary=? where id=?";
    static final String DELETE_EMPLOYEE = "delete from employee where id=?";
    static final String ALL_DEPARTMENT = "select * from department";
    static final String ALL_EMPLOYEE = "select * from employee";
    static final String COUNT_DEPARTMENT =
            "select d.department_name,count(e.id)  \n" +
                    "from employee e inner join department d on e.department_id = d.id \n" +
                    "group by d.department_name order by count(e.id)";
    static final String SALARY_BYDEPARTMENT = "select d.department_name,sum(e.salary) from employee e " +
            "inner join department d on e.department_id = d.id " +
            "group by d.department_name order by sum(e.salary);";


    public static void main(String[] args) {
        //   System.out.println(getEmployees());
        //   System.out.println(getDepartment());
        //  insertDepartment(new Department(5,"Audit"));
        //   getEmployeesByDepartmentId(2);
        //    updateEmployeeSalaryById(37, 500);
        //    deleteEmployeeById(37);
       //    groupEmployeesByDpName();
        //    countEmployeesInEachDepartment();
        //    calculateTotalSalaryByDepartment();
        dynamicFilter("name", "Bob");

    }

    public static List<Employee> getEmployees() {
        List<Employee> e = new ArrayList<>();
        try (Connection con = DbUtil.getConnection(); Statement stmt = con.createStatement()) {
            String query = "select * from employee limit 5";
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                e.add(new Employee(result.getInt("id"),
                        result.getString("name"),
                        result.getInt("salary"),
                        result.getInt("department_id")));
            }
            result.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return e;
    }

    public static List<Department> getDepartment() {
        List<Department> departments = new ArrayList<>();
        try (Connection con = DbUtil.getConnection(); Statement stmt = con.createStatement()) {
            String query = "select * from department limit 3";
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                departments.add(new Department(result.getInt("id"), result.getString("department_name")));
            }
            result.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return departments;
    }

    public static void insertDepartment(Department department) {
        try (Connection con = DbUtil.getConnection(); PreparedStatement s = con.prepareStatement(INSERT_DEPARTMENT)) {
            s.setInt(1, department.getId());
            s.setString(2, department.getDepartment_name());
            s.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void insertEmployee(Employee employee) {
        try (Connection con = DbUtil.getConnection(); PreparedStatement s = con.prepareStatement(INSERT_EMPLOYEE)) {
            s.setString(1, String.valueOf(employee.getId()));
            s.setString(2, employee.getName());
            s.setString(3, String.valueOf(employee.getSalary()));
            s.setString(4, String.valueOf(employee.getDepartment_id()));
            s.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void getEmployeesByDepartmentId(int department_id) {


        try (Connection con = DbUtil.getConnection(); PreparedStatement s = con.prepareStatement(SELECT_EMPLOYEEID)) {
            s.setInt(1, department_id);
            ResultSet result = s.executeQuery();
            while (result.next()) {
                System.out.print("Id: " + result.getInt("id"));
                System.out.print(", Name: " + result.getString("name"));
                System.out.println(", Salary: " + result.getInt("salary"));
                System.out.print(", Department_id: " + department_id);
            }
            result.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public static void updateEmployeeSalaryById(int id, int salary) {
        try (Connection con = DbUtil.getConnection(); PreparedStatement s = con.prepareStatement(UPDATE_EMPLOYEESALARY)) {
            s.setInt(1, salary);
            s.setInt(2, id);
            s.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteEmployeeById(int id) {
        try (Connection con = DbUtil.getConnection(); PreparedStatement s = con.prepareStatement(DELETE_EMPLOYEE)) {
            s.setInt(1, id);
            s.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void groupEmployeesByDpName() {
        Map<Integer, String> mapOfDepartment = new LinkedHashMap<>();
        Map<String, List<Employee>> mapOfEmployee = new LinkedHashMap<>();

        try (Connection con = DbUtil.getConnection()) {


            try (PreparedStatement s1 = con.prepareStatement(ALL_DEPARTMENT)) {

                ResultSet result1 = s1.executeQuery();
                while (result1.next()) {
                    mapOfDepartment.put(result1.getInt("id"), result1.getString("department_name"));
                }

                try (PreparedStatement s = con.prepareStatement(ALL_EMPLOYEE)) {

                    ResultSet result = s.executeQuery();
                    while (result.next()) {
                        String departmentName = mapOfDepartment.get(result.getInt("department_id"));
                        int employeeId = result.getInt("id");
                        String employeeName = result.getString("name");
                        int salary = result.getInt("salary");
                        int departmentId = result.getInt("department_id");

                        mapOfEmployee.computeIfAbsent(departmentName, k -> new ArrayList<>()).add(new Employee(employeeId,
                                employeeName,
                                salary,
                                departmentId));


                    }
                }

                mapOfEmployee.forEach((departmentName, employees) -> {
                    System.out.println(departmentName + " : " + employees);
                    System.out.println("------------------------------------");
                });

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public static void countEmployeesInEachDepartment() {
        Map<String, Integer> countEmployeeOfDepartment = new HashMap<>();

        try (Connection con = DbUtil.getConnection()) {

            PreparedStatement s = con.prepareStatement(COUNT_DEPARTMENT);
            ResultSet resultSet = s.executeQuery();
            while (resultSet.next()) {
                String departmentName = resultSet.getString("department_name");
                int employeeCount = resultSet.getInt("count(e.id)");
                countEmployeeOfDepartment.put(departmentName, employeeCount);
            }

            countEmployeeOfDepartment.forEach((departmentName, count) -> {
                System.out.println(departmentName + " : " + count);
                System.out.println("------------------------------------");
            });


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static void calculateTotalSalaryByDepartment() {
        Map<String, Integer> countEmployeeOfDepartment = new HashMap<>();

        try (Connection con = DbUtil.getConnection();
             PreparedStatement s = con.prepareStatement(SALARY_BYDEPARTMENT);) {


            ResultSet resultSet = s.executeQuery();
            while (resultSet.next()) {
                String departmentName = resultSet.getString("department_name");
                int employeeSalary = resultSet.getInt("sum(e.salary)");
                countEmployeeOfDepartment.put(departmentName, employeeSalary);
            }

            countEmployeeOfDepartment.forEach((departmentName, salary) -> {
                System.out.println(departmentName + " : " + salary);
                System.out.println("------------------------------------");
            });


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static <T> void dynamicFilter(String key, T value) {

        String DYNAMICFILTER = "select * from employee where " + key + " = ?";

        Map<String, List<Employee>> dynamicFilterList = new HashMap<>();

        try (Connection con = DbUtil.getConnection();
             PreparedStatement s = con.prepareStatement(DYNAMICFILTER)) {
            s.setObject(1, value);


            ResultSet result = s.executeQuery();
            while (result.next()) {
                System.out.print("Our key " + key);
                System.out.print(", Our value " + result.getObject(key) + "\n");
                System.out.println("---------------------------------");
                System.out.print(", Id: " + result.getInt("id"));
                System.out.print(", Name: " + result.getString("name"));
                System.out.println(", Salary: " + result.getInt("salary") + "\n");

            }
            result.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}





