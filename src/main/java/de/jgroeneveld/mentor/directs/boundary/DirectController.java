package de.jgroeneveld.mentor.directs.boundary;

import de.jgroeneveld.mentor.directs.control.DirectRepository;
import de.jgroeneveld.mentor.directs.entity.Direct;
import de.jgroeneveld.mentor.managers.control.ManagerRepository;
import de.jgroeneveld.mentor.managers.entity.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @GetMapping("/managers/{managerId}/directs/{id}")
    public Direct getManagerDirect(HttpServletResponse response, @PathVariable long managerId, @PathVariable long id) {
        Optional<Manager> manager = managerRepository.findById(managerId);

        if (!manager.isPresent()) {
            response.setStatus(404);
            return null;
        }

        Optional<Direct> direct = directRepository.findByIdAndManager(id, manager.get());

        if (!direct.isPresent()) {
            response.setStatus(404);
            return null;
        }

        return direct.get();
    }

    @GetMapping("/managers/{managerId}/directs")
    public Iterable<DirectListElement> listManagerDirects(HttpServletResponse response, @PathVariable long managerId, Pageable pageable) {
        Optional<Manager> manager = managerRepository.findById(managerId);

        if (!manager.isPresent()) {
            response.setStatus(404);
            return null;
        }

        Page<Direct> page = directRepository.findAllByManager(manager.get(), pageable);

        return page.map(DirectListElement::of);
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
