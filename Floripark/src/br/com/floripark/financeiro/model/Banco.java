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
@Table(name = "FN_BANCOS", uniqueConstraints = @UniqueConstraint(columnNames = {"ID"}))
public class Banco implements Serializable {

    @Column(name = "ID", table = "FN_BANCOS", nullable = false)
    @Id
    private Integer id;

    @Column(name = "NOME", table = "FN_BANCOS", nullable = false, length = 200)
    @Basic
    private String nome;

    @ManyToOne(optional = false, targetEntity = Usuario.class)
    @JoinColumn(name = "USUARIOINCLUSAO", referencedColumnName = "ID")
    private Usuario usuarioinclusao;

    @Column(name = "DATAINCLUSAO", table = "FN_BANCOS", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date datainclusao;

    @ManyToOne(targetEntity = Usuario.class)
    @JoinColumn(name = "USUARIOALTERACAO", referencedColumnName = "ID")
    private Usuario usuarioalteracao;

    @Column(name = "DATAALTERACAO", table = "FN_BANCOS")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date dataalteracao;

    @OneToMany(targetEntity = Movimento.class, mappedBy = "banco")
    private Collection<Movimento> movimentoCollection;

    public Banco() {

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

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Collection<Movimento> getMovimentoCollection() {
        return this.movimentoCollection;
    }

    public void setMovimentoCollection(Collection<Movimento> movimentoCollection) {
        this.movimentoCollection = movimentoCollection;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
