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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Resultado;

/**
 *
 * @author Baziota Beans
 */
public class ResultadoDAO 
{
    public void create(Resultado resultado)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO tbResultado (diagnostico, fk_paciente, data)VALUES(?,?,?)");
            stmt.setString(1,resultado.getDiagnostico());
            stmt.setInt(2, resultado.getFk_paciente());
            stmt.setString(3, resultado.getData());
            
            
            //Executar o sql, o statement vai fazer isso
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Salvo com sucesso");
                    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar: "+ex);
        }
        finally
        {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }
    
    public void update(Resultado resultado)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE tbResultado SET diagnostico = ?,fk_paciente = ?, data = ? WHERE pk_resultado = ?");
            stmt.setString(1,resultado.getDiagnostico());
            stmt.setInt(2, resultado.getFk_paciente());
            stmt.setString(3, resultado.getData());
            
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
    
    public void delete(Resultado resultado)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM tbResultado WHERE pk_resultado = ?");
            stmt.setInt(1, resultado.getPk_resultado());
            
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
    
    public List<Resultado> read()
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Resultado> result = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tbPaciente");
            rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Resultado resultado = new Resultado();
                
                resultado.setPk_resultado(rs.getInt("pk_resultado"));
                resultado.setDiagnostico(rs.getString("diagnostico"));
                resultado.setFk_paciente(rs.getInt("fk_paciente"));
                resultado.setData(rs.getString("data"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally
        {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return result;
    }
    
}
