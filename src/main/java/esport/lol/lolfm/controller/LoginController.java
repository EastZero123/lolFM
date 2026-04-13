package esport.lol.lolfm.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/main")
    public String main(Authentication authentication) {
        // 1. 현재 로그인한 사용자의 권한 목록을 가져옴
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        // 2. 권한에 따라 리다이렉트 경로 결정
        for (GrantedAuthority authority : authorities) {
            String role = authority.getAuthority();
            if (role.equals("ROLE_ADMIN")) {
                return "redirect:/admin/players/new"; // 관리자면 선수 생성 페이지로
            }
        }

        // 3. 일반 유저라면 게임 메인 화면으로
        return "game/lobby";
    }
}
