package com.stock.exchange.modules.operation.service;

import com.stock.exchange.modules.operation.dto.OperationDTO;
import javassist.NotFoundException;

import java.util.List;

public interface OperationService {

    OperationDTO createOperation(OperationDTO operationDTO);

    List<OperationDTO> findByUsername(String userName);

    List<OperationDTO> findByCorretora(String corretora);

    OperationDTO findById(Long idOperation) throws NotFoundException;

    List<OperationDTO> listAll();

    void deleteById(Long id) throws NotFoundException;

}
