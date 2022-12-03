package com.example.javaapi;

import java.util.List;
import java.util.Optional;
import java.util.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = "application/json")
class WatchController {

  @Autowired
  private WatchRepository watchRepository;

  @GetMapping("/watch")
  List<Watch> returnAllWatches() {
    return watchRepository.findAll();
  }

  @GetMapping("/watch/{id}")
  ResponseEntity<Watch> returnOneWatchById(@PathVariable(value = "id") long id) {
    Optional<Watch> watch = watchRepository.findById(id);
    if (watch.isPresent()) {
      return ResponseEntity.ok().body(watch.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/watch")
  Watch saveNewWatch(@Validated @RequestBody Watch watch) {
    return watchRepository.save(watch);
  }


  
  // @PostMapping("/checkout")
  // String singleWatchIdUsedToCalculateTotalPrice(@Validated @RequestBody Long watchIds) {


  @PostMapping("/checkout")
  String listOfWatchIdsUsedToCalculateTotalPrice(@Validated @RequestBody List<Long> watchIds) {
    int totalPrice = 0;
    int numberofRolex = 0;
    int numberofMichaelKors = 0;
    int totalDiscount = 0;
    for (int i = 0; i < watchIds.size(); i++) {
      Optional<Watch> watch = watchRepository.findById(watchIds.get(i));
      if (watch.isPresent()) {
        totalPrice += watch.get().getPrice();
      }
      if (watchRepository.findById(watchIds.get(i)).get().getName().equals("Rolex")) {
        numberofRolex++;
      }
      if (watchRepository.findById(watchIds.get(i)).get().getName().equals("Michael Kors")) {
        numberofMichaelKors++;
      }
      if (numberofRolex == 3) {
        totalPrice -= 100;
        totalDiscount += 100;
        numberofRolex = 0;
      }
      if (numberofMichaelKors == 2) {
        totalPrice -= 40;
        totalDiscount += 40;
        numberofMichaelKors = 0;
      }
    }
    

    JSONObject json = new JSONObject();
    json.put("price", totalPrice);

    if (totalDiscount > 0) {
      json.put("discount", totalDiscount);
    }

    if (numberofRolex == 2) {
      json.put("rolex_message", "You get a free Rolex!");
    }
    if (numberofMichaelKors == 1) {
      json.put("mk_message", "One more Michael Kors and get 40 off!");
    } 

    json.put("message", "Thank you for shopping with us!");

    String jsonString = json.toString();
    return jsonString;
  }

}

// ./mvnw clean spring-boot:run