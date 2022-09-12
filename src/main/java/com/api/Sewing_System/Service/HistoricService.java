package com.api.Sewing_System.Service;

import com.api.Sewing_System.Models.HistoricModel;
import com.api.Sewing_System.Repositories.HistoricRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class HistoricService {


    final HistoricRepository historicRepository;
    public HistoricService(HistoricRepository historicRepository) {
        this.historicRepository = historicRepository;
    }

    @Transactional
    public HistoricModel save(HistoricModel historicModel) {
        return historicRepository.save(historicModel);

    }
}
