package br.com.thiagolemos.models;

import javax.lang.model.type.NullType;

public class Endereco {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;

    public Endereco(EnderecoViaCep meuEnderecoViaCep) {
        this.cep = meuEnderecoViaCep.cep();
        this.logradouro = meuEnderecoViaCep.logradouro();
        this.complemento = meuEnderecoViaCep.complemento();
        this.bairro = meuEnderecoViaCep.bairro();
        this.cidade = meuEnderecoViaCep.localidade();
        this.uf = meuEnderecoViaCep.uf().toUpperCase();

    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        if (logradouro != null && !logradouro.isEmpty()) {
            return logradouro;
        }
        return "N/A";
    }

    public String getComplemento() {
        if (complemento != null && !complemento.isEmpty()) {
            return complemento;
        }
        return "N/A";
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    @Override
    public String toString() {
        return "CEP: " + getCep() +
                "\nENDEREÇO: " + getLogradouro() +
                "\nCOMPLEMENTO: " + getComplemento() +
                "\nBAIRRO: " + getBairro() +
                "\nCIDADE: " + getCidade() +
                "\nESTADO: " + getUf();
    }
}
