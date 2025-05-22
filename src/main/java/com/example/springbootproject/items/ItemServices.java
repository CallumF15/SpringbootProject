package com.example.springbootproject.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServices {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    public Item addItem(Item item) {
        // You could add validation or other logic here before saving
        return itemRepository.save(item);
    }

    public Optional<Item> updateItem(Long id, Item itemDetails) {
        return itemRepository.findById(id).map(item -> {
            item.setName(itemDetails.getName());
            item.setDescription(itemDetails.getDescription());
            item.setPrice(itemDetails.getPrice());
            return itemRepository.save(item);
        });
    }

    public boolean deleteItem(Long id) {
        return itemRepository.findById(id).map(item -> {
            itemRepository.delete(item);
            return true;
        }).orElse(false);
    }

    public List<Item> searchItemsByName(String keyword) {
        return itemRepository.findByNameContainingIgnoreCase(keyword);
    }
}
