package com.example.controller;

import com.example.domain.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private List<User> userList = new ArrayList<>();

    @GetMapping("/addUser")
    public String addUserForm() {
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam Long id ,@RequestParam String username, @RequestParam String password,@RequestParam String role) {
        userList.add(new User(id,username, password, role));
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userList);
        return "users";
    }

    @Autowired
    private UserRepository userRepository;

    // Kullanıcı ekleme formunu göster
    @GetMapping("/add")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "add-user";  // "add-user.html" sayfasına yönlendirme
    }

    // Formdan gelen veriyi işleyip veritabanına kaydet
    @PostMapping("/add")
    public String addUser(@ModelAttribute User user) {
        userRepository.save(user);  // Kullanıcıyı veritabanına kaydet
        return "redirect:/users/add";  // Başarılı eklemeden sonra tekrar formu göster
    }

}
// http://localhost:8080/login