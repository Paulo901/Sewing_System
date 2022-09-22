package com.api.Sewing_System.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.Sewing_System.Models.HistoricModel;
import com.api.Sewing_System.Repositories.HistoricRepository;

@Service
public class HistoricService {
    final HistoricRepository historicRepository;

    public HistoricService(HistoricRepository historicRepository) {
        this.historicRepository = historicRepository;
    }
    @Transactional
    public HistoricModel save(HistoricModel historicModel) {return historicRepository.save(historicModel);}
    public List<HistoricModel> findAll() {
        return historicRepository.findAll();
    }
    @Transactional
    public void delete(HistoricModel historicModel) {
        historicRepository.delete(historicModel);
    }
    public Optional<HistoricModel> findById(Long id) {
        return historicRepository.findById(id);
    }

}
