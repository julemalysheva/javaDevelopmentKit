package homework_sem4;

/**
 * Класс, представляющий сотрудника.
 */
public class Employee {
    private int employeeId;
    private String name;
    private String phoneNumber;
    private int experience;

    /**
     * Конструктор класса Employee.
     *
     * @param employeeId   табельный номер сотрудника
     * @param name         имя сотрудника
     * @param phoneNumber  номер телефона сотрудника
     * @param experience   стаж сотрудника
     */
    public Employee(int employeeId, String name, String phoneNumber, int experience) {
        this.employeeId = employeeId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.experience = experience;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", experience=" + experience +
                '}';
    }
}
