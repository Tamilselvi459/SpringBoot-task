package com.example.Ecommerce.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Item {

    @NotNull(message = "Id is required")
    int id;      // id is primary Key , not null
    @NotBlank(message = "Name is required")
    String name;   // Item Name , not blank
    @NotBlank(message = "Description is required")
    String description; // Item Description , not blank

    public int getId() { return id; }
    public void setId(int id){ this.id = id; }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }

    public String getDescription(){ return description; }
    public void setDescription(String description){ this.description = description; }







}
