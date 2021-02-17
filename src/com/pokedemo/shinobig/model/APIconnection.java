package com.pokedemo.shinobig.model;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Objects;

public class APIconnection {

  public APIconnection() {

    try {


      // First connection
      URL url = new URL("https://pokeapi.co/api/v2/pokemon/");
      BufferedReader inputStream = new BufferedReader(new InputStreamReader(url.openStream()));
      String line = "";

      while (line != null) {
        line = inputStream.readLine();
        System.out.println(line);
      }

      JSONParser jsonParser = new JSONParser();

      try{
      Objects obj = (Objects) jsonParser.parse(inputStream);

      }catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      } catch (ParseException e) {
        e.printStackTrace();
      }


    } catch (IOException e) {
      System.out.println("Unable to connect to pokemon API: " + e.getMessage());
    }

  }
}
