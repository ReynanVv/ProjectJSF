package com.proex.erp.repository;

import com.proex.erp.model.RamoAtividade;
import org.hibernate.Criteria;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public class RamoAtividadeDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    private EntityManager manager;

    public RamoAtividadeDAO(EntityManager manager) {
        this.manager = manager;
    }

    public List<RamoAtividade> pesquisar(String descricao) {
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();

        CriteriaQuery<RamoAtividade> criteriaQuery = criteriaBuilder.createQuery(RamoAtividade.class);

        Root<RamoAtividade> root = criteriaQuery.from(RamoAtividade.class);

        criteriaQuery.select(root);

        criteriaQuery.where(criteriaBuilder.like(root.get("descricao"),descricao + "%"));

        TypedQuery<RamoAtividade> query = manager.createQuery(criteriaQuery);

        return query.getResultList();
    }

}
