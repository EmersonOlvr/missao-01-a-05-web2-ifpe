package br.ifpe.web2.missao02;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="eventos")
public class Evento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	private String nome;
	private String descricao;
	private Date dataRealizacao;
	private Integer maximoConvidados;
	private String nomeResponsavel;
	private String telefoneResponsavel;
	private Integer duracaoHoras;
	
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataRealizacao() {
		return dataRealizacao;
	}
	public void setDataRealizacao(Date dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}
	public Integer getMaximoConvidados() {
		return maximoConvidados;
	}
	public void setMaximoConvidados(Integer maximoConvidados) {
		this.maximoConvidados = maximoConvidados;
	}
	public String getNomeResponsavel() {
		return nomeResponsavel;
	}
	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}
	public String getTelefoneResponsavel() {
		return telefoneResponsavel;
	}
	public void setTelefoneResponsavel(String telefoneResponsavel) {
		this.telefoneResponsavel = telefoneResponsavel;
	}
	public Integer getDuracaoHoras() {
		return duracaoHoras;
	}
	public void setDuracaoHoras(Integer duracaoHoras) {
		this.duracaoHoras = duracaoHoras;
	}
	
}
