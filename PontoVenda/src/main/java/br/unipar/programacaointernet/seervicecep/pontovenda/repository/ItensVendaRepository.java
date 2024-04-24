package br.unipar.programacaointernet.seervicecep.pontovenda.repository;

import br.unipar.programacaointernet.seervicecep.pontovenda.model.ItensVenda;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class ItensVendaRepository {
    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<ItensVenda> listarTodos() {
        String jpql = "SELECT l FROM ItensVenda l";
        return em.createQuery(jpql, ItensVenda.class).getResultList();
    }

    public ItensVenda buscarPorIDItensVenda(Integer id) {
        return em.find(ItensVenda.class, id);
    }

    public  void cadastrar(ItensVenda itensVenda) throws Exception {
        try {
            em.persist(itensVenda);
        } catch (Exception ex) {
            throw new Exception("Itens não podem ser cadastrados");
        }
    }

    public void deletarItensVenda(Integer id) throws Exception {
        try {
            ItensVenda itensVenda = em.find(ItensVenda.class, id);
            em.remove(itensVenda);
        } catch (Exception e) {
            throw new Exception("Itens não encontrados! " + e.getMessage());
        }
    }

}
