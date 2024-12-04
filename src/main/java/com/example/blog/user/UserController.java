package com.example.blog.user;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;
    private final HttpSession session;

    // 로그인 폼으로 이동
    @GetMapping("/login-form")
    public String loginForm() {
        return "user/login-form";
    }

    // 로그인
    @PostMapping("/login")
    public String login(HttpServletRequest request, UserRequest.LoginDTO loginDTO) {
        User user = userService.로그인(loginDTO);

        HttpSession session = request.getSession();
        session.setAttribute("sessionUser", user);
        return "redirect:/";
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
//        session.removeAttribute("sessionUser");
        session.invalidate();
        return "redirect:/";
    }

    // 회원가입 폼으로
    @GetMapping("/join-form")
    public String joinForm() {
        return "user/join-form";
    }

    // 회원 가입
    @PostMapping("/join")
    public String join(UserRequest.JoinDTO joinDTO) {
        userService.join(joinDTO);
        return "redirect:/";
    }
}
