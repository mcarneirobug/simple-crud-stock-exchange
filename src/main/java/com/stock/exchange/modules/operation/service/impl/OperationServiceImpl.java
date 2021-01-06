package com.stock.exchange.modules.operation.service.impl;

import com.stock.exchange.exception.OperationNotFoundException;
import com.stock.exchange.modules.operation.dto.OperationDTO;
import com.stock.exchange.modules.operation.service.OperationService;
import com.stock.exchange.modules.operation.service.mapper.OperationMapper;
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
    public OperationDTO findByUsername(String userName) throws OperationNotFoundException {
        final var operationFoundUserName = repository.findByUserName(userName)
                .orElseThrow(() -> new OperationNotFoundException(userName));

        return OperationMapper.toModel(operationFoundUserName);
    }

    @Override
    public OperationDTO findByCorretora(String corretora) throws OperationNotFoundException {
        final var operationFoundCorretora = repository.findByCorretora(corretora)
                .orElseThrow(() -> new OperationNotFoundException(corretora));

        return OperationMapper.toModel(operationFoundCorretora);
    }

    @Override
    public OperationDTO findById(Long idOperation) throws OperationNotFoundException {
        return repository.findById(idOperation)
                .map(OperationMapper::toModel)
                .orElseThrow(() -> new OperationNotFoundException(idOperation));
    }

    @Override
    public List<OperationDTO> listAll() {
        return repository.findAll()
                .stream()
                .map(OperationMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) throws OperationNotFoundException {
        this.findById(id);
        this.repository.deleteById(id);
    }
}
