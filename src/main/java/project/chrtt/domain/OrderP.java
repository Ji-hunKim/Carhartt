package project.chrtt.domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class OrderP {
    private Long oId;
    private Long oPrice;
    private Long oTPrice;
    private Long oCnt;
    private String oCode;
    private String oState;
    private Long oStateNum;
    private Long mId;
    private Long pId;

    public OrderP() {
    }

    public OrderP(Long oId, Long oPrice, Long oTPrice, Long oCnt, String oCode, String oState, Long oStateNum, Long mId, Long pId) {
        this.oId = oId;
        this.oPrice = oPrice;
        this.oTPrice = oTPrice;
        this.oCnt = oCnt;
        this.oCode = oCode;
        this.oState = oState;
        this.oStateNum = oStateNum;
        this.mId = mId;
        this.pId = pId;
    }
}
