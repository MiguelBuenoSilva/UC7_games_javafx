module br.senac.sp.gamesjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens br.senac.sp.gamesjavafx to javafx.fxml;
    exports br.senac.sp.gamesjavafx;
}