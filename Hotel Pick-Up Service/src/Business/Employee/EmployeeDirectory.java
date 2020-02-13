/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.ArrayList;

/**
 *
 * @author quanhaonan
 */
public class EmployeeDirectory {
    
    private ArrayList<Employee> employeeList;

    public EmployeeDirectory() {
        employeeList = new ArrayList();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    
    public boolean isEmployeeExist(Employee emp) {
        if (!this.employeeList.isEmpty()) {
            for (Employee em : this.employeeList) {
                if (em.getId() == emp.getId()) {
                    return true;
                }
            }
        }
        return false;
    }
        
    public Employee createEmployee(String firstname,String lastname, String phonenumber, String email, String gender){
        Employee employee = new Employee(firstname,lastname,phonenumber,email,gender);
        employeeList.add(employee);
        return employee;
    }
}