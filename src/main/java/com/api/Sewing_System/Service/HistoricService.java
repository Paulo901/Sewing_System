package com.api.Sewing_System.Service;

import com.api.Sewing_System.Models.ClientModel;
import com.api.Sewing_System.Models.HistoricModel;
import com.api.Sewing_System.Repositories.HistoricRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    public Optional<HistoricModel> findById(UUID id) {
        return historicRepository.findById(id);
    }

}
