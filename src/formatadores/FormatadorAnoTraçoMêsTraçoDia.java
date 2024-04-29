
package formatadores;

import modelos.Data;

public class FormatadorAnoTraçoMêsTraçoDia implements Formatador <Data> {

    @Override
    public String formatar(Data data) {
        
        return data.getAno() + "-" + data.getMes() + "-" + data.getDia();
        
    }
    
}
