package ui.paineis;

import formatadores.Formatador;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import modelos.Data;

public class PainelData extends JPanel {

    JPanel interno;
    JSpinner campoDia, campoMês, campoAno;
    JComboBox campoFormato;
    JButton botaoSubmeter;
    JLabel formatado;

    public PainelData(ArrayList<Formatador<Data>> formatadores, String[] nomes) {

        setLayout(new GridBagLayout());

        interno = new JPanel(new GridLayout(12, 1));
        campoDia = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
        campoMês = new JSpinner(new SpinnerNumberModel(1, 1, 12, 1));
        campoAno = new JSpinner(new SpinnerNumberModel(2000, 1, Integer.MAX_VALUE, 1));
        campoFormato = new JComboBox(nomes);
        botaoSubmeter = new JButton("Submeter");
        formatado = new JLabel();

        interno.add(new JLabel("Dia:"));
        interno.add(campoDia);
        interno.add(new JLabel("Mês:"));
        interno.add(campoMês);
        interno.add(new JLabel("Ano:"));
        interno.add(campoAno);
        interno.add(new JLabel("Formato:"));
        interno.add(campoFormato);
        interno.add(new JLabel());
        interno.add(botaoSubmeter);
        interno.add(new JLabel("Formatado:"));
        interno.add(formatado);

        botaoSubmeter.addActionListener(a -> {
            int dia = (int) campoDia.getValue();
            int mês = (int) campoMês.getValue();
            int ano = (int) campoAno.getValue();
            formatado.setText(formatadores.get(campoFormato.getSelectedIndex()).formatar(new Data(dia, mês, ano)));
        });

        add(interno);

    }

}
