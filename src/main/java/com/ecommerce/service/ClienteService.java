package com.ecommerce.service;

import com.ecommerce.model.Cliente;
import com.ecommerce.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public Cliente buscaClientePorId(Integer clienteId){
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }
}
