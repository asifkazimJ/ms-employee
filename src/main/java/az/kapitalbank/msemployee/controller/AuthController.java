package az.kapitalbank.msemployee.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @RequestMapping("/")
    public String welcome() {
        return "Welcome";
    }

}
