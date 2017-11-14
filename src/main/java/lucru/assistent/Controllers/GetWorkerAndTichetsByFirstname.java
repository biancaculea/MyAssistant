package lucru.assistent.Controllers;



import lucru.assistent.Model.Person;
import lucru.assistent.Repositories.MyPersonRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.time.*;

import java.util.List;

@RestController
public class GetWorkerAndTichetsByFirstname {

    @Autowired
    MyPersonRepository myPersonRepository;


    @RequestMapping(value="/myAssistent/firstname/{firstname}", method= RequestMethod.GET)
    public List<Person> findByFirstname(@PathVariable("firstname") String firstname){
        List<Person> personLst = myPersonRepository.findByFirstname(firstname);
        //personLst.forEach(System.out::println);;
        //logger.info(firstname +"delivered at:"+ZonedDateTime.now());
        return personLst;
    }

}
