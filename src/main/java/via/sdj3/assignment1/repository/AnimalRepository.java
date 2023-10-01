package via.sdj3.assignment1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import via.sdj3.assignment1.entity.Animal;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    //no need to define an implementation here, since JPA does it for you based on method name
    //pretty cool ngl
    List<Animal> findByDateReceived(LocalDate date);

    List<Animal> findByOrigin(String origin);
}
