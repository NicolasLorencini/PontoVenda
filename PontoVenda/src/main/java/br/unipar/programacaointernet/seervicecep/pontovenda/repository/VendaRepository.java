package br.unipar.programacaointernet.seervicecep.pontovenda.repository;

import br.unipar.programacaointernet.seervicecep.pontovenda.model.Cliente;
import br.unipar.programacaointernet.seervicecep.pontovenda.model.Venda;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class VendaRepository {
    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<Venda> listarTodosVenda() {
        String jpql = "SELECT l FROM Venda l";
        return em.createQuery(jpql, Venda.class).getResultList();
    }

    public void cadastrarVenda(Venda venda) throws Exception {
        try {
            em.persist(venda);
        } catch (Exception ex) {
            throw new Exception("Venda não pode ser cadastrada");
        }
    }
    public Venda buscarPorIDVenda(Integer id) {
        return em.find(Venda.class, id);
    }

    public Venda deletarVenda(Integer id) throws Exception {
        try {
            Venda venda = em.find(Venda.class, id);
            em.remove(venda);
            return venda;
        } catch (Exception e) {
            throw new Exception("Venda não encontrada!! " + e.getMessage());
        }
    }

    public void editarVenda(Venda venda) throws Exception {
        try {
            em.merge(venda);
        } catch (Exception e) {
            throw new Exception("Erro ao atualizar a Venda!!" + e.getMessage());
        }

    }
}
