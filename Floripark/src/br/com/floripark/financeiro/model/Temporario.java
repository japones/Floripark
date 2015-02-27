package br.com.floripark.financeiro.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TEMPORARIO")
public class Temporario implements Serializable {

    @Column(name="ID",table="TEMPORARIO",nullable=false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="DADOS",table="TEMPORARIO",nullable=false,length=250)
    @Basic
    private String dados;

    public Temporario() {

    }
   
    public String getDados() {
        return this.dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }
   
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
