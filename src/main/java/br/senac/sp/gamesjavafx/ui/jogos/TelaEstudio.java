package br.senac.sp.gamesjavafx.ui.jogos;


import br.senac.sp.gamesjavafx.model.Estudio;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class TelaEstudio {

    private TextField tfId = new TextField();
    private TextField tfNomeEstudio = new TextField();
    private  TextField tfNomeFundador = new TextField();
    private ComboBox<Estudio> comboEstudio = new ComboBox<>();
    private DatePicker dpAnoFundacao = new DatePicker();

    TelaEstudio(Estudio estudio){
        tfId.setText(String.valueOf(estudio.getId()));
        tfNomeEstudio.setText(estudio.getNomeEstudio());
        tfNomeFundador.setText(estudio.getNomeFundador());
        dpAnoFundacao.setValue(estudio.getAnoFundacao());
    }



}
