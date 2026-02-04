package com.example.Ecommerce.Service;

import com.example.Ecommerce.Exception.ItemAlreadyExistsException;
import com.example.Ecommerce.Model.Item;
import com.example.Ecommerce.Repository.ItemRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    public Item addItem(@Valid Item item) {

        int id = item.getId();

        //checking Id is already present or not
        //If id is present means throwing Item AlreadyExistsException.

        Optional<Item> checkItem = itemRepository.findById(id);

        if(checkItem.isPresent()){
            throw new ItemAlreadyExistsException("Item with id "+ id +" is already exists");
        }
        else
        {
            itemRepository.addItem(item);
            return item;
        }
    }

    public Optional<Item> findById(int id) {

        return itemRepository.findById(id);
    }

    // updating the name and description using Id .

    public String updateDescription(int id,String newName , String newDescription) {
        Optional<Item> item = itemRepository.findById(id);
        if(item.isPresent()){
            Item getItem = item.get();
            getItem.setId(id);
            getItem.setName(newName);
            getItem.setDescription(newDescription);
            itemRepository.addItem(getItem);
            return "Item updated successfully";
        }
        return "Id Not Found";
    }
}
