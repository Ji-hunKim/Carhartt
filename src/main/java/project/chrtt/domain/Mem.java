package project.chrtt.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter@Setter
public class Mem {
    @NotEmpty
    private String logId;
    @NotEmpty
    private String logPw;
    @NotEmpty
    private String mTell;
    @NotEmpty
    private String mSex;
    @NotEmpty
    private String mName;
    @NotEmpty
    private String mIsmanager;

    public Mem(){
    }

    public Mem(String logId, String logPw, String mTell, String mSex, String mName, String mIsmanager) {
        this.logId = logId;
        this.logPw = logPw;
        this.mTell = mTell;
        this.mSex = mSex;
        this.mName = mName;
        this.mIsmanager = mIsmanager;
    }
}
