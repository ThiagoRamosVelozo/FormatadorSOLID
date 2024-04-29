
package formatadores;

import modelos.Data;

public class FormatadorDiaDeMêsDeAno implements Formatador <Data> {
    
    private static String[] mesesPorExtenso = {
      "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", 
      "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"  
    };

    @Override
    public String formatar(Data data) {
        
        return data.getDia() + " de " + mesesPorExtenso[data.getMes() - 1] + " de " + data.getAno();
        
    }
    
}
