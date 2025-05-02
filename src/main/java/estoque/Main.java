package estoque;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        var conexao = Conexao.obterConexao();
        if (conexao != null) {
            System.out.println("\nConectado com sucesso!\n");
        } else {
            System.out.println("\nErro ao conectar-se!\n");
            return;
        }

        // Tela Inicial
        JFrame TelaInicial = new JFrame("Sistema de Estoque");
        TelaInicial.setSize(600, 500);
        TelaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TelaInicial.setLocationRelativeTo(null);
        TelaInicial.setLayout(null);

        // Texto de boas-vindas
        JTextArea BemVindo = new JTextArea("Bem-vindo ao estoque!");
        BemVindo.setEditable(false);
        BemVindo.setBounds(175, 23, 540, 50);
        BemVindo.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
        BemVindo.setHighlighter(null);
        BemVindo.setOpaque(false);
        BemVindo.setLineWrap(true);
        BemVindo.setWrapStyleWord(true);
        TelaInicial.add(BemVindo);

        // Campo de busca
        JTextArea Buscar = new JTextArea("Buscar item por nome:");
        Buscar.setEditable(false);
        Buscar.setBounds(19, 70, 200, 100);
        Buscar.setHighlighter(null);
        Buscar.setOpaque(false);
        Buscar.setLineWrap(true);
        Buscar.setWrapStyleWord(true);
        TelaInicial.add(Buscar);

        JTextField Digitar = new JTextField();
        Digitar.setBounds(150, 70, 150, 20);
        TelaInicial.add(Digitar);

        JButton buscar = new JButton("Buscar");
        buscar.setBounds(310, 70, 100, 20);
        TelaInicial.add(buscar);

        // Botão adicionar
        JButton adicionar = new JButton("Adicionar");
        adicionar.setBounds(26, 415, 100, 20);
        TelaInicial.add(adicionar);

        // Tabela de produtos
        String[] colunas = {"ID", "Nome", "Preço", "Categoria", "Quantidade", "Validade"};
        Object[][] dados = {
            {1, "Arroz", 15.50, "Alimento", 100, "2025-12-01"},
            {2, "Feijão", 7.30, "Alimento", 200, "2025-06-15"},
            {3, "Macarrão", 4.99, "Alimento", 150, "2024-10-10"},
            {4, "Açúcar", 5.20, "Alimento", 80, "2025-07-22"}
        };

        DefaultTableModel model = new DefaultTableModel(dados, colunas);
        JTable tabela = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(20, 100, 550, 300);
        TelaInicial.add(scrollPane);

        // Listener para botão adicionar
        adicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame TelaAdicionar = new JFrame("Adicionar Produto");
                TelaAdicionar.setSize(600, 500);
                TelaAdicionar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                TelaAdicionar.setLocationRelativeTo(null);
                TelaAdicionar.setLayout(null);
                TelaAdicionar.setVisible(true);
                TelaInicial.dispose();

                JLabel titulo = new JLabel("Adicionar novo item:");
                titulo.setBounds(175, 35, 540, 50);
                titulo.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
                TelaAdicionar.add(titulo);

                // Campos de entrada
                JLabel textnome = new JLabel("Nome:");
                textnome.setBounds(110, 115, 100, 20);
                TelaAdicionar.add(textnome);
                JTextField nome = new JTextField();
                nome.setBounds(110, 140, 150, 20);
                TelaAdicionar.add(nome);

                JLabel textquantidade = new JLabel("Quantidade:");
                textquantidade.setBounds(110, 175, 100, 20);
                TelaAdicionar.add(textquantidade);
                JTextField quantidade = new JTextField();
                quantidade.setBounds(110, 200, 150, 20);
                TelaAdicionar.add(quantidade);

                JLabel textvalidade = new JLabel("Validade:");
                textvalidade.setBounds(110, 235, 100, 20);
                TelaAdicionar.add(textvalidade);
                JTextField validade = new JTextField();
                validade.setBounds(110, 260, 150, 20);
                TelaAdicionar.add(validade);

                JLabel textpreco = new JLabel("Preço:");
                textpreco.setBounds(300, 115, 100, 20);
                TelaAdicionar.add(textpreco);
                JTextField preco = new JTextField();
                preco.setBounds(300, 140, 150, 20);
                TelaAdicionar.add(preco);

                JLabel textcategoria = new JLabel("Categoria:");
                textcategoria.setBounds(300, 175, 100, 20);
                TelaAdicionar.add(textcategoria);
                JTextField categoria = new JTextField();
                categoria.setBounds(300, 200, 150, 20);
                TelaAdicionar.add(categoria);

                JButton salvar = new JButton("Salvar");
                salvar.setBounds(215, 300, 120, 20);
                TelaAdicionar.add(salvar);

                JButton voltar = new JButton("<");
                voltar.setBounds(20, 20, 50, 20);
                TelaAdicionar.add(voltar);

                voltar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        TelaInicial.setVisible(true);
                        TelaAdicionar.dispose();
                    }
                });
            }
        });

        // Exibir janela inicial
        TelaInicial.setVisible(true);
    }
}
