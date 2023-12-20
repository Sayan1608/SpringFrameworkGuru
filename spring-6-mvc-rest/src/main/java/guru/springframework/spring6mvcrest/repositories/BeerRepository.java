package guru.springframework.spring6mvcrest.repositories;

import guru.springframework.spring6mvcrest.entities.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeerRepository extends JpaRepository<Beer, UUID> {
}
