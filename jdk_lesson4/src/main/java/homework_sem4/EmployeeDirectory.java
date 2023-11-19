package homework_sem4;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, представляющий справочник сотрудников.
 */
public class EmployeeDirectory {
    private List<Employee> employees;

    /**
     * Конструктор класса EmployeeDirectory.
     */
    public EmployeeDirectory() {
        employees = new ArrayList<>();
    }

    /**
     * Метод для добавления нового сотрудника в справочник.
     *
     * @param employee сотрудник для добавления
     */
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    /**
     * Метод для поиска сотрудников по стажу.
     *
     * @param experience стаж сотрудников
     * @return список сотрудников с заданным стажем
     */
    public List<Employee> findEmployeesByExperience(int experience) {
        List<Employee> foundEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getExperience() == experience) {
                foundEmployees.add(employee);
            }
        }
        return foundEmployees;
    }

    /**
     * Метод для получения номеров телефонов сотрудников по имени.
     *
     * @param name имя сотрудников
     * @return список номеров телефонов сотрудников с заданным именем
     */
    public List<String> findPhoneNumbersByName(String name) {
        List<String> phoneNumbers = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                phoneNumbers.add(employee.getPhoneNumber());
            }
        }
        return phoneNumbers;
    }

    /**
     * Метод для поиска сотрудника по табельному номеру.
     *
     * @param employeeId табельный номер сотрудника
     * @return найденный сотрудник или null, если не найден
     */
    public Employee findEmployeeByEmployeeId(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeId) {
                return employee;
            }
        }
        return null;
    }
}
