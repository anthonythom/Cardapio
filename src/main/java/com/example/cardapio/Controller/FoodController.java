package com.example.cardapio.Controller;

import com.example.cardapio.Food.Food;
import com.example.cardapio.Food.FoodRepository;
import com.example.cardapio.Food.FoodRequestDTO;
import com.example.cardapio.Food.FoodResponseDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("food")
public class FoodController {

  @Autowired
  private FoodRepository repository;

  @CrossOrigin(origins = "*", allowedHeaders = "*")
  @PostMapping
  public void saveFood(@RequestBody FoodRequestDTO data) {
    Food foodData = new Food(data);
    repository.save(foodData);
    return;
  }

  @CrossOrigin(origins = "*", allowedHeaders = "*")
  @GetMapping
  public List<FoodResponseDTO> getAll() {
    List<FoodResponseDTO> foodList = repository
      .findAll()
      .stream()
      .map(FoodResponseDTO::new)
      .toList();
    return foodList;
  }
}
