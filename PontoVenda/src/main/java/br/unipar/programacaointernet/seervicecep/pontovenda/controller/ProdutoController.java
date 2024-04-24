package br.unipar.programacaointernet.seervicecep.pontovenda.controller;

import br.unipar.programacaointernet.seervicecep.pontovenda.model.Cliente;
import br.unipar.programacaointernet.seervicecep.pontovenda.model.Produto;
import br.unipar.programacaointernet.seervicecep.pontovenda.service.ClienteService;
import br.unipar.programacaointernet.seervicecep.pontovenda.service.ProdutoService;
import br.unipar.programacaointernet.seervicecep.pontovenda.service.VendaService;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class ProdutoController {
    @Inject
    private ProdutoService produtoService;


    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarProduto(){
        return Response.ok(produtoService.listar()).build();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarProdutos(Produto produto){
        try{
            produtoService.cadastrar(produto);
            return Response.status(201).entity("Produto cadastrado com sucesso").build();
        }catch (Exception ex){
            return Response.status(403).entity(ex.getMessage()).build();
        }

    }

    @DELETE
    @Path("/{id}")
    @PermitAll
    public Response deletarProduto(@PathParam("id") Integer id) {
        try {
            produtoService.deletarProduto(id);
            return Response.status(200)
                    .entity("Produto deletado com sucesso")
                    .build();
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response editarProduto(
            @PathParam("id") Integer id,
            Produto produto
    ) {
        try {
            produtoService.editarProduto(id, produto.getDescricao(), produto.getValor_unitario());

            return Response.status(200)
                    .entity("Produto editado com sucesso.")
                    .build();
        } catch (Exception exception) {
            return Response.status(500).entity(exception.getMessage()).build();
        }
    }
    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response busacarPorId(@PathParam("id") Integer id) {
        return Response.ok(produtoService.buscarPorIDProduto(id)).build();
    }
}

