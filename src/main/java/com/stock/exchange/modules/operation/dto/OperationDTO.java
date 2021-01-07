package com.stock.exchange.modules.operation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationDTO implements Serializable {

    private static final long serialVersionUID = 7309218902400427594L;

    @JsonIgnore
    private Long id;

    @ApiModelProperty(value = "Nome do usuário.", required = true, example = "mcarneiro")
    @NotBlank
    @Size(min = 1, max = 200)
    private String userName;

    @ApiModelProperty(value = "Nome da corretora", required = true, example = "rico")
    @NotBlank
    @Size(min = 1, max = 200)
    private String corretora;

    @ApiModelProperty(value = "Data de operação", required = true, example = "2021-01-05")
    @NotNull
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @ApiModelProperty(value = "Robô que realizou a operação", required = true, example = "mrRobot")
    @NotNull
    @Size(min = 1, max = 200)
    private String robo;

    @ApiModelProperty(value = "Valor da operação.", required = true, example = "200.0")
    private Double valor;

}
