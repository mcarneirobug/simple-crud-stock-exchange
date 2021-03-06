package com.stock.exchange.modules.operation.service.impl;

import com.stock.exchange.modules.operation.dto.OperationDTO;
import com.stock.exchange.modules.operation.service.OperationService;
import com.stock.exchange.modules.operation.service.mapper.OperationMapper;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OperationServiceImpl implements OperationService {

    private final OperationRepository repository;

    @Override
    public OperationDTO createOperation(OperationDTO operationDTO) {
        final var operation = repository.save(OperationMapper.toDTO(operationDTO));
        return OperationMapper.toModel(operation);
    }

    @Override
    public List<OperationDTO> findByUsername(String userName) {
        return repository.findByUserName(userName)
                .stream()
                .map(OperationMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<OperationDTO> findByCorretora(String corretora) {
        return repository.findByCorretora(corretora)
                .stream()
                .map(OperationMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public OperationDTO findById(Long idOperation) throws NotFoundException {
        return repository.findById(idOperation)
                .map(OperationMapper::toModel)
                .orElseThrow(() -> new NotFoundException("Não foi encontrado uma operação com esse id."));
    }

    @Override
    public List<OperationDTO> listAll() {
        return repository.findAll()
                .stream()
                .map(OperationMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) throws NotFoundException {
        this.findById(id);
        this.repository.deleteById(id);
    }
}
