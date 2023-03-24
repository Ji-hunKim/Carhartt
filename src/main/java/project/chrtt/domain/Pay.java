package project.chrtt.domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Pay {
    private Long payId;
    private Long payPrice;
    private String payState;
    private Long payStateNum;
    private Long mId;

    public Pay(){
    }

    public Pay(Long payId, Long payPrice, String payState, Long payStateNum, Long mId) {
        this.payId = payId;
        this.payPrice = payPrice;
        this.payState = payState;
        this.payStateNum = payStateNum;
        this.mId = mId;
    }
}
