package com.example.demo.Controller;

import com.example.demo.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    // LIST PENYIMPAN DATA (sementara)
    private List<User> userList = new ArrayList<>();

    // LOGIN
    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        if (username.equals("admin") && password.equals("1234")) {
            return "redirect:/home";
        }
        return "login";
    }

    // HOME
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    // FORM
    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    // SUBMIT → SIMPAN KE LIST
    @PostMapping("/submit")
    public String submit(@ModelAttribute User user, Model model) {
        userList.add(user); // simpan ke list
        model.addAttribute("listUser", userList);
        return "result";
    }

    // HALAMAN RESULT (biar bisa dibuka lagi)
    @GetMapping("/result")
    public String result(Model model) {
        model.addAttribute("listUser", userList);
        return "result";
    }
}