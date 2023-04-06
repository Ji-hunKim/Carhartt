package project.chrtt.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter@Setter
public class Pay {
    @NotNull
    private String payId;
    private Timestamp timestamp;
    private Long payPrice;
    private String payState;
    private int payStateNum;
    private int payTypeNum;
    private String payType;
    private Long pId;
    private String logId;

    public Pay(String payId, Long payPrice, String payState, int payStateNum, int payTypeNum, String payType, Long pId, String logId) {
        this.payId = payId;
        this.payPrice = payPrice;
        this.payState = payState;
        this.payStateNum = payStateNum;
        this.payTypeNum = payTypeNum;
        this.payType = payType;
        this.pId = pId;
        this.logId = logId;
    }

    public Pay(String payId, Timestamp timestamp, Long payPrice, String payState, int payStateNum, int payTypeNum, String payType, Long pId, String logId) {
        this.payId = payId;
        this.timestamp = timestamp;
        this.payPrice = payPrice;
        this.payState = payState;
        this.payStateNum = payStateNum;
        this.payTypeNum = payTypeNum;
        this.payType = payType;
        this.pId = pId;
        this.logId = logId;
    }
}
