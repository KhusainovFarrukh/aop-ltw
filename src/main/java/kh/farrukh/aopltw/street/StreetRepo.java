package kh.farrukh.aopltw.street;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreetRepo extends JpaRepository<StreetEntity, Long> {

}
