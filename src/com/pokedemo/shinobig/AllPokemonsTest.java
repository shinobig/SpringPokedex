package com.pokedemo.shinobig;

import com.pokedemo.shinobig.model.APIconnection;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AllPokemonsTest {


  private final APIconnection apIconnection;
  private Map<Integer, Pokemon> allPokemon;

  public AllPokemonsTest(APIconnection apIconnection) {
    this.apIconnection = apIconnection;
    allPokemon = new LinkedHashMap<>();

    Map<Integer, Object> pokeMap = this.apIconnection.getAllMappedPokemon();

    for(int i = 0; i < pokeMap.size(); i++){
      JSONObject jsonObject = (JSONObject) pokeMap.get(i);
      Pokemon pokemonToAdd = new Pokemon(i,(String) jsonObject.get("url"), (String)jsonObject.get("name"));
      allPokemon.put(i, pokemonToAdd);
    }
  }

  
}