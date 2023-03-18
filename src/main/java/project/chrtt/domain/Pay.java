package project.chrtt.domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Pay {
    private Long pay_id;
    private Long pay_price;
    private String pay_state;
    private Long pay_state_num;
    private Long m_id;

    public Pay(){
    }

    public Pay(Long pay_id, Long pay_price, String pay_state, Long pay_state_num, Long m_id) {
        this.pay_id = pay_id;
        this.pay_price = pay_price;
        this.pay_state = pay_state;
        this.pay_state_num = pay_state_num;
        this.m_id = m_id;
    }
}
