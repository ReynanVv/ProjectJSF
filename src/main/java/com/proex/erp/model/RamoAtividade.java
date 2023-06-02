package com.proex.erp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ramo_atividade")
public class RamoAtividade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false, length = 80)
    private String descricao;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RamoAtividade)) return false;
        RamoAtividade that = (RamoAtividade) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "RamoAtividade{" +
                "id=" + id +
                '}';
    }
}
