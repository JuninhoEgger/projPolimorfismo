package entities;

public class OutsourcedEmployeeEntity extends EmployeeEntity {

    private Double aditionalCharge;

    public OutsourcedEmployeeEntity() {
        super();
    }

    public OutsourcedEmployeeEntity(String name, Integer hours, Double valuePerHour, Double aditionalCharge) {
        super(name, hours, valuePerHour);
        this.aditionalCharge = aditionalCharge;
    }

    public Double getAditionalCharge() {
        return aditionalCharge;
    }

    public void setAditionalCharge(Double aditionalCharge) {
        this.aditionalCharge = aditionalCharge;
    }

    @Override
    public double pay() {
        return super.pay() + aditionalCharge * 1.1;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nVALOR ADICIONAL: $ " + aditionalCharge + "\n";
    }
}
