package via.sdj3.assignment1.service;

import org.springframework.stereotype.Service;
import via.sdj3.assignment1.entity.Animal;
import via.sdj3.assignment1.repository.AnimalRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    private AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository)
    {
        this.animalRepository = animalRepository;
    }

    public Optional<Animal> getAnimalById(int id) {return animalRepository.findById(id);}

    public List<Animal> getAnimalsByDateReceived(LocalDate date) {return animalRepository.findByDateReceived(date);}

    public List<Animal> getAnimalsByOrigin(String origin) {return animalRepository.findByOrigin(origin);}

    public void addAnimal(Animal animal) { animalRepository.save(animal); }
}
