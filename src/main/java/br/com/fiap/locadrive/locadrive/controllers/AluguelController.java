package br.com.fiap.locadrive.locadrive.controllers;

import br.com.fiap.locadrive.locadrive.entities.Aluguel;
import br.com.fiap.locadrive.locadrive.entities.Pessoa;
import br.com.fiap.locadrive.locadrive.services.AluguelService;
import br.com.fiap.locadrive.locadrive.services.PessoaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {
    private static final Logger logger = LoggerFactory.getLogger(AluguelController.class);

    private final AluguelService aluguelService;

    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

//    http://localhost:8080/alugueis?page=1&size=10

    @GetMapping
    public ResponseEntity<List<Aluguel>> findAllAlugueis(@RequestParam("page") int page, @RequestParam("size") int size) {
        logger.info("Endpoint: /alugueis foi acessado");
        var aluguel = this.aluguelService.findAllAlugueis(page, size);
        return ResponseEntity.ok(aluguel);
    }

    //    http://localhost:8080/alugueis/1

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Aluguel>> findAluguel(@PathVariable("id") Long id) {
        logger.info("/alugueis/" + id);
        var aluguel = this.aluguelService.findAluguelById(id);
        return ResponseEntity.ok(aluguel);
    }

    @PostMapping
    public ResponseEntity<Void> saveAluguel(@RequestBody Aluguel aluguel) {
        logger.info("POST -> /alugueis");
        this.aluguelService.saveAluguel(aluguel);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAluguel(@PathVariable("id") Long id, @RequestBody Aluguel aluguel) {
        logger.info("PUT -> /alugueis/" + id);
        this.aluguelService.updateAluguel(aluguel, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluguel(@PathVariable("id") Long id) {
        logger.info("DELETE -> /alugueis/" + id);
        this.aluguelService.deleteAluguel(id);
        return ResponseEntity.noContent().build();
    }
}
