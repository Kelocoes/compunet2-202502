package com.games.back.controller.mvc;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.games.back.dtos.User.UserInDTO;
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

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('view-user') or #id == authentication.principal.user.id")
    public String getById(@PathVariable Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "users/detail";
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
    public String addUser(@ModelAttribute UserInDTO user) {
        userService.save(user);
        return "redirect:/mvc/users";
    }

    @GetMapping("/edit")
    @PreAuthorize("hasAuthority('edit-user') or #id == authentication.principal.user.id")
    public String editUserForm(@RequestParam Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("actualUser", user);
        model.addAttribute("roles", roleService.findAll());
        return "users/edit";
    }

    @PostMapping("/edit")
    @PreAuthorize("hasAuthority('edit-user') or #id == authentication.principal.user.id")
    public String editUser(@ModelAttribute("actualUser") UserInDTO user) {
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
