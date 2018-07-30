package com.example.mentor.directs.control;

import com.example.mentor.directs.entity.Direct;
import com.example.mentor.managers.entity.Manager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DirectRepository extends PagingAndSortingRepository<Direct, Long> {
    Page<Direct> findAllByManager(Manager manager, Pageable pageable);
}
