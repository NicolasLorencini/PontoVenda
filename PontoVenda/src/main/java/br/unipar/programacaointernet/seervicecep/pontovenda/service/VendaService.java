package br.unipar.programacaointernet.seervicecep.pontovenda.service;

import br.unipar.programacaointernet.seervicecep.pontovenda.model.ItensVenda;
import br.unipar.programacaointernet.seervicecep.pontovenda.model.Venda;
import br.unipar.programacaointernet.seervicecep.pontovenda.repository.ItensVendaRepository;
import br.unipar.programacaointernet.seervicecep.pontovenda.repository.VendaRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class VendaService {
    @Inject
    private VendaRepository vendaRepository;

    @Inject
    private ItensVendaRepository itensVendaRepository;
    public List<Venda> listar() {
        return vendaRepository.listarTodosVenda();
    }

    public void cadastrarVenda(Venda venda) throws Exception {
        vendaRepository.cadastrarVenda(venda);

        for (ItensVenda itensVenda : venda.getLista()){
            itensVendaRepository.cadastrar(itensVenda);
        }
    }

    public Venda buscarPorIDVenda(Integer id) {
        return vendaRepository.buscarPorIDVenda(id);
    }

    public Venda deletarVenda(Integer id) throws Exception {
       return vendaRepository.deletarVenda(id);
    }


}
