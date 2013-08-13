package model;

import java.sql.Date;

public class Usuarios {
	private Date dataAtualizacao;
	private Date dataCadastro;
	private String respostaSecreta;
	private String perguntaSecreta;
	private String nome;
	private String senha;
	private String login;
	private String email;
	private Integer codUsuario;
	
	public Usuarios () {
		
	}
	
	public Usuarios (Date dataAtualizacao, Date dataCadastro, String respostaSecreta, String perguntaSecreta, String nome, String senha, String login, String email, Integer codUsuario) {
		this.dataAtualizacao = dataAtualizacao;
		this.dataCadastro = dataCadastro;
		this.respostaSecreta = respostaSecreta;
		this.perguntaSecreta = perguntaSecreta;
		this.nome = nome;
		this.senha = senha;
		this.login = login;
		this.email = email;
		this.codUsuario = codUsuario;
	}
		
	public Date getDataAtualizacao() {
		return this.dataAtualizacao;
	}
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	public Date getDataCadastro() {
		return this.dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getRespostaSecreta() {
		return this.respostaSecreta;
	}
	public void setRespostaSecreta(String respostaSecreta) {
		this.respostaSecreta = respostaSecreta;
	}
	public String getPerguntaSecreta() {
		return this.perguntaSecreta;
	}
	public void setPerguntaSecreta(String perguntaSecreta) {
		this.perguntaSecreta = perguntaSecreta;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	
	public String getSenha() {
		return this.senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getLogin() {
		return this.login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getCodUsuario() {
		return this.codUsuario;
	}
	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}
	public void setNewCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}
	
}