package main.java.br.edu.ifpb.domain;

import java.io.Serializable;
import java.util.Objects;

// Em resumo, a importação import java.io.Serializable; não é usada diretamente no código, mas a implementação da interface Serializable na classe 
// Contato permite que os objetos dessa classe sejam serializados.

public class Contato implements Serializable {
    private String nome;
    private String sobrenome;
    private boolean ligacao;
    private boolean chamadaVideo;
    private String categoria;
    private String tipoDeEntrada;
    private String valorDaEntrada;
    private String redeSocial;


    // construtor
    public Contato(String nome, String sobrenome, boolean ligacao, boolean chamadaVideo, String categoria,
            String tipoDeEntrada, String valorDaEntrada, String redeSocial) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.ligacao = ligacao;
        this.chamadaVideo = chamadaVideo;
        this.categoria = categoria;
        this.tipoDeEntrada = tipoDeEntrada;
        this.valorDaEntrada = valorDaEntrada;
        this.redeSocial = redeSocial;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contato contato = (Contato) obj;
        return Objects.equals(this.tipoDeEntrada, contato.tipoDeEntrada) &&
            Objects.equals(this.valorDaEntrada, contato.valorDaEntrada);
            // compara se o contato tem o mesmo tipo de entrada e o mesmo valor da entrada
    }

    public String toString() {
        return "Nome:" + getNome() + " Sobrenome:" + getSobrenome() + " Recebe Ligação?" + isLigacao() + " Essa ligação pode ser uma chamada de vídeo?" + 
        isChamadaVideo() + " Rede social: " + getRedeSocial() + " Dado específico: " + getValorDaEntrada() + " Categoria: " + getCategoria();
    }

    // sobrescrita

    @Override
    public int hashCode() {
        return Objects.hash(getValorDaEntrada());
    }

    // setters e getters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public boolean isLigacao() {
        return ligacao;
    }

    public void setLigacao(boolean ligacao) {
        this.ligacao = ligacao;
    }

    public boolean isChamadaVideo() {
        return chamadaVideo;
    }

    public void setChamadaVideo(boolean chamadaVideo) {
        this.chamadaVideo = chamadaVideo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipoDeEntrada() {
        return tipoDeEntrada;
    }

    public void setTipoDeEntrada(String tipoDeEntrada) {
        this.tipoDeEntrada = tipoDeEntrada;
    }

    public String getValorDaEntrada() {
        return valorDaEntrada;
    }

    public void setValorDaEntrada(String valorDaEntrada) {
        this.valorDaEntrada = valorDaEntrada;
    }

    public String getRedeSocial() {
        return redeSocial;
    }

    public void setRedeSocial(String redeSocial) {
        this.redeSocial = redeSocial;
    }

    // Este método está calculando o código hash (um valor numérico) com base apenas
    // no atributo número
    // do objeto Contato. Isso significa que, se dois Contatos tiverem o mesmo
    // número,
    // eles terão o mesmo código hash, o que é desejável para garantir que objetos
    // com o
    // mesmo número sejam considerados iguais ao serem inseridos em estruturas de
    // dados que dependem
    // do código hash, como HashSetouHashMap`.
}