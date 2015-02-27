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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "FN_SERVICOS", uniqueConstraints = @UniqueConstraint(columnNames = {"ID"}))
public class Servico implements Serializable {

    @Column(name = "ID", table = "FN_SERVICOS", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "DESCRICAO", table = "FN_SERVICOS", nullable = false, length = 50)
    @Basic
    private String descricao;

    @Column(name = "SIGLA", table = "FN_SERVICOS", nullable = false)
    @Basic
    private Character sigla;

    @ManyToOne(optional = false, targetEntity = Usuario.class)
    @JoinColumn(name = "USUARIOINCLUSAO", referencedColumnName = "ID")
    private Usuario usuarioinclusao;

    @Column(name = "DATAINCLUSAO", table = "FN_SERVICOS")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date datainclusao;

    @ManyToOne(targetEntity = Usuario.class)
    @JoinColumn(name = "USUARIOALTERACAO", referencedColumnName = "ID")
    private Usuario usuarioalteracao;

    @Column(name = "DATAALTERACAO", table = "FN_SERVICOS")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date dataalteracao;

    @OneToMany(targetEntity = RetornoBancario.class, mappedBy = "servico")
    private Collection<RetornoBancario> retornoBancarioCollection;

    public Servico() {

    }

    public Character getSigla() {
        return this.sigla;
    }

    public void setSigla(Character sigla) {
        this.sigla = sigla;
    }

    public Collection<RetornoBancario> getRetornoBancarioCollection() {
        return this.retornoBancarioCollection;
    }

    public void setRetornoBancarioCollection(Collection<RetornoBancario> retornoBancarioCollection) {
        this.retornoBancarioCollection = retornoBancarioCollection;
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

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return getDescricao();
    }
}
