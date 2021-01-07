package com.stock.exchange.modules.operation.controller;

import com.stock.exchange.modules.operation.dto.OperationDTO;
import com.stock.exchange.modules.operation.service.OperationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/stock")
@Api(value = "REST API for stock exchange management")
@CrossOrigin(origins = "*")
public class OperationController {

    private final OperationService service;

    public OperationController(OperationService service) {
        this.service = service;
    }

    @PostMapping
    @ApiOperation(value = "Crie uma nova operação.", response = OperationDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success operation creation")
    })
    @ResponseStatus(HttpStatus.CREATED)
    public OperationDTO create(@RequestBody @Valid OperationDTO operationDTO) {
        return this.service.createOperation(operationDTO);
    }

    @GetMapping("userName/{userName}")
    @ApiOperation(value = "Busca uma operação pelo nome do usuário.")
    public List<OperationDTO> findByUserName(@PathVariable("userName") String userName) {
        return this.service.findByUsername(userName);
    }

    @GetMapping("corretora/{corretora}")
    @ApiOperation(value = "Busca uma operação pelo nome da corretora.")
    public List<OperationDTO> findByCorretora(@PathVariable("corretora") String corretora) {
        return this.service.findByCorretora(corretora);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca uma operação pelo id.")
    public OperationDTO findById(@PathVariable("id") Long id) throws NotFoundException {
        return this.service.findById(id);
    }

    @GetMapping
    @ApiOperation(value = "Busque todas operações.")
    public List<OperationDTO> findAll() {
        return this.service.listAll();
    }

    @DeleteMapping("deleteOperation/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete uma operação pelo id")
    public void delete(@PathVariable("id") Long id) throws NotFoundException {
        this.service.deleteById(id);
    }

}
