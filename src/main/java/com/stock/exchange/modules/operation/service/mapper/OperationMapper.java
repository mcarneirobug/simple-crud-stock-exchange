package com.stock.exchange.modules.operation.service.mapper;

import com.stock.exchange.model.Operation;
import com.stock.exchange.modules.operation.dto.OperationDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OperationMapper {

    public static Operation toDTO(OperationDTO dto) {

        final var operation = new Operation();

        operation.setId(dto.getId());
        operation.setUserName(dto.getUserName());
        operation.setCorretora(dto.getCorretora());
        operation.setDate(dto.getDate());
        operation.setRobo(dto.getRobo());
        operation.setValor(dto.getValor());

        return operation;
    }

    public static OperationDTO toModel(Operation operation) {

        final var operationDTO = new OperationDTO();

        operationDTO.setId(operation.getId());
        operationDTO.setUserName(operation.getUserName());
        operationDTO.setCorretora(operation.getCorretora());
        operationDTO.setDate(operation.getDate());
        operationDTO.setRobo(operation.getRobo());
        operationDTO.setValor(operation.getValor());

        return operationDTO;
    }
}
