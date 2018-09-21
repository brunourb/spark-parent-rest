package br.eti.urbano.controller;

import br.eti.urbano.interfaces.GenericController;
import br.eti.urbano.model.User;

import java.util.List;

public class UserController implements GenericController<User> {
    @Override
    public void create(User entity) {

    }

    @Override
    public User read(Integer id) {
        return null;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void create(List<User> entities) {

    }

    @Override
    public List<User> read(List<Integer> ids) {
        return null;
    }

    @Override
    public void update(List<User> entities) {

    }

    @Override
    public void delete(List<Integer> ids) {

    }
}
