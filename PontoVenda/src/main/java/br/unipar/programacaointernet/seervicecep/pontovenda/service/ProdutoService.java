package br.unipar.programacaointernet.seervicecep.pontovenda.service;

import br.unipar.programacaointernet.seervicecep.pontovenda.model.Cliente;
import br.unipar.programacaointernet.seervicecep.pontovenda.model.Produto;
import br.unipar.programacaointernet.seervicecep.pontovenda.model.Venda;
import br.unipar.programacaointernet.seervicecep.pontovenda.repository.ProdutoRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class ProdutoService {
    @Inject
    private ProdutoRepository produtoRepository;

    public List<Produto> listar(){
        return produtoRepository.listarTodos();
    }
    public void cadastrar(Produto produto) throws Exception{
        produtoRepository.cadastrar(produto);
    }

    public void deletarProduto(Integer id) throws Exception{
        produtoRepository.deletarProduto(id);
    }
    public Produto buscarPorIDProduto(Integer id) {
        return produtoRepository.buscarPorID(id);
    }

    public void editarProduto(Integer id, String descricao, Double valor_unitario) throws Exception {
        Produto produtoAtual = produtoRepository.buscarPorID(id);

        if (descricao != null) {
            produtoAtual.setDescricao(descricao);
        }

        if (valor_unitario != null) {
            produtoAtual.setValor_unitario(valor_unitario);
        }

        produtoRepository.editarProduto(produtoAtual);
    }
}
