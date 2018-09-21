package br.eti.urbano.model;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Data
public class Content extends DefaultModel {

    @NotNull
    @NotEmpty
    @Column(name = "nome", length = 80, nullable = false)
    private String nameGenerate;

    private String title;

    private String caption;

    private String url;

    private byte[] contentFile;



}
