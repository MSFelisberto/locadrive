package br.com.fiap.locadrive.locadrive.repositories;

import br.com.fiap.locadrive.locadrive.entities.Veiculo;

import java.util.List;
import java.util.Optional;


public interface VeiculoRepository {
    Optional<Veiculo> findById(Long id);
    List<Veiculo> findAll(int size, int offset);
    Integer save(Veiculo veiculo);
    Integer update(Veiculo veiculo, Long id);
    Integer delete(Long id);
}
