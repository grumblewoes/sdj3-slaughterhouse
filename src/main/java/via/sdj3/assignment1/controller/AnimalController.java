package via.sdj3.assignment1.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import via.sdj3.assignment1.entity.Animal;
import via.sdj3.assignment1.service.AnimalService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class AnimalController {
    private AnimalService animalService;

    public AnimalController(AnimalService animalService)
    {
        this.animalService = animalService;
    }

    @GetMapping(value="/animals/{registrationNum}")
    public ResponseEntity<Object> getAnimalById(@PathVariable("registrationNum") int registrationNum)
    {
        Optional<Animal> animal = animalService.getAnimalById(registrationNum);

        if (animal.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(animal.get(), HttpStatus.OK);
    }

    @GetMapping(value="/animals/date/{dateReceived}")
    public ResponseEntity<List<Animal>> getAnimalsByDateReceived(@PathVariable("dateReceived") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate dateReceived)
    {
        //not optional, since empty filtered queries generate empty lists, not null
        List<Animal> animals = animalService.getAnimalsByDateReceived(dateReceived);
        return new ResponseEntity<>(animals, HttpStatus.OK);
    }

    @GetMapping(value="/animals/origin/{origin}")
    public ResponseEntity<List<Animal>> getAnimalsByOrigin(@PathVariable("origin") String origin)
    {
        List<Animal> animals = animalService.getAnimalsByOrigin(origin);
        return new ResponseEntity<>(animals, HttpStatus.OK);
    }

    @PostMapping(value="/animals")
    public ResponseEntity<Object> addAnimal(@RequestBody Animal animal)
    {
        animalService.addAnimal(animal);
        return new ResponseEntity<>("Animal added.", HttpStatus.CREATED);
    }
}
