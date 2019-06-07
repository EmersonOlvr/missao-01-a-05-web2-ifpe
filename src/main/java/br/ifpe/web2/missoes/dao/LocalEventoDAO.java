package br.ifpe.web2.missoes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ifpe.web2.missoes.model.LocalEvento;

public interface LocalEventoDAO extends JpaRepository<LocalEvento, Integer> {

}
