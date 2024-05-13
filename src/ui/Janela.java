package ui;

import formatadores.Formatador;
import formatadores.FormatadorAnoTraçoMêsTraçoDia;
import formatadores.FormatadorDiaBarraMêsBarraAno;
import formatadores.FormatadorDiaDeMêsDeAno;
import formatadores.FormatadorPessoaIniciais;
import formatadores.FormatadorPessoaNomeSobrenome;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import modelos.Data;
import modelos.Pessoa;
import ui.paineis.PainelData;
import ui.paineis.PainelPessoa;

public class Janela extends JFrame {
    
    private static Janela instance;
    
    public static Janela getInstance() {
        if (instance == null) instance = new Janela();
        return instance;
    }
    
    JTabbedPane tabs;
    ArrayList<Formatador<Data>> formatadoresData;
    ArrayList<Formatador<Pessoa>> formatadoresPessoa;

    private Janela() {
        
        tabs = new JTabbedPane(JTabbedPane.LEFT);
        
        formatadoresData = new ArrayList<>();
        formatadoresData.add(new FormatadorAnoTraçoMêsTraçoDia());
        formatadoresData.add(new FormatadorDiaBarraMêsBarraAno());
        formatadoresData.add(new FormatadorDiaDeMêsDeAno());
        
        tabs.add(new PainelData(formatadoresData, new String[]{"ano-mês-dia", "dia/mês/ano", "dia de mês de ano"}), "Datas");
        
        formatadoresPessoa = new ArrayList<>();
        formatadoresPessoa.add(new FormatadorPessoaNomeSobrenome());
        formatadoresPessoa.add(new FormatadorPessoaIniciais());
        
        tabs.add(new PainelPessoa(formatadoresPessoa, new String[]{"nome sobrenome", "iniciais"}), "Pessoa");
        
        setContentPane(tabs);
        setTitle("Formatador");
        setSize(512, 512);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
