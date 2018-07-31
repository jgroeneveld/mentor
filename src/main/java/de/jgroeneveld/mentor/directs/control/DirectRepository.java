package de.jgroeneveld.mentor.directs.control;

import de.jgroeneveld.mentor.directs.entity.Direct;
import de.jgroeneveld.mentor.managers.entity.Manager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface DirectRepository extends PagingAndSortingRepository<Direct, Long> {
    Page<Direct> findAllByManager(Manager manager, Pageable pageable);

    Optional<Direct> findByIdAndManager(long id, Manager manager);
}
