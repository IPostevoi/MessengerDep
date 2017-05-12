package hello.controller;

import hello.Config;
import hello.abstracts.UserDTO;
import hello.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by bakla410 on 11.05.17.
 */
@Controller
public class RegisterController {

    @GetMapping("/register")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDTO userDto = new UserDTO();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @PostMapping("/register")
    public String registerUserAccount(
            @ModelAttribute("user") @Valid UserDTO accountDto, BindingResult result) {
        if (!result.hasErrors()) {
            User newUser = new User();
            if (accountDto.getPassword().equals(accountDto.getMatchingPassword())) {
                if (!Config.getUser().ifExists(accountDto.getUsername())) {
                    Config.getUser().create(accountDto.getUsername(), accountDto.getPassword());
                    return "redirect:/login";
                }
            }
        }
        return "redirect:/register?error";
    }
}
