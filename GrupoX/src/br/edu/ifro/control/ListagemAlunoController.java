package br.edu.ifro.control;

import br.edu.ifro.model.Aluno;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ListagemAlunoController implements Initializable {

    @FXML
    private TableView<?> tbAlunos;
    @FXML
    private ComboBox<?> cbAlunos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula");
        EntityManager em = emf.createEntityManager();
                
        // import javax.persistence.Query;
        Query query = em.createQuery("SELECT a FROM Aluno as a");
        // import java.util.List;
        // import br.edu.ifro.model.Aluno;
        List<Aluno> alunos = query.getResultList();
        // import javafx.collections.ObservableList;
        // import javafx.collections.FXCollections;
        ObservableList oAlunos = FXCollections.observableArrayList(alunos);                                 
        cbAlunos.setItems(oAlunos);
        tbAlunos.setItems(oAlunos);
    }    
    
}
