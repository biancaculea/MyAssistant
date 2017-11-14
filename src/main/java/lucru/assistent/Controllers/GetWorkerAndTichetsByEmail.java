package lucru.assistent.Controllers;


import lucru.assistent.Model.Person;
import lucru.assistent.Repositories.MyPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetWorkerAndTichetsByEmail {

    @Autowired
    MyPersonRepository myPersonRepository;
    @RequestMapping(value="/myAssistent/email/{email}/", method= RequestMethod.GET )
    List<Person> findByEmail(@PathVariable("email") String email){
        List<Person> listByEmail= myPersonRepository.findByEmail(email);
        return listByEmail;
    }
}
