package com.threalcavey.studentjpa.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Locale;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckIfStudentExistsEmail() {
        //given
        String email = "jamilla@gmail.com";
        Student student = new Student(
                "Jamilla",
                email,
                LocalDate.of(2000, Month.JANUARY,5)
        );
        underTest.save(student);

        //when
        Optional<Student> studentOptional = underTest.findStudentByEmail(email);

        //then
        assertThat(studentOptional.isPresent()).isTrue();
    }

    @Test
    void itShouldCheckWhenStudentEmailDoesNotExists() {
        // given
        String email = "jamila@gmail.com";

        // when
        Optional<Student> studentOptional = underTest.findStudentByEmail(email);

        //then
        assertThat(studentOptional.isPresent()).isFalse();
    }
}