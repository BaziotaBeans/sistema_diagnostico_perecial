/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;
import Conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Paciente;
import java.util.List;
/**
 *
 * @author Baziota Beans
 */
public class PacienteDAO 
{
    //
    public boolean checkLogin(String login, String senha)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
          
        try {
            stmt = con.prepareStatement("SELECT * FROM tbPaciente WHERE email = ? and senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            
            rs = stmt.executeQuery();
            
            if(rs.next())
            {
                check = true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally
        {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return check;
    }
    
    
    public Paciente getUser(String login, String senha)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Paciente paciente = new Paciente();
          
        try {
            stmt = con.prepareStatement("SELECT * FROM tbPaciente WHERE email = ? and senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            
            rs = stmt.executeQuery();
            
            if(rs.next())
            {
                paciente.setPk_paciente(rs.getInt("pk_paciente"));
                paciente.setEmail(rs.getString("email"));
                paciente.setSenha(rs.getString("senha"));                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally
        {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return paciente;
    }
    
    
    public boolean create(Paciente paciente)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        boolean status = false;
        try {
            stmt = con.prepareStatement("INSERT INTO tbPaciente (nome,idade,sexo,altura,morada,telefone,email,senha)VALUES(?,?,?,?,?,?,?,?)");
            stmt.setString(1,paciente.getNome());
            stmt.setInt(2, paciente.getIdade());
            stmt.setString(3, paciente.getSexo());
            stmt.setFloat(4, paciente.getAltura());
            stmt.setString(5, paciente.getMorada());
            stmt.setString(6, paciente.getTelefone());
            stmt.setString(7, paciente.getEmail());
            stmt.setString(8, paciente.getSenha());
            
            
            //Executar o sql, o statement vai fazer isso
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Salvo com sucesso");
            status = true;
                    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar: "+ex);
        }
        finally
        {
            ConnectionFactory.closeConnection(con,stmt);
        }
        return status;
    }
    
    public void update(Paciente paciente)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE tbPaciente SET nome = ?,idade = ?, sexo = ?, altura = ?, morada = ?, telefone = ?, email = ?, senha = ? WHERE pk_paciente = ?");
            stmt.setString(1,paciente.getNome());
            stmt.setInt(2, paciente.getIdade());
            stmt.setString(3, paciente.getSexo());
            stmt.setFloat(4, paciente.getAltura());
            stmt.setString(5, paciente.getMorada());
            stmt.setString(6, paciente.getTelefone());
            stmt.setString(7, paciente.getEmail());
            stmt.setString(8, paciente.getSenha());
            //Executar o sql, o statement vai fazer isso
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Actualizado com sucesso");
                    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Actualizar: "+ex);
        }
        finally
        {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }
    //
    public void delete(Paciente paciente)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM tbPaciente WHERE pk_paciente = ?");
            stmt.setInt(1, paciente.getPk_paciente());
            
            //Executar o sql, o statement vai fazer isso
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Excluido com sucesso");
                    
        } catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null,"Erro ao excluir: "+ex);
        }
        finally
        {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }
    //
    public List<Paciente> read()
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Paciente> pacient = new ArrayList<>();
        
        
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tbPaciente");
            rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Paciente paciente = new Paciente();
                
                paciente.setPk_paciente(rs.getInt("pk_paciente"));
                paciente.setNome(rs.getString("nome"));
                paciente.setIdade(rs.getInt("idade"));
                paciente.setSexo(rs.getString("sexo"));
                paciente.setAltura(rs.getFloat("altura"));
                paciente.setMorada(rs.getString("morada"));
                paciente.setTelefone(rs.getString("telefone"));
                paciente.setEmail(rs.getString("email"));
                paciente.setSenha(rs.getString("senha"));
                pacient.add(paciente);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally
        {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return pacient;
    }
}
