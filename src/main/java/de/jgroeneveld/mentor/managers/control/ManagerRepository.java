package de.jgroeneveld.mentor.managers.control;

import de.jgroeneveld.mentor.managers.entity.Manager;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ManagerRepository extends PagingAndSortingRepository<Manager, Long> {
}
