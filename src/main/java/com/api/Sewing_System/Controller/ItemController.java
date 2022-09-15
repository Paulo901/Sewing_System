package com.api.Sewing_System.Controller;

import com.api.Sewing_System.Models.ItemsModel;
import com.api.Sewing_System.Service.ItemService;
import com.api.Sewing_System.dtos.ItemDto;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/items")
public class ItemController {

    final ItemService itemService;

    public ItemController (ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<Object> saveItem(@RequestBody @Valid ItemDto itemDto){
        var itemsModel = new ItemsModel();
        BeanUtils.copyProperties(itemDto, itemsModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.save(itemsModel));
    }
    @GetMapping
    public ResponseEntity<List<ItemsModel>> getAllItem(){
        return ResponseEntity.status(HttpStatus.OK).body(itemService.findAll());
    }
    @GetMapping("/{iditem}")
    public ResponseEntity<Object> getOneItem(@PathVariable(value = "iditem" ) UUID id ) {
        Optional<ItemsModel> itemsModelOptional = itemService.findById(id);
        if (!itemsModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item Not Found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(itemsModelOptional.get());
    }
    @DeleteMapping("/{iditem}")
    public ResponseEntity<Object> deleteIitem(@PathVariable(value = "iditem" ) UUID id ) {
        Optional<ItemsModel> itemsModelOptional = itemService.findById(id);
        if (!itemsModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item Not Found!");
        }
        itemService.delete(itemsModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(itemsModelOptional.get() + " deleted successfully");
    }
    @PutMapping("/{iditem}")
    public ResponseEntity<Object> updateItem(@PathVariable(value = "iditem" ) UUID id,
                                             @RequestBody @Valid ItemDto itemDto) {
        Optional<ItemsModel> itemsModelOptional = itemService.findById(id);
        if (!itemsModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("item Not Found!");
        }
        var itemsModel = new ItemsModel();
        BeanUtils.copyProperties(itemDto, itemsModel);
        itemsModel.setIdItem(itemsModelOptional.get().getIdItem());
        return ResponseEntity.status(HttpStatus.OK).body(itemService.save(itemsModel));
    }
}
