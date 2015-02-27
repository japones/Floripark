package br.com.floripark.financeiro.service;

import br.com.floripark.financeiro.model.Usuario;
import java.util.ArrayList;
import java.util.Date;

public interface IUsuarioService {
    
    public Boolean inserirUsuario(String nome, String usuario, String senha, Usuario usuarioInclusao) throws Exception;

    public void excluirUsuario(Integer id) throws Exception;
    
    public Boolean alterarUsuario(Integer id, String nome, String usuario, String senha, Usuario usuarioAlteracao, Date dataInclusao, Usuario usuarioInclusao) throws Exception;
    
    public Usuario pesquisarUsuario(Integer id) throws Exception;
    
    public ArrayList<Usuario> pesquisarUsuario() throws Exception;
    
    public ArrayList<Usuario> pesquisarUsuario(String nome) throws Exception;
    
    public Usuario isUsuarioValido(String login, String senha) throws Exception;
    
}
