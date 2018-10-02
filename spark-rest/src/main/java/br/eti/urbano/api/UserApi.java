package br.eti.urbano.api;

import br.eti.urbano.controller.UserController;
import br.eti.urbano.model.User;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static spark.Spark.*;

public class UserApi {

    final static Logger LOGGER = Logger.getLogger(UserApi.class);

    public static void main(String[] args) {
        exemplo();
    }

    public static void userApi(){

    }

    public static void exemplo(){

        List<User> lista = new ArrayList<User>();

        path("/api", () -> {
            before("/*", (request, response) -> LOGGER.info("Received api call"));
            path("/user", () -> {

                get("", (request, response) -> {

                    //"TIPANDO" o retorno da requisição

                    response.type("application/json");

//                    User user = new User();
//                    user.setUuid(UUID.randomUUID().toString());
//                    user.setUserName("Nome do usuario");
//
////                    User user = new Gson().fromJson(request.body(), User.class);

                    final String mensagem = "Acesso ao método POST";
                    LOGGER.info(mensagem);
                    response.status(200);
                    return new Gson().toJson(lista);
                });

                post("", (request, response) -> {

                    //"TIPANDO" o retorno da requisição

                    response.type("application/json");

                    User user = new Gson().fromJson(request.body(), User.class);
                    lista.add(user);

                    final String mensagem = "Acesso ao método POST";
                    LOGGER.info(mensagem);

                    response.status(201);

                    return new Gson().toJson(user);
                });
                put("", (request, response) -> {


                    User user = new Gson().fromJson(request.body(), User.class);

                    lista.removeIf(u -> u.getId().equals(user.getId()));
                    lista.add(user);

                    final String mensagem = "Acesso ao método PUT";
                    LOGGER.info(mensagem);
                    response.status(201);
                    return new Gson().toJson(user);
                });
                delete("", (request, response) -> {

                    User user = new Gson().fromJson(request.body(), User.class);

                    lista.removeIf(u -> u.getId().equals(user.getId()));

                    final String mensagem = "Acesso ao método DELETE. Registro deletado.";
                    LOGGER.info(mensagem);
                    response.status(204);
                    return mensagem;
                });
            });
            path("/username", () -> {
                post("/add", (request, response) -> {

                    final String mensagem = "Acesso ao método POST";
                    LOGGER.info(mensagem);
                    response.status(200);
                    return mensagem;
                });
                put("/change", (request, response) -> {

                    final String mensagem = "Acesso ao método PUT";
                    LOGGER.info(mensagem);
                    response.status(201);
                    return mensagem;
                });
                delete("/remove", (request, response) -> {
                    final String mensagem = "Acesso ao método DELETE";
                    LOGGER.info(mensagem);
                    response.status(204);
                    return mensagem;
                });
            });
        });
    }
}
