package estoque;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Main {
    public static void main(String[] args) {
      var conexao = Conexao.obterConexao();
 if (conexao != null) {
    System.out.println();
    System.out.println("Conectado com sucesso!");
    System.out.println();
 } else{
    System.out.println();
    System.out.println("Erro ao conectar-se!");
    System.out.println();
    return;
 }

  // Criar a janela
  JFrame TelaInicial = new JFrame("Exemplo de Janela");
  TelaInicial.setSize(600, 500);
  TelaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  TelaInicial.setLocationRelativeTo(null);
  TelaInicial.setLayout(null); // Importante para usar setBounds

  // Área de texto "Bem-vindo"
  JTextArea BemVindo = new JTextArea("Bem-vindo ao estoque!");
  BemVindo.setEditable(false);
  BemVindo.setBounds(130, 20, 540, 50); // Tamanho e posição
  BemVindo.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20)); // Fonte maior e em negrito
  BemVindo.setHighlighter(null); // Remove seleção
  BemVindo.setOpaque(false); // Fundo transparente (opcional)
  BemVindo.setLineWrap(true); // Quebrar linha se necessário
  BemVindo.setWrapStyleWord(true); // Quebra por palavra
  
  
  // Centralizar o texto horizontalmente usando o setText com \n se quiser ajustar mais
  BemVindo.setText("       Bem-vindo ao estoque!"); // espaço antes do texto para centralizar melhor visualmente
  
  TelaInicial.add(BemVindo);

  // Dados da tabela
  String[] colunas = {"ID", "Nome", "Preço", "Quantidade", "Validade"};
  Object[][] dados = {
      {1, "Arroz", 15.50, 100, "2025-12-01"},
      {2, "Feijão", 7.30, 200, "2025-06-15"},
      {3, "Macarrão", 4.99, 150, "2024-10-10"},
      {4, "Açúcar", 5.20, 80, "2025-07-22"}
  };

  // Criar o modelo da tabela
  DefaultTableModel model = new DefaultTableModel(dados, colunas);
  JTable tabela = new JTable(model);

  // Adicionar a tabela dentro de um JScrollPane
  JScrollPane scrollPane = new JScrollPane(tabela);
  scrollPane.setBounds(20, 100, 550, 300); // (x, y, largura, altura)
  TelaInicial.add(scrollPane);

  // Exibir a janela
  TelaInicial.setVisible(true);
}
}
