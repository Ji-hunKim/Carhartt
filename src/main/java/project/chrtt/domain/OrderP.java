package project.chrtt.domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter@Setter
public class OrderP {
    private Long oId;
    private Timestamp oDate;
    private Long oPrice;
    private Long oTPrice;
    private String oState;
    private int oStateNum;
    private Long pId;
    private String logId;
    private String payId;
    private String oCode;
    private int oQuantity;

    public OrderP() {
    }

    public OrderP(Timestamp oDate, Long oPrice, Long oTPrice, String oState, int oStateNum, Long pId, String logId, String payId, String oCode, int oQuantity) {
        this.oDate = oDate;
        this.oPrice = oPrice;
        this.oTPrice = oTPrice;
        this.oState = oState;
        this.oStateNum = oStateNum;
        this.pId = pId;
        this.logId = logId;
        this.payId = payId;
        this.oCode = oCode;
        this.oQuantity = oQuantity;
    }

    public OrderP(Long oId, Timestamp oDate, Long oPrice, Long oTPrice, String oState, int oStateNum, Long pId, String logId, String payId, String oCode, int oQuantity) {
        this.oId = oId;
        this.oDate = oDate;
        this.oPrice = oPrice;
        this.oTPrice = oTPrice;
        this.oState = oState;
        this.oStateNum = oStateNum;
        this.pId = pId;
        this.logId = logId;
        this.payId = payId;
        this.oCode = oCode;
        this.oQuantity = oQuantity;
    }
}
