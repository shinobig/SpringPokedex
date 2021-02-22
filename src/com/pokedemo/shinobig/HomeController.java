package com.pokedemo.shinobig;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HomeController {
  AllPokemons allPokemons;

  public HomeController(AllPokemons allPokemons) {
    this.allPokemons = allPokemons;
  }

  @RequestMapping("/")
  public String showPage(Model pokemonModel) {

    System.out.println("Fetching all pokemon");

    pokemonModel.addAttribute("allPokemons", allPokemons);

    return "main-menu";


  }

}
