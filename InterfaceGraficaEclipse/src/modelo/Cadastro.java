package modelo;



public class Cadastro {
	
	//atributos
	private String login;
	private String senha;
	private String nome;
	private String sexo;
	
	
	//CONSTRUTORES
	public Cadastro(String login,
			String senha,
			String nome,
			String sexo) {
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.sexo = sexo;
	}
	
	//M�TODOS
	public String getLogin() {
		return this.login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return this.sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String toString() {
		return "Login: " + getLogin() + " " + 
	    "Nome: " + getNome() + " " + 
	    "Sexo: " + getSexo() ;
	}
	
		
	
}


	

