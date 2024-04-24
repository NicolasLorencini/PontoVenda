package br.unipar.programacaointernet.seervicecep.pontovenda.service;

import br.unipar.programacaointernet.seervicecep.pontovenda.model.Cliente;
import br.unipar.programacaointernet.seervicecep.pontovenda.model.Venda;
import br.unipar.programacaointernet.seervicecep.pontovenda.repository.ClienteRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class ClienteService {
    @Inject
    private ClienteRepository clienteRepository;
    public List<Cliente> listarTodosCliente() {
        return clienteRepository.listarTodosCliente();
    }
    public void cadastrarCliente(Cliente cliente) throws Exception {
        clienteRepository.cadastrarCliente(cliente);
    }
    public Cliente buscarPorIDCliente(Integer id) {
        return clienteRepository.buscarPorIDCliente(id);
    }
    public void deletarCliente(Integer id) throws Exception {
        clienteRepository.deletarCliente(id);
    }
    public void editarCliente(Integer id, String nome, String telefone) throws Exception {
        Cliente usuarioAtual = clienteRepository.buscarPorIDCliente(id);

        if (telefone != null) {
            usuarioAtual.setTelefone(telefone);
        }

        if (nome != null) {
            usuarioAtual.setNome(nome);
        }

        clienteRepository.editarCliente(usuarioAtual);
    }

}
