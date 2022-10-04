package com.api.Sewing_System.Service;

import com.api.Sewing_System.Models.Discounts;
import com.api.Sewing_System.Repositories.DiscountsRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DiscountsService {

    final DiscountsRepository discountsRepository;

    public DiscountsService(DiscountsRepository discountsRepository) {
        this.discountsRepository = discountsRepository;
    }
    @Transactional
    public Discounts save(Discounts discountsModel) {return discountsRepository.save(discountsModel);}
    public List<Discounts> findAll() {
        return discountsRepository.findAll();
    }
    @Transactional
    public void delete(Discounts discountsModel) {
        discountsRepository.delete(discountsModel);
    }
    public Optional<Discounts> findById(Long id) {
        return discountsRepository.findById(id);
    }
}
