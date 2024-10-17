# Azure Translator - Projeto de Tradução Automática

Este projeto é um exemplo simples de integração com a API de Tradução do Azure, que permite traduzir textos entre português e inglês. A aplicação é desenvolvida em Java e utiliza a biblioteca `java.net.http.HttpClient` para enviar requisições HTTP e processar as respostas da API.

## Funcionalidades ✨

- Tradução de textos de português para inglês.
- Tradução de textos de inglês para português.

## Como Executar 🚀

1. Clone o repositório para o seu ambiente local:
   ```
   git clone https://github.com/seu-usuario/azure-translator.git
   cd azure-translator

2. Compile o projeto com o seguinte comando:

   ```
   javac -d bin src/com/azure/translation/AzureTranslator.java

3. Execute o projeto:

   ```
   java -cp bin com.azure.translation.AzureTranslator
   
4. Siga as instruções do menu para selecionar o idioma de tradução e fornecer o texto a ser traduzido.

## Estrutura do Projeto 📂

   ```
   azure-translator/
   │
   ├── src/
   │   └── com/
   │       └── azure/
   │           └── translation/
   │               └── AzureTranslator.java   # Arquivo principal do projeto
   │
   └── README.md                              # Documentação do projeto
  ```

## Exemplo de Uso 📝

   ```
   Como deseja traduzir?
   1) Português para inglês.
   2) Inglês para português.

   Digite o número da opção desejada:
   ```

Após selecionar a opção, insira o texto que deseja traduzir, e o programa retornará o texto traduzido usando a API do Azure Translator.
