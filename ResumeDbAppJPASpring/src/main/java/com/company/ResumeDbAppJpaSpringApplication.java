package com.company;

import com.company.dao.imple.UserDaoImpl;
import com.company.dao.inter.UserRepository;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ResumeDbAppJpaSpringApplication {
    @Autowired
    private UserDaoImpl userDao;

    public static void main(String[] args) {
        SpringApplication.run(ResumeDbAppJpaSpringApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner run(){
//        CommandLineRunner clr=new CommandLineRunner(){
//            @Override
//            public void run(String... args) throws Exception {
//                List<User> list=userDao.getAll(null,null,null);
//                System.out.println(list);
//            }
//        };
//        return clr;
//    }

    @Autowired
    private UserRepository userRepository;
    @Bean
    public CommandLineRunner run(){
        CommandLineRunner clr=new CommandLineRunner(){
            @Override
            public void run(String... args) throws Exception {
                User user=userRepository.findByNameAndSurnameAndEmail("Online", "Carats", "online.carats@gmail.com");
                System.out.println(user);

            }
        };
        return clr;
    }
}
