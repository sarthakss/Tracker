package egen.entity;

import javax.persistence.*;
import java.util.UUID;


@Entity
public class Tires {

    @Id
    @Column(columnDefinition = "varchar(36)")
    private String id;

    public Tires() {
        this.id = UUID.randomUUID()
                .toString();
    }

    private int frontLeft;
    private int frontRight;
    private int rearLeft;
    private int rearRight;

    public int getFrontLeft() {
        return frontLeft;
    }

    public void setFrontLeft(int frontLeft) {
        this.frontLeft = frontLeft;
    }

    public int getFrontRight() {
        return frontRight;
    }

    public void setFrontRight(int frontRight) {
        this.frontRight = frontRight;
    }

    public int getRearLeft() {
        return rearLeft;
    }

    public void setRearLeft(int rearLeft) {
        this.rearLeft = rearLeft;
    }

    public int getRearRight() {
        return rearRight;
    }

    public void setRearRight(int rearRight) {
        this.rearRight = rearRight;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tires tires = (Tires) o;

        if (frontLeft != tires.frontLeft) return false;
        if (frontRight != tires.frontRight) return false;
        if (rearLeft != tires.rearLeft) return false;
        return rearRight == tires.rearRight;
    }

    @Override
    public int hashCode() {
        int result = frontLeft;
        result = 31 * result + frontRight;
        result = 31 * result + rearLeft;
        result = 31 * result + rearRight;
        return result;
    }


    @Override
    public String toString() {
        return "Tires{" +
                "frontLeft=" + frontLeft +
                ", frontRight=" + frontRight +
                ", rearLeft=" + rearLeft +
                ", rearRight=" + rearRight +
                '}';
    }
}