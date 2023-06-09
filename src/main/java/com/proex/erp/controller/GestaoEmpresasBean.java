package com.proex.erp.controller;


import com.proex.erp.model.Empresa;
import com.proex.erp.model.TipoEmpresa;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Empresa empresa = new Empresa();

    public Empresa getEmpresa() {
        return empresa;
    }

    public TipoEmpresa[] getTiposEmpresa() {
        return TipoEmpresa.values();
    }

    public void salvar() {
        System.out.println("- Razão social: " + empresa.getRazaoSocial()
        + " - Nome fantasia: " + empresa.getNomeFantasia()
        + " - Tipo: " + empresa.getTipo());
    }
}
