package br.com.floripark.financeiro.dao;

import br.com.floripark.financeiro.dao.impl.BancoDao;
import br.com.floripark.financeiro.dao.impl.DadoDao;
import br.com.floripark.financeiro.dao.impl.DataMovimentoDao;
import br.com.floripark.financeiro.dao.impl.EmpresaDao;
import br.com.floripark.financeiro.dao.impl.GrupoCpaDao;
import br.com.floripark.financeiro.dao.impl.MovimentoDao;
import br.com.floripark.financeiro.dao.impl.RetornoBancarioDao;
import br.com.floripark.financeiro.dao.impl.ServicoDao;
import br.com.floripark.financeiro.dao.impl.TemporarioDao;
import br.com.floripark.financeiro.dao.impl.TipoLancamentoDao;
import br.com.floripark.financeiro.dao.impl.UsuarioDao;

public class DaoFactory {
    
    private static IBancoDao bancoDao;
    private static IDataMovimentoDao dataMovimentoDao;
    private static IEmpresaDao empresaDao;
    private static IGrupoCpaDao grupoCpaDao;
    private static IMovimentoDao movimentoDao;
    private static ITipoLancamentoDao tipoLancamentoDao;
    private static IUsuarioDao usuarioDao;
    private static IServicoDao servicoDao;
    private static IRetornoBancarioDao retornoBancarioDao;
    private static IDadoDao dadoDao;
    private static ITemporarioDao temporarioDao;
         
    public static IBancoDao getBancoDao() {
        bancoDao = new BancoDao();
        return bancoDao;
    }

    public static IDataMovimentoDao getDataMovimentoDao() {
        dataMovimentoDao = new DataMovimentoDao();
        return dataMovimentoDao;
    }

    public static IEmpresaDao getEmpresaDao() {
        empresaDao = new EmpresaDao();
        return empresaDao;
    }

    public static IGrupoCpaDao getGrupoCpaDao() {
        grupoCpaDao = new GrupoCpaDao();
        return grupoCpaDao;
    }

    public static IMovimentoDao getMovimentoDao() {
        movimentoDao = new MovimentoDao();
        return movimentoDao;
    }

    public static ITipoLancamentoDao getTipoLancamentoDao() {
        tipoLancamentoDao = new TipoLancamentoDao();
        return tipoLancamentoDao;
    }

    public static IUsuarioDao getUsuarioDao() {
        usuarioDao = new UsuarioDao();
        return usuarioDao;
    }

    public static IServicoDao getServicoDao() {
        servicoDao = new ServicoDao();
        return servicoDao;
    }

    public static IDadoDao getDadoDao() {
        dadoDao = new DadoDao();
        return dadoDao;
    }

    public static IRetornoBancarioDao getRetornoBancarioDao() {
        retornoBancarioDao = new RetornoBancarioDao();
        return retornoBancarioDao;
    }

    public static ITemporarioDao getTemporarioDao() {
        temporarioDao = new TemporarioDao();
        return temporarioDao;
    }
}
