package com.proex.erp.repository;

import com.proex.erp.model.Empresa;
import com.proex.erp.model.RamoAtividade;
import com.proex.erp.model.TipoEmpresa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class CamadaPersistencia {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProexPU");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Declarando os repositórios
        RamoAtividadeDAO ramoAtividadeDAO = new RamoAtividadeDAO(em);
        EmpresaDAO empresaDAO = new EmpresaDAO(em);

        // Buscando as informações do banco de dados
        List<RamoAtividade> listaDeRamoAtividades = ramoAtividadeDAO.pesquisar("");
        List<Empresa> listaDeEmpresas = empresaDAO.pesquisar("");
        System.out.println(listaDeEmpresas);

        // Criando uma empresa
        Empresa empresa = new Empresa();
        empresa.setNomeFantasia("João da Silva");
        empresa.setCnpj("41.952.519/0001-57");
        empresa.setRazaoSocial("João da Silva 41952519000157");
        empresa.setTipo(TipoEmpresa.MEI);
        empresa.setDataFundacao(new Date());
        empresa.setRamoAtividade(listaDeRamoAtividades.get(0));

        // Salvando a empresa
        empresaDAO.guardar(empresa);

        em.getTransaction().commit();

        // Verificando se a inserção funcionou
        List<Empresa> lisaDeEmpresas2 = empresaDAO.pesquisar("");
        System.out.println(lisaDeEmpresas2);

        em.close();
        emf.close();
    }
}
