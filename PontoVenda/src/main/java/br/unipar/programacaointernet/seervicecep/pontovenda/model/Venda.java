package br.unipar.programacaointernet.seervicecep.pontovenda.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Double total;
    @Column
    private String observações;
    @ManyToOne
    private Cliente cliente;
    @OneToMany(mappedBy = "venda",orphanRemoval = true)
    private List<ItensVenda> lista;
}
