package com.example.userservice;


import com.example.userservice.models.User;
import com.example.userservice.models.UserVisibilityType;
import com.example.userservice.repositories.UserRepository;
import com.example.userservice.repositories.UserVisibilityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserTypeDataLoader {

    private UserVisibilityTypeRepository userTypeRepository;

    private UserRepository userRepository;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserTypeDataLoader(UserVisibilityTypeRepository userTypeRepository,
                                      UserRepository userRepository,
                                      JdbcTemplate jdbcTemplate){
        this.userTypeRepository = userTypeRepository;
        this.userRepository = userRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    private  void seedUserVisibilityType() {
        String sql = "SELECT id FROM user_visibility_type LIMIT 1";
        List<UserVisibilityType> ut = jdbcTemplate.query(sql, (resultSet, rowNum) -> null);
        if( ut == null || ut.size() == 0){

            UserVisibilityType ut1 = new UserVisibilityType();
            ut1.setType("PUBLIC");

            UserVisibilityType ut2 = new UserVisibilityType();
            ut2.setType("PRIVATE");

            UserVisibilityType ut3 = new UserVisibilityType();
            ut3.setType("FOLLOWED");


            userTypeRepository.save(ut1);
            userTypeRepository.save(ut2);
            userTypeRepository.save(ut3);
        }
        System.out.println(userTypeRepository.count());
    }

    private  void seedUser() {
        String sql = "SELECT id, name, username FROM user LIMIT 1"; //////////

        List<User> u = jdbcTemplate.query(sql, (resultSet, rowNum) -> null);
        if( u == null || u.size() == 0){

            Optional<UserVisibilityType> optionalUserVisiblityType = userTypeRepository.findOneByType("PUBLIC");
            UserVisibilityType userVisibilityType = new UserVisibilityType();

            if(optionalUserVisiblityType.isPresent())
                userVisibilityType = optionalUserVisiblityType.get();

            User u1 = new User();
            u1.setName("Emina");
            u1.setSurname("Basic");
            u1.setUsername("ebasic");
            u1.setEmail("ebasic@etf.unsa.ba");
            u1.setPassword("emina123");
            u1.setUserVisibilityType(userVisibilityType);

            optionalUserVisiblityType = userTypeRepository.findOneByType("FOLLOWED");
            userVisibilityType = new UserVisibilityType();

            if(optionalUserVisiblityType.isPresent())
                userVisibilityType = optionalUserVisiblityType.get();

            User u2 = new User();
            u2.setName("Amer");
            u2.setSurname("Basic");
            u2.setUsername("aamer");
            u2.setEmail("amer@etf.unsa.ba");
            u2.setPassword("amer123");
            u2.setUserVisibilityType(userVisibilityType);

            optionalUserVisiblityType = userTypeRepository.findOneByType("PRIVATE");
            userVisibilityType = new UserVisibilityType();

            if(optionalUserVisiblityType.isPresent())
                userVisibilityType = optionalUserVisiblityType.get();

            User u3 = new User();
            u3.setName("Sajra");
            u3.setSurname("Turko");
            u3.setUsername("sturko");
            u3.setEmail("sturko@etf.unsa.ba");
            u3.setPassword("sajra123");
            u3.setUserVisibilityType(userVisibilityType);

            userRepository.save(u1);
            userRepository.save(u2);
            userRepository.save(u3);


        }
        System.out.println(userRepository.count());
    }

    @EventListener
    public  void seed(ContextRefreshedEvent event){
        seedUserVisibilityType();
        seedUser();

    }
}

