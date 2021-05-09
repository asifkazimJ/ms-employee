package az.kapitalbank.msemployee;

import az.kapitalbank.msemployee.model.entity.User;
import az.kapitalbank.msemployee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class MsEmployeeApplication {

    @Autowired
    private UserRepository repository;


    @PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User(1, "asif", "password", "asifkazimov98@gmail.com")
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }

    public static void main(String[] args) {
        SpringApplication.run(MsEmployeeApplication.class, args);
    }

}
