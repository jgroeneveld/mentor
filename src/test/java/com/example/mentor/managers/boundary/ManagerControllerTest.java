package com.example.mentor.managers.boundary;

import com.example.mentor.managers.control.ManagerRepository;
import com.example.mentor.managers.entity.Manager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ManagerControllerTest {

    @Autowired
    ManagerController controller;

    @Autowired
    ManagerRepository repository;

    private static final Pageable PAGEABLE = PageRequest.of(0, 10);

    @Test
    public void controllerInitializedCorrectly() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void listIsEmpty() {
        Iterable<Manager> result = controller.list(PAGEABLE);

        assertThat(result).hasSize(0);
    }

    @Test
    public void listReturnsManagers() {
        Manager manager = repository.save(new Manager("hans", "muller"));

        Iterable<Manager> result = controller.list(PAGEABLE);

        assertThat(result).hasSize(1);
        assertThat(result).extracting("firstName", "lastName").contains(tuple("hans", "muller"));
    }
}