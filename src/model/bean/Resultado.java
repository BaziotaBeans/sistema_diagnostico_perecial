/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Baziota Beans
 */
public class Resultado 
{
   private int pk_resultado;
   private String diagnostico;
   private int fk_paciente;
   private String data;

    public int getPk_resultado() {
        return pk_resultado;
    }

    public void setPk_resultado(int pk_resultado) {
        this.pk_resultado = pk_resultado;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public int getFk_paciente() {
        return fk_paciente;
    }

    public void setFk_paciente(int fk_paciente) {
        this.fk_paciente = fk_paciente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    } 
}
