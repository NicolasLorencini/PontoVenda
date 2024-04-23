package br.unipar.programacaointernet.seervicecep.pontovenda.repository;

import br.unipar.programacaointernet.seervicecep.pontovenda.model.ItensVenda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class ItensVendaRepository {
    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<ItensVenda> listarTodos() {
        String jpql = "SELECT l FROM Cliente l";
        return em.createQuery(jpql, ItensVenda.class).getResultList();
    }

    public ItensVenda buscarPorID(Integer id) {
        return em.find(ItensVenda.class, id);
    }

    public void cadastrar(ItensVenda itensVenda) throws Exception {
        try {
            em.persist(itensVenda);
        } catch (Exception ex) {
            throw new Exception("Itens não podem ser cadastrados");
        }
    }
}
