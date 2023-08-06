package com.example.services;

import com.example.modals.Item;
import com.example.modals.Person;
import com.example.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findByItemName(String itemName){
        return itemRepository.findByItemName(itemName);
    }

    public List<Item> findByOwner(Person owner){
        return itemRepository.findByOwner(owner);
    }
}
