package esport.lol.lolfm.service;

import esport.lol.lolfm.dto.UserRegistrationDto;
import esport.lol.lolfm.model.Role;
import esport.lol.lolfm.model.User;
import esport.lol.lolfm.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public void register(UserRegistrationDto registrationDto) {
        // 비밀번호 일치 확인
        if (!registrationDto.getPassword().equals(registrationDto.getPasswordConfirm())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        // 아이디 중복 확인
        if (userRepository.findByUsername(registrationDto.getUsername()).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }

        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword())); // 암호화 후 저장
        user.setRole(Role.USER); // 기본 권한은 USER로 설정
        user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);
    }
}
