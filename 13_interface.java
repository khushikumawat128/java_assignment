import java.util.Objects;

class Vehicle {
    private int number;
    private String name;
    private double price;

    public Vehicle(int number, String name, double price) {
        this.number = number;
        this.name = name;
        this.price = price;
    }
    //equal method
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null ) return false;
        Vehicle vehicle = (Vehicle) o;
        return number == vehicle.number &&
                Double.compare(vehicle.price, price) == 0 &&
                Objects.equals(name, vehicle.name);
    }
    //hashcode
    public int hashCode() {
        return Objects.hash(number, name, price);
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle(1, "Car", 20000);
        Vehicle v2 = new Vehicle(1, "Car", 20000);
        Vehicle v3 = new Vehicle(2, "Bike", 1500);

        // equals method
        System.out.println(v1.equals(v2));
        System.out.println(v1.equals(v3));

        // hashCode method
        System.out.println(v1.hashCode() == v2.hashCode());
        System.out.println(v1.hashCode() == v3.hashCode());
    }
}
