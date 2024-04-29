# FormatadorSOLID
## O que é?
De forma resumida, é um código simples feito em Java, que tem como objetivo a formatação textual de coisas como datas e nomes de pessoas. Foi utilizada uma biblioteca de fonte externa para estilização da interface gráfica: [FlatLaf](https://github.com/JFormDesigner/FlatLaf)
## Descrição do código fonte
* [Formatadores](src/formatadores)
  Aqui constam as classes que ocupam única e exclusivamente a função de gerar o texto formatado, bem como a classe abstrata pai.
  * [Formatador](src/formatadores/Formatador.java) - É a base dos outros formatadores, possuindo um método formatar, que recebe uma instância da classe T e retorna uma String, isto é, o texto formatado.
  * [Formatador Ano-Mês-Dia](src/formatadores/FormatadorAnoTraçoMêsTraçoDia.java) Formata uma data seguindo o formato "yyyy-MM-dd"; Implementa Formatador<Data>
  * [Formatador Dia/Mês/Ano](src/formatadores/FormatadorDiaBarraMêsBarraAno.java) Formata uma data seguindo o formato "dd/MM/yyyy"; Implementa Formatador<Data>
  * [Formatador Dia/Mês/Ano](src/formatadores/FormatadorDiaDeMêsDeAno.java) Formata uma data seguindo o formato "dd de (mês por extenso) de yyyy"; Implementa Formatador<Data>
* [UI](src/ui)
