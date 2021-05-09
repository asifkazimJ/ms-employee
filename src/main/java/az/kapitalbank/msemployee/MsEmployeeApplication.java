package az.kapitalbank.msemployee;

import az.kapitalbank.msemployee.model.entity.User;
import az.kapitalbank.msemployee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class MsEmployeeApplication {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User(1, "asif", passwordEncoder.encode("password"), "asifkazimov98@gmail.com")
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }

    public static void main(String[] args) {
        SpringApplication.run(MsEmployeeApplication.class, args);
    }

}
