package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SLAEvent {

    private String hes;
    private Long slaId;
    private String meterId;
    private String meterTimeStamp;
    private String serverTimeStamp;

    public String getHes() {
        return hes;
    }

    public void setHes(String hes) {
        this.hes = hes;
    }

    public Long getSlaId() {
        return slaId;
    }

    public void setSlaId(Long slaId) {
        this.slaId = slaId;
    }

    public String getServerTimeStamp() {
        return serverTimeStamp;
    }

    public void setServerTimeStamp(String serverTimeStamp) {
        this.serverTimeStamp = serverTimeStamp;
    }

    public String getMeterTimeStamp() {
        return meterTimeStamp;
    }

    public void setMeterTimeStamp(String meterTimeStamp) {
        this.meterTimeStamp = meterTimeStamp;
    }

    public String getMeterId() {
        return meterId;
    }

    public void setMeterId(String meterId) {
        this.meterId = meterId;
    }
}
