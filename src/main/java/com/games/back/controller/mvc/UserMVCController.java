package com.games.back.controller.mvc;

import java.sql.Timestamp;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.games.back.model.User;
import com.games.back.services.IRoleService;
import com.games.back.services.IUserService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/mvc/users")
@RequiredArgsConstructor
public class UserMVCController {

    private final IUserService userService;
    private final IRoleService roleService;
    
    @GetMapping
    @PreAuthorize("hasAuthority('view-user')")
    public String getAll(Model model) {
        model.addAttribute("users", userService.findAll());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        auth.getAuthorities().forEach(authority -> System.out.println(authority.getAuthority()));
        return "users/list";
    }

    @GetMapping("/add")
    @PreAuthorize("hasAuthority('create-user')")
    public String addUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.findAll());
        return "users/add";
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('create-user')")
    public String addUser(@ModelAttribute User user) {
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        userService.save(user);
        return "redirect:/mvc/users";
    }

    @GetMapping("/edit")
    @PreAuthorize("hasAuthority('update-user')")
    public String editUserForm(@RequestParam Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("actualUser", user);
        model.addAttribute("roles", roleService.findAll());
        return "users/edit";
    }

    @PostMapping("/edit")
    @PreAuthorize("hasAuthority('update-user')")
    public String editUser(@ModelAttribute("actualUser") User user) {
        userService.save(user);
        return "redirect:/mvc/users";
    }

    @GetMapping("/delete")
    @PreAuthorize("hasAuthority('delete-user')")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteById(id);
        return "redirect:/mvc/users";
    }

}
