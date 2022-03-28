package phone_number_ajax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phone_number_ajax.model.Smartphone;

@Repository
public interface ISmartphoneRepository extends JpaRepository<Smartphone, Long> {
}
