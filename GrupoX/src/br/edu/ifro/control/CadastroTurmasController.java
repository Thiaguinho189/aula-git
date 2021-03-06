/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;

import br.edu.ifro.model.Turma;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author 94421340278
 */
public class CadastroTurmasController implements Initializable {

    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtCurso;
    @FXML
    private TextField txtTurno;
    @FXML
    private TextField txtTurma;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
   

    @FXML
    private void SalvarTurmas(ActionEvent event) {
        Turma turma = new Turma();
        turma.setNome(txtNome.getText());
        turma.setCurso(txtCurso.getText());
        turma.setTurno(txtTurno.getText());
        turma.setTurma(txtTurma.getText());
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula");
        EntityManager em =emf.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(turma);
        em.getTransaction().commit();
        JOptionPane.showMessageDialog(null,"Turma inserida com suqcesso.");
    }

    @FXML
    private void Fechar(ActionEvent event) {
    }
    
}
