package br.unipar.programacaointernet.seervicecep.pontovenda.repository;

import br.unipar.programacaointernet.seervicecep.pontovenda.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class ProdutoRepository {
    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<Produto> listarTodos() {
        String jpql = "SELECT l FROM Cliente l";
        return em.createQuery(jpql, Produto.class).getResultList();
    }

    public Produto buscarPorID(Integer id) {
        return em.find(Produto.class, id);
    }

    public void cadastrar(Produto produto) throws Exception {
        try {
            em.persist(produto);
        } catch (Exception ex) {
            throw new Exception("Produto não pode ser cadastrados");
        }
    }
}
