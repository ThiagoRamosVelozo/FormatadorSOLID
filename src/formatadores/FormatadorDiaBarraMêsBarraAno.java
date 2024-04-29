
package formatadores;

import modelos.Data;

public class FormatadorDiaBarraMêsBarraAno implements Formatador <Data> {

    @Override
    public String formatar(Data data) {
        
        return data.getDia() + "/" + data.getMes() + "/" + data.getAno();
        
    }
    
}
