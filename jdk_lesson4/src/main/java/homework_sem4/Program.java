package homework_sem4;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        // Создание нового справочника сотрудников
        EmployeeDirectory directory = new EmployeeDirectory();

        // Создание нескольких сотрудников
        Employee emp1 = new Employee(1, "Kate", "1234567890", 5);
        Employee emp2 = new Employee(2, "Ivan", "9876543210", 3);
        Employee emp3 = new Employee(3, "Oleg", "4567890123", 7);
        Employee emp4 = new Employee(4, "Vika", "7586985424", 5);

        // Добавление сотрудников в справочник
        directory.addEmployee(emp1);
        directory.addEmployee(emp2);
        directory.addEmployee(emp3);
        directory.addEmployee(emp4);

        // Поиск сотрудников по стажу
        List<Employee> employeesWithExperience5 = directory.findEmployeesByExperience(5);
        System.out.println("Сотрудники со стажем 5: ");
        System.out.println(employeesWithExperience5.toString());


        // Получение номеров телефонов сотрудников по имени
        List<String> phoneNumbersByNameIvan = directory.findPhoneNumbersByName("Ivan");
        System.out.println("Номера телефонов сотрудников с именем Ivan: ");
        for (String phoneNumber : phoneNumbersByNameIvan) {
            System.out.println(phoneNumber);
        }

        // Поиск сотрудника по табельному номеру
        Employee foundEmployee = directory.findEmployeeByEmployeeId(3);
        if (foundEmployee != null) {
            System.out.println("Найден сотрудник с табельным номером 3: " + foundEmployee);
        } else {
            System.out.println("Сотрудник с табельным номером 3 не найден.");
        }
    }
}

/**
 * Сотрудники со стажем 5:
 * [Employee{employeeId=1, name='Kate', phoneNumber='1234567890', experience=5}, Employee{employeeId=4, name='Vika', phoneNumber='7586985424', experience=5}]
 * Номера телефонов сотрудников с именем Ivan:
 * 9876543210
 * Найден сотрудник с табельным номером 3: Employee{employeeId=3, name='Oleg', phoneNumber='4567890123', experience=7}
 */
