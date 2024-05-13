# FormatadorSOLID
## O que é?
De forma resumida, é um código simples feito em Java, que tem como objetivo a formatação textual de coisas como datas e nomes de pessoas. Foi utilizada uma biblioteca de fonte externa para estilização da interface gráfica: [FlatLaf](https://github.com/JFormDesigner/FlatLaf)
## Como usar?
Basta executar o arquivo [FormatadorSOLID.jar](dist/FormatadorSOLID.jar) em conjunto com [a pasta de bibliotecas](dist/lib) na mesma pasta raiz.
## Descrição do código fonte
* [Modelos](src/modelos) - Classes modelo típicas (Data e Pessoa).
* [Formatadores](src/formatadores) -
  Aqui constam as classes que ocupam única e exclusivamente a função de gerar o texto formatado, bem como a interface pai.
  * [Formatador](src/formatadores/Formatador.java) - É a base dos outros formatadores, possuindo um método formatar, que recebe uma instância da classe T e retorna uma String, isto é, o texto formatado.
  * [Formatador Ano-Mês-Dia](src/formatadores/FormatadorAnoTraçoMêsTraçoDia.java) - Formata uma data seguindo o formato "yyyy-MM-dd"; Implementa Formatador&lt;Data&gt;.
  * [Formatador Dia/Mês/Ano](src/formatadores/FormatadorDiaBarraMêsBarraAno.java) - Formata uma data seguindo o formato "dd/MM/yyyy"; Implementa Formatador&lt;Data&gt;.
  * [Formatador Dia de Mês de Ano](src/formatadores/FormatadorDiaDeMêsDeAno.java) - Formata uma data seguindo o formato "dd de (mês por extenso) de yyyy"; Implementa Formatador&lt;Data&gt;.
  * [Formatador Iniciais da Pessoa](src/formatadores/FormatadorPessoaIniciais.java) - "Formata uma pessoa" a partir de suas iniciais no nome completo; Implementa Formatador&lt;Pessoa&gt;.
  * [Formatador Nome e Sobrenome](src/formatadores/FormatadorPessoaNomeSobrenome.java) - "Formata uma pessoa" juntando nome e sobrenome; Implementa Formatador&lt;Pessoa&gt;.
* [UI](src/ui) - Contém as classes relacionadas à interface gráfica.
  * [Janela](src/ui/Janela.java) - Classe estendendo JFrame, é essencialmente onde é definida a janela. Também é nessa classe que são instanciados os painéis e definido o layout geral em tabs.
  * [Inicializador de Look and Feel](src/ui/LookAndFeelInitializer.java) - Classe responsável pela inicialização do "Look and Feel" e ajustes nesse mesmo.
  * [Painéis](src/ui/paineis) - Pacote no qual constam painéis (JPanel) que serão instanciados e inclusos pela Janela na GUI.
    * [Painel de formatação de datas](src/ui/paineis/PainelData.java) - Painel que consiste em um formulário de entrada de atributos da data (dia, mês, ano) e formato, e botão para apresentar a data formatada logo abaixo.
    * [Painel de formatação de pessoas](src/ui/paineis/PainelPessoa.java) - Painel que consiste em um formulário de entrada de atributos da pessoa (CPF, nome, sobrenome) e formato, e botão para apresentar a pessoa "formatada" logo abaixo.
* [main.Main](src/main/Main.java) - O programa começa nessa classe, por meio do método estático "main". Aqui é inicializado o Look and Feel por meio do LookAndFeelInitializer, instanciada e aberta a Janela.
## Exemplos de princípios SOLID sendo seguidos no código
### Single Responsibility Principle
* Na classe Formatador esse princípio é aplicado pois as funcionalidades descritas no formatador tem responsabilidade única, sem incoerências ou "parafernalhas multiuso": formatar objetos.
* Na classe LookAndFeelInitializer esse princípio é seguido pois seus métodos (init()) tem um objetivo único, que é inicializar o estilo.
* Isso confere maior consistência e solidez (e também torna o código mais limpo a medida que quebra as responsabilidades entre mais classes).
### Open-Closed Principle
* A interface Formatador, como interface "base", permite a extensão da sua funcionalidade crua "formatar", sem exigir alteração. Propõe um contrato e permite diferentes implementações de formatação.
### Interface Segregation Principle
* A interface Formatador possibilita a implementação da formatação para vários tipos de objeto (por meio de Generics) e assim retira a necessidade de implementar um Formatador base específico para cada tipo de objeto.
### Liskov Substitution Principle
* Devido a existência do contrato proposto em "formatar(T objeto)" entre diferentes classes, é possível, por exemplo, substituir um FormatadorPessoaIniciais por FormatadorPessoaNomeSobrenome sem maiores danos ou retrabalho.
## 3 Design Patterns utilizados
### Composite
Esse padrão é abundantemente usado nas classes de GUI do programa, visto que todo componente gráfico herda de uma mesma classe "Component/JComponent" e podem conter outros componentes (JPanel sendo um exemplo por excelência). O uso desse padrão se faz crucial, uma vez que permite criar componentes como composições de outros, do exato modo que as interfaces gráficas são construídas. Em um cenário em que essa composição não existe cada componente ficaria isolado, tornando muito mais trabalhosa e disfuncional a montagem da interface, ou até mesmo inviável.

![image](https://github.com/ThiagoRamosVelozo/FormatadorSOLID/assets/87590852/ffd612bb-074e-4fa3-891a-e53411967540)

<sup>https://en.wikipedia.org/wiki/Composite_pattern#/media/File:Composite_UML_class_diagram_(fixed).svg</sup>

### Singleton
A classe Janela possui um método estático "getInstance()" que retorna sempre a mesma instância da classe, que é inicializada como nula e só é criada uma vez no método, se ainda não existir. Isso garante que, durante toda a execução do programa, haverá apenas uma única instância, proporcionando um único ponto de acesso global para essa funcionalidade.

![image](https://github.com/ThiagoRamosVelozo/FormatadorSOLID/assets/87590852/6656ef98-f88f-4ab0-8ff5-e75f3f8e4204)

<sup>https://en.m.wikipedia.org/wiki/File:Singleton_pattern_uml.png</sup>

### Observer
Para conferir funcionalidade aos botões, por exemplo, utiliza-se do método "addActionListener", que associa um "Listener" ao evento do clique do botão. Isso é essencialmente uma implementação análoga do padrão Observer. O listener "escuta" a um dado evento e invoca um método ao "percebê-lo". Observa-se aqui a proposta básica desse padrão, algo nota um evento, desencadeando em uma ação.

![image](https://github.com/ThiagoRamosVelozo/FormatadorSOLID/assets/87590852/8c31acca-87d6-4c98-b77f-65ece9de7d5b)

<sup>https://pt.wikipedia.org/wiki/Observer#/media/Ficheiro:Observer.svg</sup>
