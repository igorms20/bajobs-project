package com.igor.bajobs.bajobs.model;

import com.igor.bajobs.bajobs.model.enums.TipoVaga;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private String empresa;
    private String local;

    @Enumerated(EnumType.STRING)
    private TipoVaga tipoVaga;
    private String link;

    public Vaga() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public TipoVaga getTipoVaga() {
        return tipoVaga;
    }

    public void setTipoVaga(TipoVaga tipoVaga) {
        this.tipoVaga = tipoVaga;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public static VagaBuilder builder() {
        return new VagaBuilder();
    }


    public static class VagaBuilder {
        private Long id;
        private String titulo;
        private String descricao;
        private String empresa;
        private String local;
        private TipoVaga tipoVaga;
        private String link;

        public VagaBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public VagaBuilder titulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public VagaBuilder descricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public VagaBuilder empresa(String empresa) {
            this.empresa = empresa;
            return this;
        }

        public VagaBuilder local(String local) {
            this.local = local;
            return this;
        }

        public VagaBuilder tipoVaga(TipoVaga tipoVaga) {
            this.tipoVaga = tipoVaga;
            return this;
        }

        public VagaBuilder link(String link) {
            this.link = link;
            return this;
        }

        public Vaga build() {
            return new Vaga(this);
        }
    }

    private Vaga(VagaBuilder builder) {
        this.id = builder.id;
        this.titulo = builder.titulo;
        this.descricao = builder.descricao;
        this.empresa = builder.empresa;
        this.local = builder.local;
        this.tipoVaga = builder.tipoVaga;
        this.link = builder.link;
    }

}
