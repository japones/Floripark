package br.com.floripark.financeiro.dao;

import br.com.floripark.financeiro.model.Usuario;
import java.util.ArrayList;

public interface IUsuarioDao {

    public void inserirUsuario(Usuario usuario) throws Exception;

    public void excluirUsuario(Usuario usuario) throws Exception;

    public void alterarUsuario(Usuario usuario) throws Exception;

    public Usuario pesquisarUsuario(Integer id) throws Exception;

    public ArrayList<Usuario> pesquisarUsuario(String nome) throws Exception;

    public ArrayList<Usuario> pesquisarUsuario() throws Exception;
}
