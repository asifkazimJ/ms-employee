package az.kapitalbank.msemployee.controller;

import az.kapitalbank.msemployee.error.ErrorCode;
import az.kapitalbank.msemployee.error.InvalidLoginDetailsException;
import az.kapitalbank.msemployee.model.dto.AuthRequestDto;
import az.kapitalbank.msemployee.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
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
    public String generateToken(@Valid @RequestBody AuthRequestDto authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            log.info("Invalid Username/Password for username={}", authRequest.getUsername());
            throw new InvalidLoginDetailsException(ErrorCode.INVALID_LOGIN_DETAILS, "Username not available in our records");
        }
        return jwtUtil.generateToken(authRequest.getUsername());
    }
}
