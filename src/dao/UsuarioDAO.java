package dao;
import factory.ConnectionFactory;
import modelo.Usuario;
import java.sql.*;
import java.sql.PreparedStatement;
public class UsuarioDAO { 
    private final Connection connection;
    Long id;
    String nome;
    String email;
    String telefone;
    String endereco;
    java.util.Date data_nascimento;
    
    public UsuarioDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    } 
    public void adiciona(Usuario usuario){ 
        String sql = "INSERT INTO usuario(nome,email,telefone,endereco,data_nascimento) VALUES(?,?,?,?,?)";
        try { 
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, usuario.getNome());
                stmt.setString(2, usuario.getEmail());
                stmt.setString(3, usuario.getTelefone());
                stmt.setString(4, usuario.getEndereco());
                stmt.setString(5, usuario.getData_nascimento());
                
                stmt.execute();
            }
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    } 
    
}