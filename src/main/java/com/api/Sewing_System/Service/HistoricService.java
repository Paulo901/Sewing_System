package com.api.Sewing_System.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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

}
