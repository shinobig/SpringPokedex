package com.pokedemo.shinobig;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class Pokemon {

  private String name;
  private String mainImageUrl;
  private String icon;
  private int id;
  private List<String> types;
  private List<String> abilities;
  private String backgroundColor;

  Pokemon(int id, String url, String name) {

    try {
      URL pokemonUrl = new URL(url);
      HttpURLConnection connection = (HttpURLConnection) pokemonUrl.openConnection();
      connection.setRequestMethod("GET");
      BufferedReader inputReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      StringBuilder sb = new StringBuilder();
      String line;
      while ((line = inputReader.readLine()) != null) {
        sb.append(line);
      }


      try {
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(sb.toString());

        // Set properties
        this.id = id;
        this.name = name;
        this.mainImageUrl = this.getImageUrlFromJson(json);
        this.types = this.getTypesFromJson(json);
        this.abilities = this.getAbilitiesFromJson(json);
        this.icon = this.getIconFromJson(json);

      } catch (ParseException e) {
        e.printStackTrace();
      }


    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      System.out.println("Error getting this pokemon" + e.getMessage());
    }


  }

  private String getImageUrlFromJson(JSONObject object) {
    JSONObject imagesJson = (JSONObject) object.get("sprites");
    JSONObject other = (JSONObject) imagesJson.get("other");
    JSONObject otherOfficialArtwork = (JSONObject) other.get("official-artwork");
    return (String) otherOfficialArtwork.get("front_default");
  }

  private ArrayList<String> getTypesFromJson(JSONObject jsonObject) {
    ArrayList<String> typesArray = new ArrayList<>();
    JSONArray types = (JSONArray) jsonObject.get("types");

    for (int i = 0; i < types.size(); i++) {
      JSONObject type = (JSONObject) types.get(i);
      JSONObject typeInfo = (JSONObject) type.get("type");
      typesArray.add((String) typeInfo.get("name"));
    }
    return typesArray;
  }

  private ArrayList<String> getAbilitiesFromJson(JSONObject jsonObject) {
    ArrayList<String> abilitiesArr = new ArrayList<>();
    JSONArray abilities = (JSONArray) jsonObject.get("abilities");
    for (Object object : abilities) {
      JSONObject ability = (JSONObject) ((JSONObject) object).get("ability");
      abilitiesArr.add((String) ability.get("name"));
    }
    return abilitiesArr;
  }

  private String getIconFromJson(JSONObject jsonObject) {
    JSONObject sprites = (JSONObject) jsonObject.get("sprites");
    JSONObject versions = (JSONObject) sprites.get("versions");
    JSONObject generation = (JSONObject) versions.get("generation-vii");
    JSONObject icons = (JSONObject) generation.get("icons");
    return (String) icons.get("front_default");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMainImageUrl() {
    return mainImageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.mainImageUrl = imageUrl;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getBackgroundColor() {
    return backgroundColor;
  }

  public void setBackgroundColor(String backgroundColor) {
    this.backgroundColor = backgroundColor;
  }

}
