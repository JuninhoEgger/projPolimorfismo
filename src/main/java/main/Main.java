package main;

import entities.EmployeeEntity;
import entities.OutsourcedEmployeeEntity;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;
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

            String name = showInputDialog("NAME");
            Integer hours = Integer.valueOf(showInputDialog("HOURS"));
            Double valuePerHour = Double.valueOf(showInputDialog("VALUE PER HOUR"));

            if (isOutsourced.equals("Y")) {
                Double aditionalCharge = Double.valueOf(showInputDialog("ADITIONAL CHARGE"));
                employeesList.add(new OutsourcedEmployeeEntity(name, hours, valuePerHour, aditionalCharge));
            } else {
                employeesList.add(new EmployeeEntity(name, hours, valuePerHour));
            }
        }

        StringBuilder response = new StringBuilder("PAYMENTS:\n");
        employeesList.forEach(employee -> response.append(employee.getName()).append(" - ").append(format("%.2f", employee.pay())).append("\n"));

        showMessageDialog(null, response);
    }
}
