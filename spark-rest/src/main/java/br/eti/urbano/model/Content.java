package br.eti.urbano.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Builder
@AllArgsConstructor
public class Content extends DefaultModel {

    @NotNull
    @NotEmpty
    @Column(length = 80, nullable = false)
    private String nameGenerate;

    private String title;

    private String caption;

    private String url;

    private byte[] contentFile;



}
