package modelo;

public class Usuario {

	// ATRIBUTOS
	private String login;
	private String senha;
	private String nome;
	private String cpf;
	private String sexo;

	// CONSTRUTORES
	public Usuario(String login, String senha, String nome, String cpf, String sexo) {
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
	}

	public Usuario() {

	}

	// GETTERS E SETTERS
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	// M�TODOS
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

	@Override
	public String toString() {
		return "Login: " + getLogin() + " " + "Senha: " + getSenha() + " Nome: " + getNome() + " " + "CPF:" + getCpf() + " " + "Sexo: "
				+ getSexo();
	}

}
