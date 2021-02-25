package com.pokedemo.shinobig;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SinglePokemonController {

  private AllPokemons allPokemons;

  public SinglePokemonController(AllPokemons allPokemons) {
    this.allPokemons = allPokemons;
  }

  @RequestMapping(value = "pokemon", method = RequestMethod.GET)
  public String processPokemon(@RequestParam("name") String pokeName, Model pokemonModel) {

    Pokemon pokemonToDisplay = allPokemons.getPokemonByName(pokeName);
    pokemonModel.addAttribute("pokemonToDisplay", pokemonToDisplay);

//    String pokemonBefore;
//    String pokemonBeforeName;
//    String pokemonAfter;
//    String pokemonAfterName;

    Pokemon pokemonBefore;
    Pokemon pokemonAfter;


    if (pokeName.equals(allPokemons.getPokemonById(0).getName())) {
      pokemonBefore = allPokemons.getPokemonById(allPokemons.getAllPokemon().size() - 1);
    } else {
      pokemonBefore = allPokemons.getPokemonById(pokemonToDisplay.getId() - 1);
    }

    if(pokeName.equals(allPokemons.getPokemonById(allPokemons.getAllPokemon().size() - 1).getName())){
      pokemonAfter = allPokemons.getPokemonById(0);
    } else {
      pokemonAfter = allPokemons.getPokemonById(pokemonToDisplay.getId() + 1);
    }

    pokemonModel.addAttribute("pokemonBefore", pokemonBefore);
    pokemonModel.addAttribute("pokemonAfter", pokemonAfter);


    return "single-pokemon";
  }
}
