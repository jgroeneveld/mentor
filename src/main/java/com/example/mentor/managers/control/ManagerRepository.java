package com.example.mentor.managers.control;

import com.example.mentor.managers.entity.Manager;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ManagerRepository extends PagingAndSortingRepository<Manager, Long> {
}
