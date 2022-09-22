package com.observability.com.rentmovie.controller;

import com.observability.com.rentmovie.controller.dto.ClientDto;
import com.observability.com.rentmovie.entity.Client;
import com.observability.com.rentmovie.repository.ClientRepository;
import com.observability.com.rentmovie.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("client")
public class ClientController {

    private final ClientService clientService;
    private final ClientRepository clientRepository;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ClientDto clientDto){
        clientService.save(clientDto.from(clientDto));
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Client> findById(@PathVariable String id){
        var client = clientService.findById(id);
        return ResponseEntity.ok(client);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Client>> findAll(){
        log.info("Listando todos os clientes");
        var client = clientRepository.findAll();
        return ResponseEntity.ok(client);
    }
}
