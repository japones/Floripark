package br.com.floripark.financeiro.service.impl;

import br.com.floripark.financeiro.dao.DaoFactory;
import br.com.floripark.financeiro.model.Servico;
import br.com.floripark.financeiro.model.Usuario;
import br.com.floripark.financeiro.service.IServicoService;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class ServicoService implements IServicoService {

    private Servico servico;
    private Date dataInclusao;
    private Date dataAlteracao;

    @Override
    public Boolean inserirServico(String descricao, Character sigla, Usuario usuario) throws Exception {
        dataInclusao = new Date();
        servico = new Servico();

        servico.setDescricao(descricao);
        servico.setSigla(sigla);
        servico.setUsuarioinclusao(usuario);
        servico.setDatainclusao(dataInclusao);

        DaoFactory.getServicoDao().inserirServico(servico);
        return true;
    }

    @Override
    public void excluirServico(Integer id) throws Exception {
        DaoFactory.getServicoDao().excluirServico(pesquisarServico(id));
    }

    @Override
    public Boolean alterarServico(Integer id, String descricao, Character sigla, Usuario usuario, Date dataInclusao, Usuario usuarioInclusao) throws Exception {
        dataAlteracao = new Date();
        servico = new Servico();

        servico.setId(id);
        servico.setDescricao(descricao);
        servico.setSigla(sigla);
        servico.setUsuarioalteracao(usuario);
        servico.setDataalteracao(dataAlteracao);
        servico.setUsuarioinclusao(usuarioInclusao);
        servico.setDatainclusao(dataInclusao);

        DaoFactory.getServicoDao().alterarServico(servico);
        return true;
    }

    @Override
    public Servico pesquisarServico(Integer id) throws Exception {
        return DaoFactory.getServicoDao().pesquisarServico(id);
    }

    @Override
    public Servico pesquisaServico(Character sigla) throws Exception {
        ArrayList<Servico> lista = pesquisarServico();
        servico = null;
        
        for (Servico lista1 : lista) {
            if (Objects.equals(lista1.getSigla(), sigla)) {
                servico = lista1;
            }
        }
        return servico;
    }

    @Override
    public ArrayList<Servico> pesquisarServico() throws Exception {
        return DaoFactory.getServicoDao().pesquisarServico();
    }
}
