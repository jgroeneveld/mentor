package com.example.mentor.directs.boundary;

import com.example.mentor.directs.control.DirectRepository;
import com.example.mentor.directs.entity.Direct;
import com.example.mentor.managers.control.ManagerRepository;
import com.example.mentor.managers.entity.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Optional;

@RestController
public class DirectController {

    private DirectRepository directRepository;
    private ManagerRepository managerRepository;

    @Autowired
    public DirectController(DirectRepository directRepository, ManagerRepository managerRepository) {
        this.directRepository = directRepository;
        this.managerRepository = managerRepository;
    }

    @GetMapping("/managers/{managerId}/directs")
    public Iterable<Direct> listManagerDirects(HttpServletResponse response, @PathVariable long managerId, Pageable pageable) {
        Optional<Manager> manager = managerRepository.findById(managerId);

        if (!manager.isPresent()) {
            response.setStatus(404);
            return null;
        }

        return directRepository.findAllByManager(manager.get());
    }

    @PostMapping("/managers/{managerId}/directs")
    public Direct create(HttpServletResponse response, @PathVariable long managerId, @Valid @RequestBody CreateDirectPayload payload) {
        Optional<Manager> manager = managerRepository.findById(managerId);

        if (!manager.isPresent()) {
            response.setStatus(404);
            return null;
        }

        Direct direct = new Direct(payload.firstName, payload.lastName, manager.get());

        return directRepository.save(direct);
    }
}
