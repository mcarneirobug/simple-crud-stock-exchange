package com.stock.exchange.modules.operation.service.impl;

import com.stock.exchange.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {

    @Query("FROM Operation p " +
            "WHERE p.userName = :userName")
    List<Operation> findByUserName(@Param("userName") String userName);

    @Query("FROM Operation p "
            + "WHERE p.corretora = :corretora")
    List<Operation> findByCorretora(@Param("corretora") String corretora);

}
