package br.com.floripark.financeiro.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "FN_RETORNOSBANCARIOS", uniqueConstraints = @UniqueConstraint(columnNames = {"ID"}))
public class RetornoBancario implements Serializable {

    @Column(name = "ID", table = "FN_RETORNOSBANCARIOS", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false, targetEntity = Banco.class)
    @JoinColumn(name = "BANCO", referencedColumnName = "ID")
    private Banco banco;

    @ManyToOne(optional = false, targetEntity = Servico.class)
    @JoinColumn(name = "SERVICO", referencedColumnName = "ID")
    private Servico servico;

    @ManyToOne(optional = false, targetEntity = Empresa.class)
    @JoinColumn(name = "EMPRESA", referencedColumnName = "ID")
    private Empresa empresa;

    @Column(name = "DATAPAGAMENTO", table = "FN_RETORNOSBANCARIOS", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date datapagamento;

    @Column(name = "ARQUIVO", table = "FN_RETORNOSBANCARIOS", nullable = false)
    @Lob
    @Basic
    private byte[] arquivo;

    @Column(name = "LINHA", table = "FN_RETORNOSBANCARIOS", nullable = false, length = 250)
    @Basic
    private String linha;

    @ManyToOne(optional = false, targetEntity = Usuario.class)
    @JoinColumn(name = "USUARIOINCLUSAO", referencedColumnName = "ID")
    private Usuario usuarioinclusao;

    @Column(name = "DATAINCLUSAO", table = "FN_RETORNOSBANCARIOS")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date datainclusao;

    @ManyToOne(targetEntity = Usuario.class)
    @JoinColumn(name = "USUARIOALTERACAO", referencedColumnName = "ID")
    private Usuario usuarioalteracao;

    @Column(name = "DATAALTERACAO", table = "FN_RETORNOSBANCARIOS")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date dataalteracao;

    @OneToMany(targetEntity = Dado.class, mappedBy = "retorno")
    private Collection<Dado> dadoCollection;

    public RetornoBancario() {

    }

    public Date getDatapagamento() {
        return this.datapagamento;
    }

    public void setDatapagamento(Date datapagamento) {
        this.datapagamento = datapagamento;
    }

    public Usuario getUsuarioalteracao() {
        return this.usuarioalteracao;
    }

    public void setUsuarioalteracao(Usuario usuarioalteracao) {
        this.usuarioalteracao = usuarioalteracao;
    }

    public Date getDatainclusao() {
        return this.datainclusao;
    }

    public void setDatainclusao(Date datainclusao) {
        this.datainclusao = datainclusao;
    }

    public Usuario getUsuarioinclusao() {
        return this.usuarioinclusao;
    }

    public void setUsuarioinclusao(Usuario usuarioinclusao) {
        this.usuarioinclusao = usuarioinclusao;
    }

    public byte[] getArquivo() {
        return this.arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }

    public String getLinha() {
        return this.linha;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }

    public Banco getBanco() {
        return this.banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Collection<Dado> getDadoCollection() {
        return this.dadoCollection;
    }

    public void setDadoCollection(Collection<Dado> dadoCollection) {
        this.dadoCollection = dadoCollection;
    }

    public Date getDataalteracao() {
        return this.dataalteracao;
    }

    public void setDataalteracao(Date dataalteracao) {
        this.dataalteracao = dataalteracao;
    }

    public Servico getServico() {
        return this.servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Empresa getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
