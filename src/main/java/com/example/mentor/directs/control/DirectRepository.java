package com.example.mentor.directs.control;

import com.example.mentor.directs.entity.Direct;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DirectRepository extends PagingAndSortingRepository<Direct, Long> {
}
