package br.com.floripark.financeiro.service.impl;

import br.com.floripark.financeiro.dao.DaoFactory;
import br.com.floripark.financeiro.model.Temporario;
import br.com.floripark.financeiro.service.ITemporarioService;

public class TemporarioService implements ITemporarioService {

    @Override
    public void inserirTemporario(String linha) throws Exception {
        Temporario temporario = new Temporario();
        temporario.setDados(linha);

        DaoFactory.getTemporarioDao().inserirTemporario(temporario);
    }
}
