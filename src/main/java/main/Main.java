package main;

import entities.EmployeeEntity;
import entities.OutsourcedEmployeeEntity;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.*;

public class Main {
    public static void main(String[] args) {

        Object[] options = {"Y", "N"};
        List<EmployeeEntity> employeesList = new ArrayList<>();

        int employeeQuantity;

        do {
            employeeQuantity = parseInt(showInputDialog("ENTER THE NUMBER OF EMPLOYEES"));
            if (employeeQuantity < 1) {
                showMessageDialog(
                        null,
                        "NUMBER OF EMPLOYEE INVALID!" +
                                "\nTRY AGAIN!");
            }
        } while (employeeQuantity < 1);

        Object isOutsourced;
        for (int i = 0; i < employeeQuantity; i++) {
            showMessageDialog(null, "EMPLOYEE #" + (i + 1) + " DATA");
            isOutsourced = showInputDialog(
                    null,
                    "EMPLOYEE",
                    "OUTSOURCED?",
                    QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );
            if (isOutsourced.equals("Y")) {
                OutsourcedEmployeeEntity employee = new OutsourcedEmployeeEntity();
                employee.setName(showInputDialog("NAME"));
                employee.setHours(Integer.valueOf(showInputDialog("HOURS")));
                employee.setValuePerHour(Double.valueOf(showInputDialog("VALUE PER HOUR")));
                employee.setAditionalCharge(Double.valueOf(showInputDialog("ADITIONAL CHARGE")));
                employeesList.add(employee);
            } else {
                EmployeeEntity employee = new EmployeeEntity();
                employee.setName(showInputDialog("NAME"));
                employee.setHours(Integer.valueOf(showInputDialog("HOURS")));
                employee.setValuePerHour(Double.valueOf(showInputDialog("VALUE PER HOUR")));
                employeesList.add(employee);
            }
        }

        StringBuilder response = new StringBuilder("PAYMENTS\n");
        employeesList.forEach(employee -> response.append(employee.getName()).append(" - ").append(employee.pay()).append("\n"));

        showMessageDialog(null, response);
    }
}
