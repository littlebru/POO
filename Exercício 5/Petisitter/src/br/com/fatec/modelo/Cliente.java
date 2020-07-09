package br.com.fatec.modelo;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa{
	public List<Pet> listaPets = new ArrayList<Pet>();
	
	public void setPet(Pet pet) {
		listaPets.add(pet);
	}
	
	public List getNomePet() {
		return listaPets;
	}
	
	public void imprimePets() {
		for(Pet pet: listaPets) {
			pet.imprimePet();
		}
	}
}
