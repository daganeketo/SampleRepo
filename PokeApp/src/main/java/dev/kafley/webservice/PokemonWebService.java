package dev.kafley.webservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.kafley.model.Pokemon;
import dev.kafley.service.PokemonService;

public class PokemonWebService {
	
	public static ObjectMapper om = new ObjectMapper();
	
	public static void getPokemon(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		//System.out.println(id);
		
		Pokemon p = PokemonService.getPokemon(id);
		// Some code/ some logic
		
		try {
			String pokemonJSON = om.writeValueAsString(p);
			response.getWriter().append(pokemonJSON);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void addPokemon(HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		
		
		Pokemon p = (Pokemon) om.readValue(request.getInputStream(), Pokemon.class);
		PokemonService.addPokemon(p);
		
		try {
			response.getWriter().append(om.writeValueAsString(p));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getAllPokemon(HttpServletRequest request, HttpServletResponse response) {
		
		List<Pokemon> polkmans = PokemonService.getAllPokemon();
		try {
			response.getWriter().append(om.writeValueAsString(polkmans));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
