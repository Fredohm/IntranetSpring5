package com.iepscf.fredohm.controller;

import com.iepscf.fredohm.entity.User;
import com.iepscf.fredohm.service.RoleService;
import com.iepscf.fredohm.service.UserService;
import com.iepscf.fredohm.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    PasswordEncoder passwordEncoder;

    private Map<String, String> roles;

    @PostConstruct
    protected void loadRoles() {
        roles = new LinkedHashMap<>();

        roles.put("ROLE_EMPLOYEE", "Employee");
        roles.put("ROLE_MANAGER", "Manager");
        roles.put("ROLE_ADMIN", "Admin");
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, trimmerEditor);
    }

    @GetMapping("/list")
    public String listUsers(Model model) {

        List<User> users = userService.getUsers();

        model.addAttribute("users", users);

        return "user-list";
    }

    @GetMapping("/display")
    public String showUser(int id, Model model) {

        User user = userService.getUser(id);

        model.addAttribute("user", user);

        return "user-display";
    }

    @GetMapping("/add")
    public String showFormForAddUser(Model model) {

        model.addAttribute("userDto", new UserDto());
        model.addAttribute("roles", roles);

        return "user-add-form";
    }

    @PostMapping("/save")
    public String processAddForm(
            @Valid @ModelAttribute("userDto") UserDto userAddDto,
            BindingResult bindingResult,
            Model model) {

        String username = userAddDto.getUsername();

        if (bindingResult.hasErrors()) {
            model.addAttribute("roles", roles);
            return "user-add-form";
        }

        User existingUser = userService.findByUserName(username);

        if (existingUser != null) {
            model.addAttribute("userDto", new UserDto());
            model.addAttribute("roles", roles);
            model.addAttribute("registrationError", "Username already exists.");

            return "user-add-form";
        }

        userService.saveUser(userAddDto);

        return "user-added-confirmation";
    }

    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("userId") int id, Model model) {

        UserDto userDto = new UserDto();

        userDto.setId(id);
        userDto.setUsername(userService.getUser(id).getUsername());
        userDto.setFirstName(userService.getUser(id).getFirstName());
        userDto.setLastName(userService.getUser(id).getLastName());
        userDto.setEmail(userService.getUser(id).getEmail());

        String role =userService.getUser(id).getRoles().toString();

        userDto.setFormRole(roleService.findRoleByName(role));


        model.addAttribute("userDto", userDto);
        model.addAttribute("roles", roles);

        return "user-update-form";
    }

    @PostMapping("/processUpdate")
    public String processUpdateForm(
            @Valid @ModelAttribute("userDto") UserDto userDto,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("userDto", userDto);
            model.addAttribute("roles", roles);

            return "user-update-form";
        }

        userService.updateUser(userDto);

        return "user-updated-confirmation";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("userId") int id) {

        userService.deleteUser(id);

        return "redirect:/user/list";
    }
}
