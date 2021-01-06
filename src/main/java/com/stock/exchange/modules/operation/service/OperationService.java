package com.stock.exchange.modules.operation.service;

import com.stock.exchange.exception.OperationNotFoundException;
import com.stock.exchange.modules.operation.dto.OperationDTO;

import java.util.List;

public interface OperationService {

    OperationDTO createOperation(OperationDTO operationDTO);

    OperationDTO findByUsername(String userName) throws OperationNotFoundException;

    OperationDTO findByCorretora(String corretora) throws OperationNotFoundException;

    OperationDTO findById(Long idOperation) throws OperationNotFoundException;

    List<OperationDTO> listAll();

    void deleteById(Long id) throws OperationNotFoundException;

}
