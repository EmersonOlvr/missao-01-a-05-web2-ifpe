package br.ifpe.web2.missoes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="local_eventos")
public class LocalEvento {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	@Column(length=50)
	private String nome;
	@Column(length=100)
	private String endereco;
	@Column(length=400)
	private String linkGoogleMaps;
	private Integer capacidade;
	private Boolean estaAberto;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getLinkGoogleMaps() {
		return linkGoogleMaps;
	}
	public void setLinkGoogleMaps(String linkGoogleMaps) {
		this.linkGoogleMaps = linkGoogleMaps;
	}
	public Integer getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}
	public Boolean getEstaAberto() {
		return estaAberto;
	}
	public void setEstaAberto(Boolean estaAberto) {
		this.estaAberto = estaAberto;
	}
	
}
