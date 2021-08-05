package com.threalcavey.studentjpa.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class BootLoader {

    @Bean
    CommandLineRunner commandLineRunner (
            StudentRepository repository) {
        return args -> {
            Student mariam = new Student(
                    "Mariam",
                    "mariam.jamal@gmail.com",
                    LocalDate.of(2000, Month.JANUARY,5)
            );

            Student andrew = new Student (
                            "Andrew",
                            "andrew.j.cave@gmail.com",
                            LocalDate.of(1963,Month.JUNE,13)
            );

            repository.saveAll(
                    List.of(mariam, andrew)
            );
        };

    }


}
