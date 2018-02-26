# Criar um app para consulta de API do [GitHub](https://github.com)#

Criar um app para consultar a [API do GitHub](https://developer.github.com/v3/) e trazer os repositórios mais populares de Java / Javascript / Node.JS. 

Basear-se no mockup fornecido:

![Android_test_v1_mockup.png](https://s3.amazonaws.com/vcmais-android-test/Android_test_v1_mockup.png)

### **O App DEVE conter** ###

- __Lista de repositórios__. Exemplo de chamada na API: `https://api.github.com/search/repositories?q=language:Java&sort=stars&page=1`
  * Paginação na tela de lista, com endless scroll / scroll infinito (incrementando o parâmetro `page`).
  * Cada repositório deve exibir Nome do repositório, Descrição do Repositório, Nome / Foto do autor, Número de Stars, Número de Forks
  * Ao tocar em um item, deve levar a lista de Pull Requests do repositório
- __Pull Requests de um repositório__. Exemplo de chamada na API: `https://api.github.com/repos/<criador>/<repositório>/pulls`
  * Cada item da lista deve exibir Nome / Foto do autor do PR, Título do PR, Data do PR e Body do PR
  * Ao tocar em um item, deve abrir no browser a página do Pull Request em questão

### **A solução DEVE conter** ##
* Sistema de build Gradle
* Mapeamento JSON -> Objeto (GSON / Jackson / Moshi / etc)
* Material Design
* Ser feita em Java
* Feedback para o usuário enquanto estiver carregando dados

### **Será um diferencial se a solução conter ** ###

* Framework para comunicação com API
* Testes no projeto (unitários e por tela)
* Testes funcionais (que naveguem pelo aplicativo como casos de uso)
* Cache de imagens e da API
* Suportar mudanças de orientação das telas sem perder estado
* Design Pattern
* Dagger 2

### **OBS** ###

A imagem do mockup é meramente ilustrativa.

### **Processo de submissão** ###

O candidato deverá implementar a solução e enviar um pull request para este repositório com a solução.

O processo de Pull Request funciona da seguinte maneira:

1. Fork desse repositório (não irá clonar direto!)
2. Fará seu projeto nesse fork.
3. Commitará e subirá as alterações para o __SEU__ fork.
4. Pela interface do Bitbucket, irá enviar um Pull Request.

Deixar o fork público para facilitar a inspeção do código.

### **ATENÇÃO** ###

Não se deve tentar fazer o PUSH diretamente para ESTE repositório!