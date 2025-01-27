package com.mibanco.mcsv_clientes.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mibanco.mcsv_clientes.client.CuentasServiceClient;
import com.mibanco.mcsv_clientes.dto.ClientesDto;
import com.mibanco.mcsv_clientes.dto.CuentasDto;
import com.mibanco.mcsv_clientes.model.Clientes;
import com.mibanco.mcsv_clientes.repository.ClientesRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class ClientesServiceImpl implements ClientesService {
    
    private final ClientesRepository clientesRepository;
    private final CuentasServiceClient cuentasServiceClient;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Clientes> findAll() {
        return clientesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Clientes> findByRut(String rut) {
        if (rut == null || rut.trim().isEmpty()) {
            throw new IllegalArgumentException("El RUT no puede ser nulo o vacío");
        }
        return clientesRepository.findByRut(rut);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClientesDto> findAllClientesWithCuentas() {
        List<Clientes> clientes = clientesRepository.findAll();
        List<CuentasDto> cuentas = cuentasServiceClient.findAllClientesWithCuentas();

        return clientes.stream().map(cliente -> {
                    ClientesDto clientesDto = new ClientesDto();
                    clientesDto.setCliente_id(cliente.getCliente_id());
                    clientesDto.setNombre(cliente.getNombre());
                    clientesDto.setApellido(cliente.getApellido());
                    clientesDto.setRut(cliente.getRut());
                    clientesDto.setFecha_nacimiento(cliente.getFecha_nacimiento());
                    clientesDto.setEdad(cliente.getEdad());
                    clientesDto.setDireccion(cliente.getDireccion());
                    clientesDto.setTelefono(cliente.getTelefono());
                    clientesDto.setCorreo(cliente.getCorreo());
                    clientesDto.setFecha_registro(cliente.getFecha_registro());
                    clientesDto.setEstado(ClientesDto.Estado.valueOf(cliente.getEstado().name()));

                    List<CuentasDto> cuentasDto = cuentas.stream()
                            .filter(cuenta -> cuenta.getRut().equals(cliente.getRut()))
                            .collect(Collectors.toList());
                    
                    clientesDto.setCuentas(cuentasDto);
                    return clientesDto;
        }).collect(Collectors.toList());      
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClientesDto> findAllClientesWithCuentasByRut(String rut) {
        List<Clientes> clientes = clientesRepository.findAll();
        List<CuentasDto> cuentas = cuentasServiceClient.getCuentasByRut(rut);

        return clientes.stream()
                .filter(cliente -> cliente.getRut().equals(rut))
                .map(cliente -> {
                    ClientesDto clientesDto = new ClientesDto();
                    clientesDto.setCliente_id(cliente.getCliente_id());
                    clientesDto.setNombre(cliente.getNombre());
                    clientesDto.setApellido(cliente.getApellido());
                    clientesDto.setRut(cliente.getRut());
                    clientesDto.setFecha_nacimiento(cliente.getFecha_nacimiento());
                    clientesDto.setEdad(cliente.getEdad());
                    clientesDto.setDireccion(cliente.getDireccion());
                    clientesDto.setTelefono(cliente.getTelefono());
                    clientesDto.setCorreo(cliente.getCorreo());
                    clientesDto.setFecha_registro(cliente.getFecha_registro());
                    clientesDto.setEstado(ClientesDto.Estado.valueOf(cliente.getEstado().name()));

                    List<CuentasDto> cuentasDto = cuentas.stream()
                            .filter(cuenta -> cuenta.getRut().equals(cliente.getRut()))
                            .collect(Collectors.toList());
                    
                    clientesDto.setCuentas(cuentasDto);
                    return clientesDto;
                }).collect(Collectors.toList());
    } 

}
