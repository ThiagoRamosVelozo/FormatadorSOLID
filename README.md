# FormatadorSOLID
## O que é?
De forma resumida, é um código simples feito em Java, que tem como objetivo a formatação textual de coisas como datas e nomes de pessoas. Foi utilizada uma biblioteca de fonte externa para estilização da interface gráfica: [FlatLaf](https://github.com/JFormDesigner/FlatLaf)
## Como usar?
Basta executar o arquivo [FormatadorSOLID.jar](dist/FormatadorSOLID.jar) em conjunto com [a pasta de bibliotecas](dist/lib) na mesma pasta raiz.
## Descrição do código fonte
* [Formatadores](src/formatadores)
  Aqui constam as classes que ocupam única e exclusivamente a função de gerar o texto formatado, bem como a classe abstrata pai.
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
* main.Main - O programa começa nessa classe, por meio do método estático "main". Aqui é inicializado o Look and Feel por meio do LookAndFeelInitializer, instanciada e aberta a Janela.
