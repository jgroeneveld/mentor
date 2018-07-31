package de.jgroeneveld.mentor.seed;

import com.github.javafaker.Faker;
import de.jgroeneveld.mentor.directs.control.DirectRepository;
import de.jgroeneveld.mentor.directs.entity.Direct;
import de.jgroeneveld.mentor.managers.control.ManagerRepository;
import de.jgroeneveld.mentor.managers.entity.Manager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("seed")
public class Seeder {
    private static final Logger logger = LoggerFactory.getLogger(Seeder.class);

    private ManagerRepository managerRepository;
    private DirectRepository directRepository;

    @Autowired
    public Seeder(ManagerRepository managerRepository, DirectRepository directRepository) {
        this.managerRepository = managerRepository;
        this.directRepository = directRepository;

        logger.info("Will seed database");

        directRepository.deleteAll();
        managerRepository.deleteAll();

        Faker faker = new Faker();

        for (int i = 0; i < 3; i++) {
            Manager manager = managerRepository.save(fakeManager(faker));
            for (int j = 0; j < 10; j++) {
                directRepository.save(fakeDirekt(faker, manager));
            }
        }
    }

    private Manager fakeManager(Faker faker) {
        return new Manager(
                faker.name().firstName(),
                faker.name().lastName()
        );
    }

    private Direct fakeDirekt(Faker faker, Manager manager) {
        return new Direct(
                faker.name().firstName(),
                faker.name().lastName(),
                manager
        );
    }
}
