package com.api.Sewing_System.Service;

import com.api.Sewing_System.Models.DiscountsModel;
import com.api.Sewing_System.Repositories.DiscountsRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DiscountsService {

    final DiscountsRepository discountsRepository;

    public DiscountsService(DiscountsRepository discountsRepository) {
        this.discountsRepository = discountsRepository;
    }
    @Transactional
    public DiscountsModel save(DiscountsModel discountsModel) {return discountsRepository.save(discountsModel);}
    public List<DiscountsModel> findAll() {
        return discountsRepository.findAll();
    }
    @Transactional
    public void delete(DiscountsModel discountsModel) {
        discountsRepository.delete(discountsModel);
    }
    public Optional<DiscountsModel> findById(UUID id) {
        return discountsRepository.findById(id);
    }

}
