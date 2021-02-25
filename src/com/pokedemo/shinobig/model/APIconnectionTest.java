package com.pokedemo.shinobig.model;

import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class APIconnectionTest {

  @org.junit.jupiter.api.Test
  void getAllMappedPokemon() {
    APIconnection apIconnection = new APIconnection();
    Assert.notEmpty(apIconnection.getAllMappedPokemon());
  }

  @org.junit.jupiter.api.Test
  void setAllMappedPokemon() {
  }
}