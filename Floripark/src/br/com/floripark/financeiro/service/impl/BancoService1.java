package br.com.floripark.financeiro.service.impl;

import br.com.floripark.financeiro.dao.DaoFactory;
import br.com.floripark.financeiro.model.Banco;
import br.com.floripark.financeiro.model.Usuario;
import br.com.floripark.financeiro.service.IBancoService;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class BancoService1 implements IBancoService {

    private Banco banco;
    private Date dataInclusao;
    private Date dataAlteracao;

    @Override
    public Boolean inserirBanco(Integer id, String nome, Usuario usuarioLogado) throws Exception {
        dataInclusao = new Date();
        banco = new Banco();

        banco.setId(id);
        banco.setNome(nome);
        banco.setDatainclusao(dataInclusao);
        banco.setUsuarioinclusao(usuarioLogado);
        
        DaoFactory.getBancoDao().inserirBanco(banco);
        JOptionPane.showMessageDialog(null, "Banco incluído com sucesso!");
        return true;
    }

    @Override
    public void excluirBanco(Integer id) throws Exception {
        DaoFactory.getBancoDao().excluirBanco(pesquisarBanco(id));
        JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
    }

    @Override
    public Boolean alterarBanco(Integer id, String nome, Usuario usuarioLogado, Date dataInclusao, Usuario usuarioInclusao) throws Exception {
        dataAlteracao = new Date();
        banco = new Banco();

        banco.setId(id);
        banco.setNome(nome);
        banco.setUsuarioalteracao(usuarioLogado);
        banco.setDataalteracao(dataAlteracao);
        banco.setUsuarioinclusao(usuarioInclusao);
        banco.setDatainclusao(dataInclusao);

        DaoFactory.getBancoDao().alterarBanco(banco);
        JOptionPane.showMessageDialog(null, "Banco alterado com sucesso!");
        return true;
    }

    @Override
    public Banco pesquisarBanco(Integer id) throws Exception {
        return DaoFactory.getBancoDao().pesquisarBanco(id);
    }

    @Override
    public ArrayList<Banco> pesquisarBanco(String nome) throws Exception {
        return DaoFactory.getBancoDao().pesquisarBanco(nome);
    }

    @Override
    public ArrayList<Banco> pesquisarBanco() throws Exception {
        return DaoFactory.getBancoDao().pesquisarBanco();
    }
}
