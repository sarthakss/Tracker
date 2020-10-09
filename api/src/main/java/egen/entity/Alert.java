package egen.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name = "Alert.findAllAlerts",
                query = "SELECT alert FROM Alert alert WHERE alert.vin=:vin")
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

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
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