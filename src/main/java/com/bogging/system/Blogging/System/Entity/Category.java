package com.bogging.system.Blogging.System.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //  @JsonProperty("name") //  It's instrumental when you want to rename the field in the JSON output, especially when the Java field name and the JSON property name aren't identical
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonIgnore  // Prevent recursion
    private List<Subcategory> subcategories;

    //  Getters and setters
}

