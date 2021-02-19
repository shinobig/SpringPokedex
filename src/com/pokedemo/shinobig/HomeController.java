package com.pokedemo.shinobig;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HomeController {
  AllPokemons allPokemons;

  public HomeController(AllPokemons allPokemons) {
    this.allPokemons = allPokemons;
  }

  @RequestMapping("/")
  public String showPage() {

    System.out.println("Fetching all pokemon");

    return "main-menu";


  }

}
