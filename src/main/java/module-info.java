module br.senac.sp.gamesjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens br.senac.sp.gamesjavafx to javafx.fxml;
    exports br.senac.sp.gamesjavafx;
}