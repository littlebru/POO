package br.com.fatec.modelo;

public class Pet {
	private String nome;
	private int caracteristica;
	private String genero;
	private String categoria;
	private String raca;
		
	public Pet(String nome, int caracteristica, String genero, String categoria, String raca) {
		this.nome = nome;
		this.caracteristica = caracteristica;
		this.genero = genero;
		this.categoria = categoria;
		this.raca = raca;
	}
	
	public Pet() {
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	public String getRaca() {
		return raca;
	}
	
	public void setGenero(int identificador) {
		switch(identificador) {
			case 1:
				this.genero = "FEMEA";
				break;
			case 2:
				this.genero = "MACHO";
				break;
		}
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(int identificador) {
			switch(identificador) {
			case 1:
				this.categoria = "CANINO";
				break;
			case 2:
				this.categoria = "FELINO";
				break;
			case 3:
				this.categoria = "OUTROS";
				break;
		}
	}
	
	public String getGenero() {
		return genero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(int caracteristica) {
		this.caracteristica = caracteristica;
	}

	String dog[] = {"BEAGLE","BULDOGUE","CHIHUAHUA","GOLDEN-RETRIVER","LABRADOR","PINTSCHER","POODLE","SHIH-TZU","VIRA-LATA","OUTROS"};
	String gato[] = {"GATO-DE-BENGALA", "MAINE COON", "PERSA", "SIAMES","OUTROS"};
	
	public String[] getListaDog() {
		return dog;
	}
	public String[] getListaGato() {
		return gato;
	}
	
	//___________METODOS____________

	public void listaDog() {
		System.out.println("\n___RAÇAS___\n");
		int d = dog.length;
		for(int t = 0; t < d; t++) {
			System.out.printf("[%d] %s\n", t+1, dog[t]);
		}
		System.out.print("OPCAO: ");
	}
	
	public void listaGato() {
		System.out.println("\n___RAÇAS___\n");
		int g = gato.length;
		for(int t = 0; t < g; t++) {
			System.out.printf("[%d] %s\n", t+1, gato[t]);
		}
		System.out.print("OPCAO: ");
	}
	
	public void imprimePet() {
		System.out.println("-------------------------");
		System.out.printf("NOME: %s \n", nome);
		System.out.printf("RAÇA: %s \n", raca);
		System.out.printf("GÊNERO: %s \n", genero);
		System.out.printf("CATEGORIA: %s \n", categoria);
	}
	
	
	

}
