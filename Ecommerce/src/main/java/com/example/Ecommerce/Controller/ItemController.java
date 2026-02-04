package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Exception.ItemAlreadyExistsException;
import com.example.Ecommerce.Model.Item;
import com.example.Ecommerce.Service.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping("/add-item")   // REST API  to add item
    public ResponseEntity addItem(@Valid @RequestBody Item item){
        try{
            Item savedItem = itemService.addItem(item);
            return new ResponseEntity<>(savedItem,HttpStatus.CREATED);
        }catch(ItemAlreadyExistsException e){
            return new ResponseEntity<>(e.getMessage() , HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/get-item/{id}")   // REST API to get item
    public ResponseEntity getItem(@PathVariable int id){
        Optional<Item> item = itemService.findById(id);
        if(item.isPresent()){
            return new ResponseEntity<>(item.get() , HttpStatus.FOUND);
        }
        return new ResponseEntity<>("Item Not Present" , HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update-item")  // REST API to Update the name , description with given id
    public ResponseEntity updateDescription(@RequestParam int id ,@RequestParam String newName , @RequestParam String newDescription){
        String text = itemService.updateDescription(id,newName,newDescription);
        return new ResponseEntity(text , HttpStatus.OK);
    }
}
