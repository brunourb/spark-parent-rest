package br.eti.urbano.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import java.util.List;

@Data
@Builder
public class Contact extends DefaultModel {

    private String name;
    private List<String> phones;
    private List<String> address;
}
