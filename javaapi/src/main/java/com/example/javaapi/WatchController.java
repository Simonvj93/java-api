package com.example.javaapi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
    if(watch.isPresent()) {
      return ResponseEntity.ok().body(watch.get());
    } 
    else {
        return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/watch")
  Watch saveNewWatch(@Validated @RequestBody Watch watch) {
    return watchRepository.save(watch);
  }


}