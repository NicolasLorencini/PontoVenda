package br.unipar.programacaointernet.seervicecep.pontovenda.repository;
import br.unipar.programacaointernet.seervicecep.pontovenda.model.Cliente;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
@Stateless
public class ClienteRepository
{

    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<Cliente> listarTodosCliente() {
        String jpql = "SELECT l FROM Cliente l";
        return em.createQuery(jpql, Cliente.class).getResultList();
    }

    public Cliente buscarPorIDCliente(Integer id) {

        return em.find(Cliente.class, id);
    }

    public void cadastrarCliente(Cliente cliente) throws Exception {
        try {
            em.persist(cliente);
        } catch (Exception ex) {
            throw new Exception("Cliente não pode ser cadastrado");
        }
    }

    public void deletarCliente(Integer id) throws Exception {
        try {
            Cliente cliente = em.find(Cliente.class, id);
            em.remove(cliente);
        } catch (Exception e) {
            throw new Exception("Cliente não encontrado! " + e.getMessage());
        }
    }

    public void editarCliente(Cliente cliente) throws Exception {
        try {
            em.merge(cliente);
        } catch (Exception e) {
            throw new Exception("Erro ao atualizar " + e.getMessage());
        }

    }
}
