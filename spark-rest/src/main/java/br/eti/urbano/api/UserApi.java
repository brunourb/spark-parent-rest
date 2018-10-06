package br.eti.urbano.api;

import br.eti.urbano.model.Contact;
import br.eti.urbano.model.User;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;

public class UserApi {

    final static Logger LOGGER = Logger.getLogger(UserApi.class);
    final static String CONTENT_TYPE = "application/json";

    public static void main(String[] args) {
        users();
        contacts();
    }

    public static void userApi(){

    }

    public static void users(){

        List<User> lista = new ArrayList<User>();

        path("/api", () -> {
            before("/*", (request, response) -> LOGGER.info("Received api call"));
            path("/user", () -> {

                get("", (request, response) -> {

                    //"TIPANDO" o retorno da requisição

                    response.type(CONTENT_TYPE);

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

                    response.type(CONTENT_TYPE);

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
                delete("/:id", (request, response) -> {

                    User user = new User();
                    user.setId(Integer.parseInt(request.params(":id")));

//                    User user = new Gson().fromJson(request.body(), User.class);

                    lista.removeIf(u -> u.getId().equals(user.getId()));

                    final String mensagem = "Acesso ao método DELETE. Registro deletado.";
                    LOGGER.info(mensagem);
                    response.status(204);
                    return mensagem;
                });
            });
        });
    }

    public static void contacts(){

        List<Contact> lista = new ArrayList<Contact>();

        path("/contact", () -> {


            get("", (request, response) -> {

                //"TIPANDO" o retorno da requisição
                response.type(CONTENT_TYPE);
                final String mensagem = "Acesso ao método GET";
                LOGGER.info(mensagem);
                response.status(200);
                return new Gson().toJson(lista);
            });


            post("", (request, response) -> {

                //"TIPANDO" o retorno da requisição

                response.type(CONTENT_TYPE);

                Contact contact = new Gson().fromJson(request.body(), Contact.class);
                lista.add(contact);

                final String mensagem = "Acesso ao método POST";
                LOGGER.info(mensagem);

                response.status(201);

                return new Gson().toJson(contact);
            });

            put("", (request, response) -> {

                Contact contact = new Gson().fromJson(request.body(), Contact.class);

                lista.removeIf(u -> u.getId().equals(contact.getId()));
                lista.add(contact);

                final String mensagem = "Acesso ao método PUT";
                LOGGER.info(mensagem);
                response.status(201);
                return new Gson().toJson(contact);
            });

            delete("/:id", (request, response) -> {

                Contact contact = new Gson().fromJson(request.body(), Contact.class);
                contact.setId(Integer.parseInt(request.params(":id")));

                lista.removeIf(c -> c.getId().equals(c.getId()));

                final String mensagem = "Acesso ao método DELETE. Registro deletado.";
                LOGGER.info(mensagem);
                response.status(204);
                return mensagem;
            });
        });
    }
}
