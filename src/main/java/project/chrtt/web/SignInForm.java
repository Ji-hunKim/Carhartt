package project.chrtt.web;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class SignInForm {
    @NotEmpty
    private String logId;
    @NotEmpty
    private String logPw;
}
