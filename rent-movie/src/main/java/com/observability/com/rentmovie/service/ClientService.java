package com.observability.com.rentmovie.service;
import com.observability.com.rentmovie.entity.Client;
import com.observability.com.rentmovie.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public void save(Client client){
        clientRepository.save(client);
    }

    public Client findById(String id){
        return clientRepository.findById(id).orElseThrow(() -> new NotFoundException("Usuário com código informado não encontrado"));
    }

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

}
