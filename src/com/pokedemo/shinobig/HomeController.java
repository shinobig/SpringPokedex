package com.pokedemo.shinobig;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HomeController {
AllPokemons allPokemons;

@RequestMapping("/")
public String showPage(){
//allPokemons = new AllPokemons();

  System.out.println("Fetching all pokemon");

  return "main-menu";


}

}
