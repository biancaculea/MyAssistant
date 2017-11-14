package lucru.assistent.Repositories;
import lucru.assistent.Model.Tichet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface  MyTichetRepository extends  JpaRepository<Tichet,Integer> {
    List<Tichet> findByName(String name);
    List<Tichet> findByEmail(String email);

}
