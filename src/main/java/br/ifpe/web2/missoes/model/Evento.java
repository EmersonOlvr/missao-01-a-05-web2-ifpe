package br.ifpe.web2.missoes.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="eventos")
public class Evento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;

	@NotBlank(message = "Insira um nome válido.")
	private String nome;
	
	private String descricao;
	
	@ManyToOne @NotNull(message = "O local do evento é obrigatório.")
	private LocalEvento localEvento;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "A data não pode ser vazia.")
	@FutureOrPresent(message = "A data deve ser igual ou maior que a data atual.")
	private Date dataRealizacao;
	
	@Min(value = 11, message = "A quantidade máxima de convidados deve ser maior que 10.")
	@NotNull(message = "Insira a quantidade máxima de convidados.")
	private Integer maximoConvidados;
	
	private String nomeResponsavel;
	private String telefoneResponsavel;
	
	@Min(value = 1, message = "A duração máxima de horas deve ser maior que 0.")
	@NotNull(message = "Insira a duração em horas.")
	private Double duracaoHoras;
	
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
	public LocalEvento getLocalEvento() {
		return localEvento;
	}
	public void setLocalEvento(LocalEvento localEvento) {
		this.localEvento = localEvento;
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
	public Double getDuracaoHoras() {
		return duracaoHoras;
	}
	public void setDuracaoHoras(Double duracaoHoras) {
		this.duracaoHoras = duracaoHoras;
	}
	
	@Override
	public String toString() {
		return "Evento [codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao + ", localEvento="
				+ localEvento + ", dataRealizacao=" + dataRealizacao + ", maximoConvidados=" + maximoConvidados
				+ ", nomeResponsavel=" + nomeResponsavel + ", telefoneResponsavel=" + telefoneResponsavel
				+ ", duracaoHoras=" + duracaoHoras + "]";
	}
	
}
