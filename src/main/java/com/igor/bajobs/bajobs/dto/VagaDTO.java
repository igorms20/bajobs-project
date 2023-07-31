package com.igor.bajobs.bajobs.dto;

import com.igor.bajobs.bajobs.model.Vaga;
import com.igor.bajobs.bajobs.model.enums.TipoVaga;

public class VagaDTO {

    private String titulo;
    private String descricao;
    private String empresa;
    private String local;
    private TipoVaga tipoVaga;
    private String link;

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getLocal() {
        return local;
    }

    public TipoVaga getTipoVaga() {
        return tipoVaga;
    }

    public String getLink() {
        return link;
    }

    public Vaga convertToObject() {
        Vaga vaga = Vaga.builder()
        	.titulo(titulo)
        	.descricao(descricao)
        	.local(local)
        	.empresa(empresa)
        	.tipoVaga(tipoVaga)
        	.link(link)
        	.build();

        return vaga;
    }
}
