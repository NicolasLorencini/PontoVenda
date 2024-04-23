package br.unipar.programacaointernet.seervicecep.pontovenda.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ItensVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Double valor_Unitario;
    @Column
    private Double valor_Total;
    @Column
    private Double quantidade;

    @ManyToOne
    @JoinColumn(name = "fk_Produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "fk_Venda_id")
    private Venda venda;

}
