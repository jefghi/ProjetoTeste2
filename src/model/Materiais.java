package model;

public class Materiais {
	private Integer codMaterial;
	private Integer codIdioma;
	private Integer codTipoMaterial;
	private String titulo;
	private String subtitulo;
	private String descricao;
	
	public Materiais() {		
	
	}
	
	public Materiais(Integer codMaterial, Integer codIdioma, Integer codTipoMaterial, String titulo, String subtitulo, String descricao) {
		this.codMaterial = codMaterial;
		this.codIdioma = codIdioma;
		this.codTipoMaterial = codTipoMaterial;
		this.titulo = titulo;
		this.subtitulo = subtitulo;
		this.descricao = descricao;
	}
	
	public Integer getCodMaterial() {
		return codMaterial;
	}
	public void setCodMaterial(int codMaterial) {
		this.codMaterial = codMaterial;
	}
	public Integer getCodIdioma() {
		return codIdioma;
	}
	public void setCodIdioma(int codIdioma) {
		this.codIdioma = codIdioma;
	}
	public Integer getCodTipoMaterial() {
		return codTipoMaterial;
	}
	public void setCodTipoMaterial(int codTipoMaterial) {
		this.codTipoMaterial = codTipoMaterial;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getSubtitulo() {
		return subtitulo;
	}
	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
