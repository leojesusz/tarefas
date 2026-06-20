package com.leonardo.tarefas.controller;

import com.leonardo.tarefas.model.Tarefa;
import com.leonardo.tarefas.repository.TarefaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@Tag(name = "Tarefas", description = "API para gerenciamento de tarefas")
public class TarefaController {

    private final TarefaRepository repository;

    public TarefaController(TarefaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    @Operation(summary = "Listar todas as tarefas", description = "Busca a lista completa de tarefas cadastradas no banco de dados.")
    public List<Tarefa> listar() {
        return repository.findAll();
    }

    @PostMapping
    @Operation(summary = "Criar nova tarefa", description = "Cadastra uma nova tarefa no banco de dados.")
    public Tarefa criar(@RequestBody Tarefa tarefa) {
        return repository.save(tarefa);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar tarefa", description = "Atualiza o título e o status de uma tarefa existente pelo ID.")
    public Tarefa atualizar(@PathVariable Long id, @RequestBody Tarefa detalhes) {
        Tarefa t = repository.findById(id).orElseThrow();
        t.setTitulo(detalhes.getTitulo());
        t.setDescricao(detalhes.getDescricao());
        t.setConcluida(detalhes.isConcluida());
        return repository.save(t);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar tarefa", description = "Remove uma tarefa do banco de dados pelo seu ID.")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}