package br.unipar.programacaointernet.seervicecep.pontovenda.repository;
import br.unipar.programacaointernet.seervicecep.pontovenda.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class ClienteRepository {
    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<Cliente> listarTodos() {
        String jpql = "SELECT l FROM Cliente l";
        return em.createQuery(jpql, Cliente.class).getResultList();
    }

    public Cliente buscarPorID(Integer id) {
        return em.find(Cliente.class, id);
    }

    public void cadastrar(Cliente cliente) throws Exception {
        try {
            em.persist(cliente);
        } catch (Exception ex) {
            throw new Exception("Cliente não pode ser cadastrado");
        }
    }
}
