package project.chrtt.domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Mem {
    private Long m_id;
    private String log_id;
    private String log_pw;
    private String m_tell;
    private String m_sex;
    private String m_name;

    public Mem(){
    }

    public Mem(String log_id, String log_pw, String m_tell, String m_sex, String m_name) {
        this.log_id = log_id;
        this.log_pw = log_pw;
        this.m_tell = m_tell;
        this.m_sex = m_sex;
        this.m_name = m_name;
    }
}
