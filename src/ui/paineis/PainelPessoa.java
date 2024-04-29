package ui.paineis;

import formatadores.Formatador;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import modelos.Pessoa;

public class PainelPessoa extends JPanel {

    JPanel interno;
    JTextField campoCPF, campoNome, campoSobrenome;
    JComboBox campoFormato;
    JButton botaoSubmeter;
    JLabel formatado;

    public PainelPessoa(ArrayList<Formatador<Pessoa>> formatadores, String[] nomes) {

        setLayout(new GridBagLayout());

        interno = new JPanel(new GridLayout(12, 1));
        campoCPF = new JTextField();
        campoNome = new JTextField();
        campoSobrenome = new JTextField();
        campoFormato = new JComboBox(nomes);
        botaoSubmeter = new JButton("Submeter");
        formatado = new JLabel();

        interno.add(new JLabel("CPF:"));
        interno.add(campoCPF);
        interno.add(new JLabel("Nome:"));
        interno.add(campoNome);
        interno.add(new JLabel("Sobrenome:"));
        interno.add(campoSobrenome);
        interno.add(new JLabel("Formato:"));
        interno.add(campoFormato);
        interno.add(new JLabel());
        interno.add(botaoSubmeter);
        interno.add(new JLabel("Formatado:"));
        interno.add(formatado);

        botaoSubmeter.addActionListener(a -> {
            String cpf = campoCPF.getText();
            String nome = campoNome.getText();
            String sobrenome = campoSobrenome.getText();
            formatado.setText(formatadores.get(campoFormato.getSelectedIndex()).formatar(new Pessoa(cpf, nome, sobrenome)));
        });

        add(interno);

    }

}
