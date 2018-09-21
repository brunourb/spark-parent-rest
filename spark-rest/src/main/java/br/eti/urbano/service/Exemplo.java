package br.eti.urbano.service;

import org.apache.log4j.Logger;

import static spark.Spark.*;

public class Exemplo {

    final static Logger LOGGER = Logger.getLogger(Exemplo.class);

    public static void main(String[] args) {
        get("/", (request, response) -> {
            final String mensagem = "Acesso ao método GET";
            LOGGER.info(mensagem);
            response.status(200);
            return mensagem;
        });

        post("/", (request, response) -> {
            LOGGER.info("Acesso ao método POST");
            response.status(201);
            return "Objeto criado";
        });

        put("/", (request, response) -> {

            response.status(200);
            return "Objeto atualizado";
        });

        delete("/", (request, response) -> {
            LOGGER.info(request.body());

            response.status(200);
            return "Objeto deletado";
        });

        options("/", (request, response) -> {
            LOGGER.info(request.body());

            response.status(200);

            return "Rota Options";
        });
    }
}
