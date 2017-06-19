package egen.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;
@Entity
@NamedQueries({
        @NamedQuery(name = "Reading.findReadingsOfSingleVehicle",
                query = "SELECT reading FROM Reading reading WHERE reading.vin=:vin")

})
public class Reading {

    @Id
    @Column(columnDefinition = "varchar(36)")
    private String id;

    public Reading() {
        this.id = UUID.randomUUID()
                .toString();
    }

    private String vin;

    private double latitude;
    private double longitude;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date timestamp;

    private double fuelVolume;
    private int speed;
    private int engineHp;
    private boolean checkEngineLightOn;
    private boolean engineCoolantLow;
    private boolean cruiseControlOn;
    private int engineRpm;

    @OneToOne(cascade = {CascadeType.PERSIST})
    private Tires tires;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public double getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(double fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getEngineHp() {
        return engineHp;
    }

    public void setEngineHp(int engineHp) {
        this.engineHp = engineHp;
    }

    public boolean isCheckEngineLightOn() {
        return checkEngineLightOn;
    }

    public void setCheckEngineLightOn(boolean checkEngineLightOn) {
        this.checkEngineLightOn = checkEngineLightOn;
    }

    public boolean isEngineCoolantLow() {
        return engineCoolantLow;
    }

    public void setEngineCoolantLow(boolean engineCoolantLow) {
        this.engineCoolantLow = engineCoolantLow;
    }

    public boolean isCruiseControlOn() {
        return cruiseControlOn;
    }

    public void setCruiseControlOn(boolean cruiseControlOn) {
        this.cruiseControlOn = cruiseControlOn;
    }

    public int getEngineRpm() {
        return engineRpm;
    }

    public void setEngineRpm(int engineRpm) {
        this.engineRpm = engineRpm;
    }

    public Tires getTires() {
        return tires;
    }

    public void setTires(Tires tires) {
        this.tires = tires;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reading reading = (Reading) o;

        if (Double.compare(reading.latitude, latitude) != 0) return false;
        if (Double.compare(reading.longitude, longitude) != 0) return false;
        if (Double.compare(reading.fuelVolume, fuelVolume) != 0) return false;
        if (speed != reading.speed) return false;
        if (engineHp != reading.engineHp) return false;
        if (checkEngineLightOn != reading.checkEngineLightOn) return false;
        if (engineCoolantLow != reading.engineCoolantLow) return false;
        if (cruiseControlOn != reading.cruiseControlOn) return false;
        if (engineRpm != reading.engineRpm) return false;
        if (vin != null ? !vin.equals(reading.vin) : reading.vin != null) return false;
        if (timestamp != null ? !timestamp.equals(reading.timestamp) : reading.timestamp != null) return false;
        return tires != null ? tires.equals(reading.tires) : reading.tires == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = vin != null ? vin.hashCode() : 0;
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        temp = Double.doubleToLongBits(fuelVolume);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + speed;
        result = 31 * result + engineHp;
        result = 31 * result + (checkEngineLightOn ? 1 : 0);
        result = 31 * result + (engineCoolantLow ? 1 : 0);
        result = 31 * result + (cruiseControlOn ? 1 : 0);
        result = 31 * result + engineRpm;
        result = 31 * result + (tires != null ? tires.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Reading{" +
                "vin='" + vin + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", timestamp=" + timestamp +
                ", fuelVolume=" + fuelVolume +
                ", speed=" + speed +
                ", engineHp=" + engineHp +
                ", checkEngineLightOn=" + checkEngineLightOn +
                ", engineCoolantLow=" + engineCoolantLow +
                ", cruiseControlOn=" + cruiseControlOn +
                ", engineRpm=" + engineRpm +
                ", tires=" + tires +
                '}';
    }
}