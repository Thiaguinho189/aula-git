/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;

import br.edu.ifro.model.Professor;
import br.eti.diegofonseca.MaskFieldUtil;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author coelh
 */
public class CadastroProfessorController implements Initializable {

    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtTelefone;
    private Professor professor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void salvar(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula");
        EntityManager em = emf.createEntityManager();
        
        Professor professor1;
        if (professor != null) {            
            Query query = em.createQuery("SELECT a FROM Aluno as a WHERE a.id = :id");
            query.setParameter("id", professor.getId());

            professor1 = (Professor) query.getSingleResult();
        } 
        else {
            professor1 = new Professor();
        } 
        
        professor1.setNome(txtNome.getText());
        professor1.setTelefone(txtTelefone.getText());
        
        professor1.setTelefone(MaskFieldUtil.onlyAlfaNumericValue(txtTelefone));
        
        em.getTransaction().begin();
        em.persist(professor1);
        em.getTransaction().commit();
        JOptionPane.showMessageDialog(null,"Professor Cadaxtrado");
    }

    @FXML
    private void fechar(ActionEvent event) {
        Stage stage = (Stage) txtNome.getScene().getWindow();
        stage.close();
    }
    
}
