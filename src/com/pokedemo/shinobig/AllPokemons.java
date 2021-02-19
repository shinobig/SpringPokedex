package com.pokedemo.shinobig;

import com.pokedemo.shinobig.model.APIconnection;

import java.util.Map;

public class AllPokemons {

APIconnection apIconnection;

  public AllPokemons(APIconnection apIconnection) {
    this.apIconnection = apIconnection;

    Map<Integer, Object> test = this.apIconnection.getAllMappedPokemon();

    System.out.println(test.size());
  }
}
