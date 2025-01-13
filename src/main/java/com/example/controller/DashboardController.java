package com.example.controller;


import org.springframework.ui.Model;
import com.example.domain.User;
import com.example.service.ArchiveService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    private final ArchiveService archiveService;

    public DashboardController(ArchiveService archiveService) {
        this.archiveService = archiveService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, @ModelAttribute User user) {
        // User nesnesi burada alınıyor ve model'e ekleniyor
        model.addAttribute("archives", archiveService.getArchivesByUser(user));
        return "dashboard";
    }
}

