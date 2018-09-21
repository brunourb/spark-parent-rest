package br.eti.urbano.model;


import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Data
/**
 * @link Lombook - https://projectlombok.org/features/all
 */
@MappedSuperclass
public class DefaultModel implements Serializable {

    private Integer id;

    private String data;
}
