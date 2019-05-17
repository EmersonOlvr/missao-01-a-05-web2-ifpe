package br.ifpe.web2.missoes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.web2.missoes.model.Evento;

public interface EventoDAO extends JpaRepository<Evento, Integer> {

}
