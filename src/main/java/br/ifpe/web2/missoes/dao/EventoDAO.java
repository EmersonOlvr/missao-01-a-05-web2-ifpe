package br.ifpe.web2.missoes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ifpe.web2.missoes.model.Evento;
import br.ifpe.web2.missoes.model.LocalEvento;

public interface EventoDAO extends JpaRepository<Evento, Integer> {

	@Query("SELECT e FROM Evento e WHERE e.nome LIKE %:nome%")
	public List<Evento> findByNome(String nome);
	
	@Query("SELECT e FROM Evento e WHERE e.localEvento=:localEvento")
	public List<Evento> findByLocalEvento(LocalEvento localEvento);
	
}
