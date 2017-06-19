package egen.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name = "Alert.findAllAlertsOfSingleVehicle",
                query = "SELECT alert FROM Alert alert WHERE alert.vin=:vin"),

        @NamedQuery(name = "Alert.findAllAlerts",
                query = "SELECT alert FROM Alert alert")

})
public class Alert {

    @Id
    @Column(columnDefinition = "varchar(36)")
    private String id;

    public Alert() {
        this.id = UUID.randomUUID()
                .toString();
    }

    private String vin;

    private AlertPriority alertPriority;
    private String alertMessage;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date timestamp;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public AlertPriority getAlertPriority() {
        return alertPriority;
    }

    public void setAlertPriority(AlertPriority alertPriority) {
        this.alertPriority = alertPriority;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }
}