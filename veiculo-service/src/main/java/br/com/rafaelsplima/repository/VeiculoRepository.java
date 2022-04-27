package br.com.rafaelsplima.repository;

import br.com.rafaelsplima.model.Veiculo;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}
