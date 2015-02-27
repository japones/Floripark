package br.com.floripark.financeiro.service.impl;

import br.com.floripark.financeiro.dao.DaoFactory;
import br.com.floripark.financeiro.model.Usuario;
import br.com.floripark.financeiro.service.IUsuarioService;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class UsuarioService implements IUsuarioService {

    private Usuario usuario;
    private Date dataInclusao;
    private Date dataAlteracao;

    @Override
    public Boolean inserirUsuario(String nome, String usuario, String senha, Usuario usuarioInclusao) throws Exception {
        dataInclusao = new Date();
        this.usuario = new Usuario();

        this.usuario.setNome(nome);
        this.usuario.setUsuario(usuario);
        this.usuario.setSenha(senha);
        this.usuario.setUsuarioinclusao(usuarioInclusao);
        this.usuario.setDatainclusao(dataInclusao);

        DaoFactory.getUsuarioDao().inserirUsuario(this.usuario);
        JOptionPane.showMessageDialog(null, "Registro incluído com sucesso.");
        return true;
    }

    @Override
    public void excluirUsuario(Integer id) throws Exception {
        DaoFactory.getUsuarioDao().excluirUsuario(pesquisarUsuario(id));
        JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
    }

    @Override
    public Boolean alterarUsuario(Integer id, String nome, String usuario, String senha, Usuario usuarioAlteracao, Date dataInclusao, Usuario usuarioInclusao) throws Exception {
        dataAlteracao = new Date();
        this.usuario = new Usuario();

        this.usuario.setId(id);
        this.usuario.setNome(nome);
        this.usuario.setUsuario(usuario);
        this.usuario.setSenha(senha);
        this.usuario.setUsuarioalteracao(usuarioAlteracao);
        this.usuario.setDataalteracao(dataAlteracao);
        this.usuario.setUsuarioinclusao(usuarioInclusao);
        this.usuario.setDatainclusao(dataInclusao);

        DaoFactory.getUsuarioDao().alterarUsuario(this.usuario);
        JOptionPane.showMessageDialog(null, "Registro alterado com sucesso.");
        return true;
    }

    @Override
    public Usuario pesquisarUsuario(Integer id) throws Exception {
        return DaoFactory.getUsuarioDao().pesquisarUsuario(id);
    }

    @Override
    public ArrayList<Usuario> pesquisarUsuario(String nome) throws Exception {
        return DaoFactory.getUsuarioDao().pesquisarUsuario(nome);
    }

    @Override
    public ArrayList<Usuario> pesquisarUsuario() throws Exception {
        return DaoFactory.getUsuarioDao().pesquisarUsuario();
    }

    @Override
    public Usuario isUsuarioValido(String login, String senha) throws Exception {
        Usuario ret = null;
        ArrayList<Usuario> usuarios = DaoFactory.getUsuarioDao().pesquisarUsuario();
        for (Usuario usuario1 : usuarios) {
            if (usuario1.getUsuario().equals(login) && usuario1.getSenha().equals(senha)) {
                ret = usuario1;
            } else {
                ret = null;
            }
        }
        return ret;
    }
}
