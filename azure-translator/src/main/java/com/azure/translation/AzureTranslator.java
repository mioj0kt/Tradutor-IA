package com.azure.translation;

import java.util.Scanner;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AzureTranslator {
    // Chave da API e Endpoint
    private static final String subscriptionKey = "9f33edb503e54a2b885bd25c9fafae5c";
    private static final String endpoint = "https://api.cognitive.microsofttranslator.com/";

    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(System.in);

    	Menu();
    	int opt = sc.nextInt();
    	sc.nextLine(); // Limpando a quebra de linha deixada pelo nextInt
    	
    	String idiomaDestino = "";
    	if (opt == 1) {
    		idiomaDestino = "en"; // Código para inglês
    	} else if (opt == 2) {
        	idiomaDestino = "pt"; // Código para português
        }
    	
    	System.out.println();
    	System.out.println("Digite o texto para ser traduzido:");
    	
    	String texto = sc.nextLine();
    	System.out.println();
    	
        // Chamando o método para traduzir o texto
        String resultado = traduzirTexto(texto, idiomaDestino);
        System.out.println("Texto traduzido: " + resultado);
        sc.close();
    }

    public static void Menu() {
    	System.out.println("Como deseja traduzir?");
    	System.out.println("1) Português para inglês.");
    	System.out.println("2) Inglês para poruguês.");
    	System.out.println();
    	System.out.print("Digite o número da opção desejada:");
    }
    
    public static String traduzirTexto(String texto, String idiomaDestino) throws Exception {
        // Montar a URL de tradução
        String url = endpoint + "/translate?api-version=3.0&to=" + idiomaDestino;

        // Corpo da requisição (formato JSON)
        String body = "[{\"Text\":\"" + texto + "\"}]";

        // Criar o cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Criar a requisição HTTP POST
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Ocp-Apim-Subscription-Key", subscriptionKey)
                .header("Content-Type", "application/json")
                .header("Ocp-Apim-Subscription-Region", "brazilsouth")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        // Enviar a requisição e receber a resposta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Processar a resposta e retornar o texto traduzido
        return processarResposta(response.body());
    }

    private static String processarResposta(String resposta) {
        // O retorno é um JSON; aqui, de forma simplificada, pegamos o valor traduzido
        int start = resposta.indexOf("text\":\"") + 7;
        int end = resposta.indexOf("\"", start);
        return resposta.substring(start, end);
    }
}
