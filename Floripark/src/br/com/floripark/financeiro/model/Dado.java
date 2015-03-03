package br.com.floripark.financeiro.model;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="FN_DADOS",uniqueConstraints=@UniqueConstraint(columnNames={"ID"}))
public class Dado implements Serializable {

    @Column(name="ID",table="FN_DADOS",nullable=false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="LINHA",table="FN_DADOS",length=240)
    @Basic
    private String linha;

    @ManyToOne(optional=false,targetEntity = RetornoBancario.class)
    @JoinColumn(name="RETORNO",referencedColumnName="ID")
    private RetornoBancario retorno;

    @ManyToOne(optional=false,targetEntity = Usuario.class)
    @JoinColumn(name="USUARIOINCLUSAO",referencedColumnName="ID")
    private Usuario usuarioinclusao;

    @Column(name="DATAINCLUSAO",table="FN_DADOS")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date datainclusao;

    @ManyToOne(targetEntity = Usuario.class)
    @JoinColumn(name="USUARIOALTERACAO",referencedColumnName="ID")
    private Usuario usuarioalteracao;

    @Column(name="DATAALTERACAO",table="FN_DADOS")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date dataalteracao;

    public Dado() {

    }
   
    public RetornoBancario getRetorno() {
        return this.retorno;
    }

    public void setRetorno(RetornoBancario retorno) {
        this.retorno = retorno;
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
   
    public String getLinha() {
        return this.linha;
    }

    public void setLinha(String linha) {
        this.linha = linha;
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
}
