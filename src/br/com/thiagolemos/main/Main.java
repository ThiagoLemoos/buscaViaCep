package br.com.thiagolemos.main;

import br.com.thiagolemos.models.Endereco;
import br.com.thiagolemos.models.EnderecoViaCep;
import br.com.thiagolemos.services.Conexao;
import br.com.thiagolemos.services.Menu;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(Menu.printMenu());

        Scanner leitura = new Scanner(System.in);
        String cepDigitado = leitura.nextLine();

        List<Endereco> lista = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        try {


            String json = Conexao.buscarCep(cepDigitado);

            EnderecoViaCep meuEnderecoViaCep = gson.fromJson(json, EnderecoViaCep.class);
            Endereco meuEndereco = new Endereco(meuEnderecoViaCep);

            System.out.println(meuEndereco);
            lista.add(meuEndereco);

        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        FileWriter write = new FileWriter("listaCep.json");
        write.write(gson.toJson(lista));
        write.close();

    }
}