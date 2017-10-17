/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;

/**
 *
 * @author marcello
 */
public class Produto {
    private int idProduto;
    private String descricao;
    private TipoProduto tipo;
    private String unidadeEmbalagem;
    private String unidadeConteudo;
    private Double conteudo;
    private Double valorVenda;
    private Date dataCadastro;
    private Date dataAltera;
    private Usuario usuario;
    private Fornecedor fornecedor;

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoProduto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProduto tipo) {
        this.tipo = tipo;
    }

    public String getUnidadeEmbalagem() {
        return unidadeEmbalagem;
    }

    public void setUnidadeEmbalagem(String unidadeEmbalagem) {
        this.unidadeEmbalagem = unidadeEmbalagem;
    }

    public String getUnidadeConteudo() {
        return unidadeConteudo;
    }

    public void setUnidadeConteudo(String unidadeConteudo) {
        this.unidadeConteudo = unidadeConteudo;
    }

    public Double getConteudo() {
        return conteudo;
    }

    public void setConteudo(Double conteudo) {
        this.conteudo = conteudo;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataAltera() {
        return dataAltera;
    }

    public void setDataAltera(Date dataAltera) {
        this.dataAltera = dataAltera;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    

}
