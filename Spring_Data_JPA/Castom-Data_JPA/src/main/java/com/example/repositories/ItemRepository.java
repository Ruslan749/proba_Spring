package com.example.repositories;

import com.example.modals.Item;
import com.example.modals.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {
    List<Item> findByItemName(String itemName);
    List<Item> findByOwner(Person owner);
}
