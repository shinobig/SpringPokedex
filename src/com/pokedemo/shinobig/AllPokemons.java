package com.pokedemo.shinobig;

import com.pokedemo.shinobig.model.APIconnection;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class AllPokemons {

private final APIconnection apIconnection;
private Map<Integer, Pokemon> allPokemon;
private String nameTest = "hola";

  public AllPokemons(APIconnection apIconnection) {
    this.apIconnection = apIconnection;
    allPokemon = new LinkedHashMap<>();

    Map<Integer, Object> pokeMap = this.apIconnection.getAllMappedPokemon();

    for(int i = 0; i < pokeMap.size(); i++){
      JSONObject jsonObject = (JSONObject) pokeMap.get(i);
      Pokemon pokemonToAdd = new Pokemon(i,(String) jsonObject.get("url"), (String)jsonObject.get("name"));
      allPokemon.put(i, pokemonToAdd);
    }
  }

  public APIconnection getApIconnection() {
    return apIconnection;
  }

  public Map<Integer, Pokemon> getAllPokemon() {
    return allPokemon;
  }

  public void setAllPokemon(Map<Integer, Pokemon> allPokemon) {
    this.allPokemon = allPokemon;
  }

  public String getNameTest() {
    return nameTest;
  }

  public void setNameTest(String nameTest) {
    this.nameTest = nameTest;
  }
}
