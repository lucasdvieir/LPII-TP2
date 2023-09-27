import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormPessoa extends JFrame {
    private JTextField txtNumero, txtNome, txtSexo, txtIdade;
    private JButton btnOK, btnLimpar, btnMostrar, btnSair;
    private ArrayList<Pessoa> listaPessoas;

    public FormPessoa() {
        setSize(360, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Formulário Pessoa");

        listaPessoas = new ArrayList<>();

        JPanel panel = new JPanel(new BorderLayout());

        JPanel labelsPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        labelsPanel.add(new JLabel("Número:"));
        labelsPanel.add(new JLabel("Nome:"));
        labelsPanel.add(new JLabel("Sexo:"));
        labelsPanel.add(new JLabel("Idade:"));

        JPanel fieldsPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        txtNumero = new JTextField();
        txtNumero.setEditable(false);
        fieldsPanel.add(txtNumero);
        txtNome = new JTextField();
        fieldsPanel.add(txtNome);
        txtSexo = new JTextField();
        fieldsPanel.add(txtSexo);
        txtIdade = new JTextField();
        fieldsPanel.add(txtIdade);

        panel.add(labelsPanel, BorderLayout.WEST);
        panel.add(fieldsPanel, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnOK = new JButton("OK");
        btnLimpar = new JButton("Limpar");
        btnMostrar = new JButton("Mostrar");
        btnSair = new JButton("Sair");
        buttonsPanel.add(btnOK);
        buttonsPanel.add(btnLimpar);
        buttonsPanel.add(btnMostrar);
        buttonsPanel.add(btnSair);

        panel.add(buttonsPanel, BorderLayout.SOUTH);

        add(panel);

        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Pessoa umaPessoa = new Pessoa();
                umaPessoa.setNome(txtNome.getText());
                umaPessoa.setSexo(txtSexo.getText().charAt(0));
                umaPessoa.setIdade(Integer.parseInt(txtIdade.getText()));
                txtNumero.setText(String.valueOf(Pessoa.getKp()));
                listaPessoas.add(umaPessoa);
                limparCampos();
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });

        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!listaPessoas.isEmpty()) {
                    StringBuilder mensagem = new StringBuilder("Lista de Pessoas:\n\n");
                    int numeroPessoa = 1;
                    for (Pessoa pessoa : listaPessoas) {
                        mensagem.append("Pessoa ").append(numeroPessoa).append(":\n");
                        mensagem.append("Número: ").append(Pessoa.getKp()).append("\n");
                        mensagem.append("Nome: ").append(pessoa.getNome()).append("\n");
                        mensagem.append("Sexo: ").append(pessoa.getSexo()).append("\n");
                        mensagem.append("Idade: ").append(pessoa.getIdade()).append("\n\n");
                        numeroPessoa++;
                    }
                    JOptionPane.showMessageDialog(null, mensagem.toString(), "Dados das Pessoas", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhuma pessoa foi inserida.", "Dados das Pessoas", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void limparCampos() {
        txtNome.setText("");
        txtSexo.setText("");
        txtIdade.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FormPessoa form = new FormPessoa();
            form.setVisible(true);
        });
    }
}
