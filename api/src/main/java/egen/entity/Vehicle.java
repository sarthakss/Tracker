package egen.entity;

import javax.persistence.*;


@Entity
@NamedQueries({
        @NamedQuery(name = "Vehicle.findAll",
                query = "SELECT vehicle FROM Vehicle vehicle")
})
public class Vehicle {

    @Id
    private String vin;

    private String make;
    private String model;
    private int year;
    private int redlineRpm;
    private double maxFuelVolume;
    private String lastServiceDate;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(int redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public double getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(double maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public String getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(String lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        if (year != vehicle.year) return false;
        if (redlineRpm != vehicle.redlineRpm) return false;
        if (Double.compare(vehicle.maxFuelVolume, maxFuelVolume) != 0) return false;
        if (vin != null ? !vin.equals(vehicle.vin) : vehicle.vin != null) return false;
        if (make != null ? !make.equals(vehicle.make) : vehicle.make != null) return false;
        if (model != null ? !model.equals(vehicle.model) : vehicle.model != null) return false;
        return lastServiceDate != null ? lastServiceDate.equals(vehicle.lastServiceDate) : vehicle.lastServiceDate == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = vin != null ? vin.hashCode() : 0;
        result = 31 * result + (make != null ? make.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + redlineRpm;
        temp = Double.doubleToLongBits(maxFuelVolume);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (lastServiceDate != null ? lastServiceDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vin='" + vin + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", redlineRpm=" + redlineRpm +
                ", maxFuelVolume=" + maxFuelVolume +
                ", lastServiceDate='" + lastServiceDate + '\'' +
                '}';
    }
}