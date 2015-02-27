package br.com.floripark.financeiro.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TA_USUARIOS", uniqueConstraints = @UniqueConstraint(columnNames = {"ID"}))
public class Usuario implements Serializable {

    @Column(name = "ID", table = "TA_USUARIOS", nullable = false)
    @Id
    private Integer id;

    @Column(name = "NOME", table = "TA_USUARIOS", nullable = false, length = 250)
    @Basic
    private String nome;

    @Column(name = "USUARIO", table = "TA_USUARIOS", nullable = false, length = 50)
    @Basic
    private String usuario;

    @Column(name = "SENHA", table = "TA_USUARIOS", nullable = false, length = 15)
    @Basic
    private String senha;

    @ManyToOne(optional = false, targetEntity = Usuario.class)
    @JoinColumn(name = "USUARIOINCLUSAO", referencedColumnName = "ID")
    private Usuario usuarioinclusao;

    @Column(name = "DATAINCLUSAO", table = "TA_USUARIOS", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date datainclusao;

    @ManyToOne(targetEntity = Usuario.class)
    @JoinColumn(name = "USUARIOALTERACAO", referencedColumnName = "ID")
    private Usuario usuarioalteracao;

    @Column(name = "DATAALTERACAO", table = "TA_USUARIOS")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date dataalteracao;

    @OneToMany(targetEntity = Banco.class, mappedBy = "usuarioinclusao")
    private Collection<Banco> bancoCollection;

    @OneToMany(targetEntity = TipoLancamento.class, mappedBy = "usuarioinclusao")
    private Collection<TipoLancamento> tipoLancamentoCollection;

    @OneToMany(targetEntity = DataMovimento.class, mappedBy = "usuarioinclusao")
    private Collection<DataMovimento> dataMovimentoCollection;

    @OneToMany(targetEntity = Usuario.class, mappedBy = "usuarioinclusao")
    private Collection<Usuario> usuarioCollection;

    @OneToMany(targetEntity = Movimento.class, mappedBy = "usuarioinclusao")
    private Collection<Movimento> movimentoCollection;

    @OneToMany(targetEntity = Movimento.class, mappedBy = "usuarioalteracao")
    private Collection<Movimento> movimentoCollection1;

    @OneToMany(targetEntity = TipoLancamento.class, mappedBy = "usuarioalteracao")
    private Collection<TipoLancamento> tipoLancamentoCollection1;

    @OneToMany(targetEntity = Empresa.class, mappedBy = "usuarioalteracao")
    private Collection<Empresa> empresaCollection1;

    @OneToMany(targetEntity = DataMovimento.class, mappedBy = "usuarioalteracao")
    private Collection<DataMovimento> dataMovimentoCollection1;

    @OneToMany(targetEntity = GrupoCpa.class, mappedBy = "usuarioinclusao")
    private Collection<GrupoCpa> grupoCpaCollection;

    @OneToMany(targetEntity = Empresa.class, mappedBy = "usuarioinclusao")
    private Collection<Empresa> empresaCollection;

    @OneToMany(targetEntity = GrupoCpa.class, mappedBy = "usuarioalteracao")
    private Collection<GrupoCpa> grupoCpaCollection1;

    @OneToMany(targetEntity = Banco.class, mappedBy = "usuarioalteracao")
    private Collection<Banco> bancoCollection1;

    @OneToMany(targetEntity = Usuario.class, mappedBy = "usuarioalteracao")
    private Collection<Usuario> usuarioCollection1;

    public Usuario() {

    }

    public Collection<Banco> getBancoCollection() {
        return this.bancoCollection;
    }

    public void setBancoCollection(Collection<Banco> bancoCollection) {
        this.bancoCollection = bancoCollection;
    }

    public Collection<TipoLancamento> getTipoLancamentoCollection() {
        return this.tipoLancamentoCollection;
    }

    public void setTipoLancamentoCollection(Collection<TipoLancamento> tipoLancamentoCollection) {
        this.tipoLancamentoCollection = tipoLancamentoCollection;
    }

    public Date getDatainclusao() {
        return this.datainclusao;
    }

    public void setDatainclusao(Date datainclusao) {
        this.datainclusao = datainclusao;
    }

    public Collection<DataMovimento> getDataMovimentoCollection() {
        return this.dataMovimentoCollection;
    }

    public void setDataMovimentoCollection(Collection<DataMovimento> dataMovimentoCollection) {
        this.dataMovimentoCollection = dataMovimentoCollection;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<Usuario> getUsuarioCollection() {
        return this.usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    public Collection<Movimento> getMovimentoCollection() {
        return this.movimentoCollection;
    }

    public void setMovimentoCollection(Collection<Movimento> movimentoCollection) {
        this.movimentoCollection = movimentoCollection;
    }

    public Collection<Movimento> getMovimentoCollection1() {
        return this.movimentoCollection1;
    }

    public void setMovimentoCollection1(Collection<Movimento> movimentoCollection1) {
        this.movimentoCollection1 = movimentoCollection1;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Collection<TipoLancamento> getTipoLancamentoCollection1() {
        return this.tipoLancamentoCollection1;
    }

    public void setTipoLancamentoCollection1(Collection<TipoLancamento> tipoLancamentoCollection1) {
        this.tipoLancamentoCollection1 = tipoLancamentoCollection1;
    }

    public Usuario getUsuarioalteracao() {
        return this.usuarioalteracao;
    }

    public void setUsuarioalteracao(Usuario usuarioalteracao) {
        this.usuarioalteracao = usuarioalteracao;
    }

    public Collection<Empresa> getEmpresaCollection1() {
        return this.empresaCollection1;
    }

    public void setEmpresaCollection1(Collection<Empresa> empresaCollection1) {
        this.empresaCollection1 = empresaCollection1;
    }

    public Collection<DataMovimento> getDataMovimentoCollection1() {
        return this.dataMovimentoCollection1;
    }

    public void setDataMovimentoCollection1(Collection<DataMovimento> dataMovimentoCollection1) {
        this.dataMovimentoCollection1 = dataMovimentoCollection1;
    }

    public Collection<GrupoCpa> getGrupoCpaCollection() {
        return this.grupoCpaCollection;
    }

    public void setGrupoCpaCollection(Collection<GrupoCpa> grupoCpaCollection) {
        this.grupoCpaCollection = grupoCpaCollection;
    }

    public Usuario getUsuarioinclusao() {
        return this.usuarioinclusao;
    }

    public void setUsuarioinclusao(Usuario usuarioinclusao) {
        this.usuarioinclusao = usuarioinclusao;
    }

    public Collection<Empresa> getEmpresaCollection() {
        return this.empresaCollection;
    }

    public void setEmpresaCollection(Collection<Empresa> empresaCollection) {
        this.empresaCollection = empresaCollection;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Collection<GrupoCpa> getGrupoCpaCollection1() {
        return this.grupoCpaCollection1;
    }

    public void setGrupoCpaCollection1(Collection<GrupoCpa> grupoCpaCollection1) {
        this.grupoCpaCollection1 = grupoCpaCollection1;
    }

    public Collection<Banco> getBancoCollection1() {
        return this.bancoCollection1;
    }

    public void setBancoCollection1(Collection<Banco> bancoCollection1) {
        this.bancoCollection1 = bancoCollection1;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataalteracao() {
        return this.dataalteracao;
    }

    public void setDataalteracao(Date dataalteracao) {
        this.dataalteracao = dataalteracao;
    }

    public Collection<Usuario> getUsuarioCollection1() {
        return this.usuarioCollection1;
    }

    public void setUsuarioCollection1(Collection<Usuario> usuarioCollection1) {
        this.usuarioCollection1 = usuarioCollection1;
    }

}
