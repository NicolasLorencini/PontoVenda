package br.unipar.programacaointernet.seervicecep.pontovenda.controller;

import br.unipar.programacaointernet.seervicecep.pontovenda.model.Cliente;
import br.unipar.programacaointernet.seervicecep.pontovenda.service.ClienteService;
import br.unipar.programacaointernet.seervicecep.pontovenda.service.VendaService;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cliente")
public class ClienteController {
    @Inject
    private ClienteService clienteService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarItensCliente(){
        return Response.ok(clienteService.listarTodosCliente()).build();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarCliente(Cliente cliente){
        try{
            clienteService.cadastrarCliente(cliente);
            return Response.status(201).entity("Cliente cadastrado com sucesso").build();
        }catch (Exception ex){
            return Response.status(403).entity(ex.getMessage()).build();
        }

    }

    @DELETE
    @Path("/{id}")
    @PermitAll
    public Response deletarCliente(@PathParam("id") Integer id) {
        try {
            clienteService.deletarCliente(id);

            return Response.status(200)
                    .entity("Cliente deletado com sucesso")
                    .build();
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response editarCliente(
            @PathParam("id") Integer id,
            Cliente cliente
    ) {
        try {
            clienteService.editarCliente(id,cliente.getNome(), cliente.getTelefone());

            return Response.status(200)
                    .entity("Usuário editado com sucesso.")
                    .build();
        } catch (Exception exception) {
            return Response.status(500).entity(exception.getMessage()).build();
        }
    }
    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response busacarPorId(@PathParam("id") Integer id) {
        return Response.ok(clienteService.buscarPorIDCliente(id)).build();
    }


}
