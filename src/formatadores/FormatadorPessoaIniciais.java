
package formatadores;

import modelos.Pessoa;

public class FormatadorPessoaIniciais implements Formatador<Pessoa> {

    @Override
    public String formatar(Pessoa pessoa) {
        String formatado = Character.toString(pessoa.getNome().charAt(0));
        String[] partesSobrenome = pessoa.getSobrenome().split(" ");
        for (String parteSobrenome : partesSobrenome) {
            formatado += parteSobrenome.charAt(0);
        }
        return formatado;
    }
    
}
