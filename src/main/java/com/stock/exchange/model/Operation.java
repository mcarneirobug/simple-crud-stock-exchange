package com.stock.exchange.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)

@Entity
@Table(catalog = "bolsa", name = "operations")
public class Operation implements Serializable {

    private static final long serialVersionUID = 1392542446519028596L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Favor informar o nome do usuário.")
    @Column(name = "user_name", nullable = false, length = 200)
    private String userName;

    @NotBlank(message = "Favor informar o nome da correta.")
    @Column(name = "corretora", nullable = false, length = 200)
    private String corretora;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "data", nullable = false)
    private LocalDate date;

    @Column(name = "robo", nullable = false, length = 200)
    private String robo;

    @Column(name = "valor", nullable = false)
    private Double valor;

}
