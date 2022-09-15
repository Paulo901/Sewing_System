package com.api.Sewing_System.Service;

import com.api.Sewing_System.Models.ItemsModel;
import com.api.Sewing_System.Repositories.ItemRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ItemService {

    final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    @Transactional
    public ItemsModel save(ItemsModel itemsModel) {return itemRepository.save(itemsModel);}
    public List<ItemsModel> findAll() {
        return itemRepository.findAll();
    }
    @Transactional
    public void delete(ItemsModel itemsModel) {
        itemRepository.delete(itemsModel);
    }
    public Optional<ItemsModel> findById(UUID id) {
        return itemRepository.findById(id);
    }
}
