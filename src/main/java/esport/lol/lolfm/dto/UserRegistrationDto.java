package esport.lol.lolfm.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRegistrationDto {

    private String username;
    private String password;
    private String passwordConfirm; // 비밀번호 확인 필드
}
