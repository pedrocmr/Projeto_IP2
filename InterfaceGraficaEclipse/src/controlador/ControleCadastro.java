package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import modelo.Cadastro;


public class ControleCadastro {


	static FileWriter fileWriter;
	static FileReader fileReader;
	static BufferedReader leitor;
	static BufferedWriter escrever;
	static PrintWriter pwriter;
	Cadastro cadastro;
	
	//construtor
		public ControleCadastro(Cadastro cadastro) {
			this.cadastro = cadastro;
			
		}
		public ControleCadastro() {}
		
	
	public void dadoCadastro(Cadastro cadastro) {
		try {
			File arquivo = new File("src/arquivo.txt");
			String linhaDados;
			fileWriter = new FileWriter(arquivo,true);
			escrever = new BufferedWriter(fileWriter);
			linhaDados = cadastro.getLogin() + "," + cadastro.getSenha() + "," + cadastro.getNome() + "," + cadastro.getSexo() ;			
			escrever.write(linhaDados + "\n");
			//escrever.append("\n");
		
			escrever.close();
			fileWriter.close();
			
			fileReader = new FileReader(arquivo);
			leitor = new BufferedReader(fileReader);
			String linha = leitor.readLine();
			
			while(linha != null) {
				System.out.println(linha);
				linha = leitor.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
		
	
	
	
	
	
}
