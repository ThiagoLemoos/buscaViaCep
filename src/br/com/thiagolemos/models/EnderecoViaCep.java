package br.com.thiagolemos.models;

public record EnderecoViaCep(String cep, String logradouro, String complemento, String bairro, String localidade, String uf) {
}
