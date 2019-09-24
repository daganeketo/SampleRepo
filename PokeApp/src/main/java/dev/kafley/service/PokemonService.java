package dev.kafley.service;

import java.util.ArrayList;
import java.util.List;

import dev.kafley.db.MyFakeDb;
import dev.kafley.model.Pokemon;

public class PokemonService {
	
	public static Pokemon getPokemon(int id) {
		return MyFakeDb.team.get(id);
	}
	
	public static void addPokemon(Pokemon p) {
		MyFakeDb.team.put(p.getId(), p);
	}
	
	public static List<Pokemon> getAllPokemon(){
		return new ArrayList<Pokemon>(MyFakeDb.team.values());
	}

}
