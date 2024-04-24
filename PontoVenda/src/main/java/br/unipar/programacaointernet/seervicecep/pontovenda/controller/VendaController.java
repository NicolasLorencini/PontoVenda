package br.unipar.programacaointernet.seervicecep.pontovenda.controller;

import br.unipar.programacaointernet.seervicecep.pontovenda.model.Cliente;
import br.unipar.programacaointernet.seervicecep.pontovenda.model.Venda;
import br.unipar.programacaointernet.seervicecep.pontovenda.service.ClienteService;
import br.unipar.programacaointernet.seervicecep.pontovenda.service.VendaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/venda")
public class VendaController {
    @Inject
    private VendaService vendaService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarTodosVenda() {
        return Response.ok(vendaService.listar()).build();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarVenda(Venda venda) {
        try {
            vendaService.cadastrarVenda(venda);

            return Response.status(200)
                    .entity("Usuario cadastrado com sucesso")
                    .build();
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }
    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response busacarPorId(@PathParam("id") Integer id) {
        return Response.ok(vendaService.listar()).build();
    }

}
