package com.example.mentor.directs.control;

import com.example.mentor.directs.entity.Direct;
import com.example.mentor.managers.entity.Manager;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DirectRepository extends PagingAndSortingRepository<Direct, Long> {
    Iterable<Direct> findAllByManager(Manager manager);
}
