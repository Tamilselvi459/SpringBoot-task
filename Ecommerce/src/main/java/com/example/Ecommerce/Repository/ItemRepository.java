package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Model.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ItemRepository {

    List<Item> itemList = new ArrayList<>();

    public void addItem(Item item){
        itemList.add(item);  // save item to list

    }

    public Optional<Item> findById(int id) {

        for(Item item : itemList){ // find item by using id
            if(item.getId() == id){
                // to avoid NullPointerExpection. I am using optional.
                return Optional.of(item);
            }

        }
        return Optional.empty();

    }

    public List<Item> getAllItems() {
        List<Item> allItemList = new ArrayList<>();
        for(Item item : itemList){
            allItemList.add(item);
        }
        return allItemList;
    }
}
