
package formatadores;

import modelos.Pessoa;

public class FormatadorPessoaNomeSobrenome implements Formatador<Pessoa> {

    @Override
    public String formatar(Pessoa pessoa) {
        return pessoa.getNome() + " " + pessoa.getSobrenome();
    }
    
}
