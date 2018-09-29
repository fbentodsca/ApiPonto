package com.kazale.pontointeligente.api.repositories;

import java.util.List;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional (readOnly = true)
@NamedQueries ({
		@NamedQuery(name = "LancamentoRepository.findByFuncionarioId",
				query = "SELECT lanc FROM Lancamento lanc WHERE lanc.funcionario.id = :funcionadioId")})
public interface LancamentoRepository {
	List<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId);
	Page<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId, Pageable pageable);
}