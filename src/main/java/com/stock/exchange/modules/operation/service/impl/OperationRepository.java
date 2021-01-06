package com.stock.exchange.modules.operation.service.impl;

import com.stock.exchange.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {

    Optional<Operation> findByUserName(String userName);

    Optional<Operation> findByCorretora(String corretora);

}
