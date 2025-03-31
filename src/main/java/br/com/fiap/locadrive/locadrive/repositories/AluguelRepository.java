package br.com.fiap.locadrive.locadrive.repositories;

import br.com.fiap.locadrive.locadrive.entities.Aluguel;
import br.com.fiap.locadrive.locadrive.entities.Pessoa;

import java.util.List;
import java.util.Optional;

public interface AluguelRepository {
    Optional<Aluguel> findById(Long id);
    List<Aluguel> findAll(int size, int offset);
    Integer save(Aluguel aluguel);
    Integer update(Aluguel aluguel, Long id);
    Integer delete(Long id);
}
