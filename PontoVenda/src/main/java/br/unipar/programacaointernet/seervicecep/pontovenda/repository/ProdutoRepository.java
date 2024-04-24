package br.unipar.programacaointernet.seervicecep.pontovenda.repository;

import br.unipar.programacaointernet.seervicecep.pontovenda.model.Produto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class ProdutoRepository {
    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<Produto> listarTodos() {
        String jpql = "SELECT l FROM Produto l";
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

    public void deletarProduto(Integer id) throws Exception {
        try {
            Produto produto = em.find(Produto.class, id);
            em.remove(produto);
        } catch (Exception e) {
            throw new Exception("Produto não encontrado! " + e.getMessage());
        }
    }

    public void editarProduto(Produto produto) throws Exception {
        try {
            em.merge(produto);
        } catch (Exception e) {
            throw new Exception("Erro ao atualizar " + e.getMessage());
        }

    }
}
