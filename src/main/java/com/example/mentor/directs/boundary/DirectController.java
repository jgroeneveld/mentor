package com.example.mentor.directs.boundary;

import com.example.mentor.directs.control.DirectRepository;
import com.example.mentor.directs.entity.Direct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DirectController {

    private DirectRepository directRepository;

    @Autowired
    public DirectController(DirectRepository directRepository) {
        this.directRepository = directRepository;
    }

    @GetMapping("/directs")
    public Iterable<Direct> index(Pageable pageable) {
        return directRepository.findAll(pageable);
    }
}
