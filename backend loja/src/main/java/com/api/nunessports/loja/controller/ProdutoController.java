package com.api.nunessports.loja.controller;

import com.api.nunessports.loja.dto.ProdutoDTO;
import com.api.nunessports.loja.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.nunessports.loja.model.Produto;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProdutoController {

    final ProdutoService service;

    public ProdutoController(ProdutoService prodService) {
        this.service = prodService;
    }

    
    @PostMapping
    public ResponseEntity<Object> saveProduto(@RequestBody @Valid ProdutoDTO produtoDTO){
        Produto produto = new Produto();
        BeanUtils.copyProperties(produtoDTO, produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(produto));
    }

    
    @GetMapping
    public ResponseEntity<List<Produto>> getAllProduto(){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.findAll());
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneProduto(@PathVariable(value = "id") Long id){
        Optional<Produto> produto = service.findById(id);
        if (!produto.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produto.get());
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduto(@PathVariable(value = "id") Long id){
        Optional<Produto> produtoOptional = service.findById(id);
        if (!produtoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto not found.");
        }
        service.delete(produtoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto deleted successfully.");
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduto(@PathVariable(value = "id") Long id,
                                                   @RequestBody @Valid ProdutoDTO formDto){
        Optional<Produto> produtoOptional = service.findById(id);
        if (!produtoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto not found.");
        }
        Produto produto = new Produto();
        BeanUtils.copyProperties(formDto, produto);
        produto.setId(produtoOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(service.save(produto));
    }


}
