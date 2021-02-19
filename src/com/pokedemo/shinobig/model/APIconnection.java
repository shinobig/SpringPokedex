package com.pokedemo.shinobig.model;

import com.pokedemo.shinobig.ThreadColor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class APIconnection {

  private Map<Integer, Object> allMappedPokemon;

  public APIconnection() {

    try {

      URL url = new URL("https://pokeapi.co/api/v2/pokemon/?offset=0&limit=150");
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      allMappedPokemon = new LinkedHashMap<>();
      connection.setRequestMethod("GET");

      connection.setDoOutput(true);

      BufferedReader inputReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));


      StringBuilder sb = new StringBuilder();
      String line;

      while ((line = inputReader.readLine()) != null) {
        sb.append(line);
      }
      try {
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(sb.toString());
        JSONArray pokeArray = (JSONArray) json.get("results");
        Map<Integer, String> bulb = new LinkedHashMap<>();

        for (int i = 0; i < pokeArray.size(); i++) {
          JSONObject pokemon = (JSONObject) pokeArray.get(i);
          allMappedPokemon.put(i, pokemon);
        }

      } catch (ParseException e) {
        e.printStackTrace();
      }
      inputReader.close();

    } catch (IOException e) {
      System.out.println("Unable to connect to pokemon API: " + e.getMessage());
    }

  }

  public Map<Integer, Object> getAllMappedPokemon() {
    return allMappedPokemon;
  }

  public void setAllMappedPokemon(Map<Integer, Object> allMappedPokemon) {
    this.allMappedPokemon = allMappedPokemon;
  }
}
