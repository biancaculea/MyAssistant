package lucru.assistent.Actions;

import lucru.assistent.Model.Tichet;
import lucru.assistent.Repositories.MyTichetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

//@Service
public class TichetService {
    @Autowired
    MyTichetRepository   myTichetRepository;

    public void save(Tichet tichet){
        myTichetRepository.save(tichet);
    }

    @Transactional
    public void showData(){
        System.out.println("=====================Retrieve Companies from Database:====================");
        List<Tichet> tichetLst = myTichetRepository.findAll();
        System.out.println("=====================Show All Companies on console:====================");
        tichetLst.forEach(System.out::println);;
    }

    public void deleteAll(){
        myTichetRepository.deleteAll();
    }
}