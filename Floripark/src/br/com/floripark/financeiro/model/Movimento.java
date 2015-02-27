package br.com.floripark.financeiro.model;


import java.io.Serializable;

import java.lang.Integer;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="FN_MOVIMENTOS",uniqueConstraints=@UniqueConstraint(columnNames={"ID"}))
public  class Movimento implements Serializable {


    @ManyToOne(targetEntity=Usuario.class)
    @JoinColumn(name="USUARIOALTERACAO",referencedColumnName="ID")
    private Usuario usuarioalteracao;


    @ManyToOne(optional=false,targetEntity=DataMovimento.class)
    @JoinColumn(name="DATAMOVIMENTO",referencedColumnName="ID")
    private DataMovimento datamovimento;


    @ManyToOne(optional=false,targetEntity=TipoLancamento.class)
    @JoinColumn(name="TIPOLANCAMENTO",referencedColumnName="ID")
    private TipoLancamento tipolancamento;


    @Column(name="DATAINCLUSAO",table="FN_MOVIMENTOS",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date datainclusao;


    @ManyToOne(optional=false,targetEntity=Usuario.class)
    @JoinColumn(name="USUARIOINCLUSAO",referencedColumnName="ID")
    private Usuario usuarioinclusao;


    @Column(name="VALOR",table="FN_MOVIMENTOS",nullable=false,scale=2,precision=18)
    @Basic
    private BigDecimal valor;


    @ManyToOne(optional=false,targetEntity=Banco.class)
    @JoinColumn(name="BANCO",referencedColumnName="ID")
    private Banco banco;


    @Column(name="ID",table="FN_MOVIMENTOS",nullable=false)
    @Id
    private Integer id;


    @Column(name="DATAALTERACAO",table="FN_MOVIMENTOS")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date dataalteracao;


    @ManyToOne(optional=false,targetEntity=Empresa.class)
    @JoinColumn(name="EMPRESA",referencedColumnName="ID")
    private Empresa empresa;


    @ManyToOne(optional=false,targetEntity=GrupoCpa.class)
    @JoinColumn(name="GRUPOCPA",referencedColumnName="ID")
    private GrupoCpa grupocpa;

    public Movimento(){

    }


   public Usuario getUsuarioalteracao() {
        return this.usuarioalteracao;
    }


  public void setUsuarioalteracao (Usuario usuarioalteracao) {
        this.usuarioalteracao = usuarioalteracao;
    }



   public DataMovimento getDatamovimento() {
        return this.datamovimento;
    }


  public void setDatamovimento (DataMovimento datamovimento) {
        this.datamovimento = datamovimento;
    }



   public TipoLancamento getTipolancamento() {
        return this.tipolancamento;
    }


  public void setTipolancamento (TipoLancamento tipolancamento) {
        this.tipolancamento = tipolancamento;
    }



   public Date getDatainclusao() {
        return this.datainclusao;
    }


  public void setDatainclusao (Date datainclusao) {
        this.datainclusao = datainclusao;
    }



   public Usuario getUsuarioinclusao() {
        return this.usuarioinclusao;
    }


  public void setUsuarioinclusao (Usuario usuarioinclusao) {
        this.usuarioinclusao = usuarioinclusao;
    }



   public BigDecimal getValor() {
        return this.valor;
    }


  public void setValor (BigDecimal valor) {
        this.valor = valor;
    }



   public Banco getBanco() {
        return this.banco;
    }


  public void setBanco (Banco banco) {
        this.banco = banco;
    }



   public Integer getId() {
        return this.id;
    }


  public void setId (Integer id) {
        this.id = id;
    }



   public Date getDataalteracao() {
        return this.dataalteracao;
    }


  public void setDataalteracao (Date dataalteracao) {
        this.dataalteracao = dataalteracao;
    }



   public Empresa getEmpresa() {
        return this.empresa;
    }


  public void setEmpresa (Empresa empresa) {
        this.empresa = empresa;
    }



   public GrupoCpa getGrupocpa() {
        return this.grupocpa;
    }


  public void setGrupocpa (GrupoCpa grupocpa) {
        this.grupocpa = grupocpa;
    }

}

