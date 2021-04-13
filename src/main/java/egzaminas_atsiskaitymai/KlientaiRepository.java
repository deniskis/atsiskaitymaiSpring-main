package egzaminas_atsiskaitymai;

import org.springframework.data.repository.CrudRepository;

public interface KlientaiRepository extends CrudRepository<Klientai, Integer> {

	Klientai findByPav(String string);

}
