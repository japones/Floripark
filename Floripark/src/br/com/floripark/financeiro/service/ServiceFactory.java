package br.com.floripark.financeiro.service;

import br.com.floripark.financeiro.service.impl.BancoService1;
import br.com.floripark.financeiro.service.impl.DadoService;
import br.com.floripark.financeiro.service.impl.DataMovimentoService;
import br.com.floripark.financeiro.service.impl.EmpresaService;
import br.com.floripark.financeiro.service.impl.GrupoCpaService;
import br.com.floripark.financeiro.service.impl.MovimentoService;
import br.com.floripark.financeiro.service.impl.RetornoBancarioService;
import br.com.floripark.financeiro.service.impl.ServicoService;
import br.com.floripark.financeiro.service.impl.TemporarioService;
import br.com.floripark.financeiro.service.impl.TipoLancamentoService;
import br.com.floripark.financeiro.service.impl.UsuarioService;

public class ServiceFactory {

    private static IBancoService bancoService;
    private static IDataMovimentoService dataMovimentoService;
    private static IEmpresaService empresaService;
    private static IGrupoCpaService grupoCpaService;
    private static IMovimentoService movimentoService;
    private static ITipoLancamentoService tipoLancemntoService;
    private static IUsuarioService usuarioService;
    private static IServicoService servicoService;
    private static IRetornoBancarioService retornoBancarioService;
    private static IDadoService dadoService;
    private static ITemporarioService temporarioService;

    public static IBancoService getBancoService() {
        bancoService = new BancoService1();
        return bancoService;
    }

    public static IDataMovimentoService getDataMovimentoService() {
        dataMovimentoService = new DataMovimentoService();
        return dataMovimentoService;
    }

    public static IEmpresaService getEmpresaService() {
        empresaService = new EmpresaService();
        return empresaService;
    }

    public static IGrupoCpaService getGrupoCpaService() {
        grupoCpaService = new GrupoCpaService();
        return grupoCpaService;
    }

    public static IMovimentoService getMovimentoService() {
        movimentoService = new MovimentoService();
        return movimentoService;
    }

    public static ITipoLancamentoService getTipoLancemntoService() {
        tipoLancemntoService = new TipoLancamentoService();
        return tipoLancemntoService;
    }

    public static IUsuarioService getUsuarioService() {
        usuarioService = new UsuarioService();
        return usuarioService;
    }

    public static IDadoService getDadoService() {
        dadoService = new DadoService();
        return dadoService;
    }

    public static IRetornoBancarioService getRetornoBancarioService() {
        retornoBancarioService = new RetornoBancarioService();
        return retornoBancarioService;
    }

    public static IServicoService getServicoService() {
        servicoService = new ServicoService();
        return servicoService;
    }

    public static ITemporarioService getTemporarioService() {
        temporarioService = new TemporarioService();
        return temporarioService;
    }
}
