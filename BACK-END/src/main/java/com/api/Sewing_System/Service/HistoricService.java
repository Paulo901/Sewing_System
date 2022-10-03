package com.api.Sewing_System.Service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import com.api.Sewing_System.Properties.historic.State;
import org.springframework.stereotype.Service;
import com.api.Sewing_System.Models.Historic;
import com.api.Sewing_System.Repositories.HistoricRepository;


@Service
public class HistoricService {
    final HistoricRepository historicRepository;

    public HistoricService(HistoricRepository historicRepository) {
        this.historicRepository = historicRepository;
    }
    @Transactional
    public Historic save(Historic historicModel) {return historicRepository.save(historicModel);}
    public List<Historic> findAll() {
        return historicRepository.findAll();
    }
    @Transactional
    public void delete(Historic historicModel) {
        historicRepository.delete(historicModel);
    }
    public Optional<Historic> findById(Long id) {
        return historicRepository.findById(id);
    }

    public State selectState (String state){

            switch (state){
                case "AC" -> {return State.AC;}
                case "AM" -> {return State.AM;}
                case "AP" -> {return State.AP;}
                case "PA" -> {return State.PA;}
                case "RO" -> {return State.RO;}
                case "RR" -> {return State.RR;}
                case "TO" -> {return State.TO;}

                case "CE" -> {return State.CE;}
                case "MA" -> {return State.MA;}
                case "AL" -> {return State.AL;}
                case "BA" -> {return State.BA;}
                case "PI" -> {return State.PI;}
                case "RN" -> {return State.RN;}
                case "PE" -> {return State.PE;}
                case "PB" -> {return State.PB;}
                case "SE" -> {return State.SE;}

                case "MT" -> {return State.MT;}
                case "MS" -> {return State.MS;}
                case "GO" -> {return State.GO;}
                case "DF" -> {return State.DF;}

                case "MG" -> {return State.MG;}
                case "ES" -> {return State.ES;}
                case "SP" -> {return State.SP;}
                case "RJ" -> {return State.RJ;}

                case "PR" -> {return State.PR;}
                case "RS" -> {return State.RS;}
                case "SC" -> {return State.SC;}

                default -> {return State.NENHUM;}

            }
    }
}
