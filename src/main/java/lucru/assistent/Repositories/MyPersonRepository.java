package lucru.assistent.Repositories;

import lucru.assistent.Model.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface MyPersonRepository extends JpaRepository<Person,Integer> {
    List<Person> findByEmail(String email);
    List<Person> findById(Integer id);
    List<Person> findByFirstname(String firstname);
    List<Person> findPersonByLastname(String lastname);

    @Query("select p from Person p where p.lastname=:lastname")
    Stream<Person> findByLastnameReturnStream(@Param("lastname") String lastname);


}
