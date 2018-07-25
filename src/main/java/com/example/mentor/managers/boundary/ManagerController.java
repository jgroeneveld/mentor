package com.example.mentor.managers.boundary;

import com.example.mentor.managers.control.ManagerRepository;
import com.example.mentor.managers.entity.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Optional;

@RestController
public class ManagerController {

    private ManagerRepository managerRepository;

    @Autowired
    public ManagerController(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @GetMapping("/managers")
    public Iterable<Manager> index(Pageable pageable) {
        return managerRepository.findAll(pageable);
    }

    @GetMapping("/managers/{id}")
    public Manager get(HttpServletResponse response, @PathVariable long id) {
        Optional<Manager> manager = managerRepository.findById(id);

        if (manager.isPresent()) {
            return manager.get();
        }

        response.setStatus(404);
        return null;
    }


    @PostMapping("/managers")
    public Manager create(@Valid @RequestBody CreateManagerPayload payload) {
        Manager manager = new Manager(payload.firstName, payload.lastName);

        return managerRepository.save(manager);
    }
}
