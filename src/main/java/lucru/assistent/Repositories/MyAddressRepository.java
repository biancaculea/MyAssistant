package lucru.assistent.Repositories;

import lucru.assistent.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  MyAddressRepository  extends JpaRepository<Address, Integer> {
}
