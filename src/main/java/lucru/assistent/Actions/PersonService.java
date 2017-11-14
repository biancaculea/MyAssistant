package lucru.assistent.Actions;

import lucru.assistent.Model.Person;
import lucru.assistent.Repositories.MyPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

//@Service
public class PersonService {
    @Autowired
    MyPersonRepository   myPersonRepository;

    public void save(Person person){
        myPersonRepository.save(person);
    }

    @Transactional
    public void showData(){
        System.out.println("=====================Retrieve Companies from Database:====================");
        String firstname="George";
        List<Person> personLst = myPersonRepository.findByFirstname(firstname);
        System.out.println("=====================Show All Companies on console:====================");
        personLst.forEach(System.out::println);;
    }

    public void deleteAll(){
        myPersonRepository.deleteAll();
    }
}

