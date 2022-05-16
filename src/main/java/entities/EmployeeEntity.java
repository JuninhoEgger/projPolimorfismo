package entities;

public class EmployeeEntity {

    private String name;
    private Integer hours;
    private Double valuePerHour;

    public EmployeeEntity() {
    }

    public EmployeeEntity(String name, Integer hours, Double valuePerHour) {
        this.name = name;
        this.hours = hours;
        this.valuePerHour = valuePerHour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public double pay() {
        return this.hours * this.valuePerHour;
    }

    @Override
    public String toString() {
        return "NOME: " + name +
                "\nHORAS TRABALHADAS: " + hours +
                "\nVALOR POR HORA: " + valuePerHour;
    }
}
