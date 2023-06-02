package com.proex.erp.repository;

import com.proex.erp.model.Empresa;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

public class EmpresaDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    private EntityManager manager;

    public EmpresaDAO(){
    }

    public EmpresaDAO(EntityManager manager) {
        this.manager = manager;
    }

    public Empresa porId(Long id) {
        return manager.find(Empresa.class, id);
    }

    public List<Empresa> pesquisar(String nome) {
        TypedQuery<Empresa> query = manager
                .createQuery("from Empresa where nomeFantasia like  :nomeFantasia", Empresa.class);
        query.setParameter("nomeFantasia", nome + "%");
        return query.getResultList();
    }

    public Empresa guardar(Empresa empresa){
        return manager.merge(empresa);
    }

    public void remover(Empresa empresa) {
        empresa = porId(empresa.getId());
        manager.remove(empresa);
    }
}
