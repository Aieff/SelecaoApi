package br.fepi.selecao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fepi.selecao.domain.Selecao;

public interface SelecaoRepository extends JpaRepository<Selecao, Long>{

}
