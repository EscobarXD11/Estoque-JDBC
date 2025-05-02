package estoque;

import java.sql.SQLException;

public class EstoqueDAO {

    public void salvar(Estoque estoque){
    var sql = "insert into estoque (nome, preco, categoria, quantidade, validade) values = (?, ?, ?, ?, ?)";

    try (var conexao = Conexao.obterConexao();
    var st = conexao.prepareStatement(sql)) {

        st.setString(1, estoque.getNome());
        st.setDouble(2, estoque.getPreco());
        st.setString(3, estoque.getCategoria());
        st.setInt(4, estoque.getQuantidade());
        st.setString(5, estoque.getValidade());
        
        st.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }

    }
    
}
