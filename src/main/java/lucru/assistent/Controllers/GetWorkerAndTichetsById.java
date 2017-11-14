package lucru.assistent.Controllers;


import lucru.assistent.Model.Person;
import lucru.assistent.Repositories.MyPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class GetWorkerAndTichetsById {

    @Autowired
    MyPersonRepository myPersonRepository;

    @RequestMapping(value="/myAssistent/id/{id}", method= RequestMethod.GET)
    List<Person> findById(@PathVariable("id") int id) {
        List<Person> listById =myPersonRepository.findById(id);
        return listById;
    }
}
