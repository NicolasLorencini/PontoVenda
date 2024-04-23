package br.unipar.programacaointernet.seervicecep.pontovenda.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nome;
    @Column
    private String telefone;
}
