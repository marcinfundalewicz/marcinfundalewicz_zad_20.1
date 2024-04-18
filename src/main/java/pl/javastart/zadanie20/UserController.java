package pl.javastart.zadanie20;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/users")
    @ResponseBody
    String showUsers() {
        String result = "";
        for (User user : userRepository.getUserList()) {
            result += user + "</br>";
        }
        return result;
    }

    @RequestMapping("/add")
    String addUser(@RequestParam(value = "imie", required = false) String name,
                   @RequestParam(value = "nazwisko", required = false) String surname,
                   @RequestParam(value = "wiek", required = false) Integer age) {
        if (!name.isEmpty() && !surname.isEmpty() && age != null) {
            userRepository.addUser(name, surname, age);
            return "redirect:/success.html";
        }
        else {
            return "redirect:/err.html";
        }
    }
}


