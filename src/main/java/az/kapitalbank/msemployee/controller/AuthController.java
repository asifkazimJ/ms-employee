package az.kapitalbank.msemployee.controller;

import az.kapitalbank.msemployee.model.dto.AuthRequestDto;
import az.kapitalbank.msemployee.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {


    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping("/")
    public String welcome() {
        return "Welcome";
    }

    @PostMapping("/login")
    public String generateToken(@RequestBody AuthRequestDto authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("invalid username or Password");
        }

        return jwtUtil.generateToken(authRequest.getUsername());
    }
}
