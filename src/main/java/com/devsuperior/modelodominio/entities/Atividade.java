package com.devsuperior.modelodominio.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="tb_atividade")

public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    private Double preco;

    @OneToMany(mappedBy = "atividades")
    private List<Bloco> blocos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Atividade (){
    }

    public Atividade(Integer id, String name, String descricao, Double preco, Categoria categoria) {
        this.id = id;
        this.name = name;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }
    @ManyToMany(mappedBy = "atividades")
    private Set<Participante> participantes=new HashSet<>();
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Set<Participante> getParticipantes() {
        return participantes;
    }

    public List<Bloco> getBlocos() {
        return blocos;
    }
}
