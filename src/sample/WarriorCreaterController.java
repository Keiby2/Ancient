package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Контроллер покупки воина
 */
public class WarriorCreaterController implements Initializable {
    //----------------------------
    /**
     * Метки отображающие параметры юнита
     */
    @FXML
    private Label labelAttack, labelHealth, labelDefence, labelSpeed, labelDescription;
    //-----------------------------

    private String SelectedUnit;

    private boolean flagWarrior = false, flagArcher = false;
    @FXML
    private ImageView Warrior, Archer;
    @FXML
    private Button OkBtn;


    FirstMap MAP = new FirstMap();

    /**
     * Начальные значения
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        flagWarrior = false;
        flagArcher = false;
        SelectedUnit = "init value";
    }

    /**
     * Нажатие на кнопку "купить"
     *
     * @param actionEvent
     */
    @FXML
    private void OkClicked(ActionEvent actionEvent) {
        Stage stage = (Stage) OkBtn.getScene().getWindow();
        //  System.out.println(SelectedUnit);
        MAP.sendWarrior(SelectedUnit);
        stage.close();
    }

    /**
     * Нажатие на воина
     *
     * @param mouseEvent
     */
    @FXML
    private void warriorClick(MouseEvent mouseEvent) {
        loadAboutUnit(Warrior);
        if (!flagWarrior) {
            clearSelection();
            Image img = new Image("sample/img/warrior/warriorSelected.png");
            Warrior.setImage(img);
            SelectedUnit = "Warrior";
            flagWarrior = true;
        }
    }

    @FXML
    private void archerClick(MouseEvent mouseEvent) {
        loadAboutUnit(Archer);
        if (!flagArcher) {
            clearSelection();
            Image img = new Image("sample/img/archer/archerSelected.png");
            Archer.setImage(img);
            SelectedUnit = "Archer";
            flagArcher = true;
        }
    }


    public void clearSelection() {
        Warrior.setImage(new Image("sample/img/warrior/War.png"));
        Archer.setImage(new Image("sample/img/archer/archer.png"));

        flagWarrior = false;
        flagArcher = false;
    }

    public String getSelectedUnit() {
        return SelectedUnit;
    }

    public void run(MouseEvent event, FirstMap map) {
        try {
            MAP = map;
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Parent root = FXMLLoader.load(getClass().getResource("Designe/WarriorCreater.fxml"));
            stage.setTitle("Создание Юнита");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.NONE);
            stage.initOwner(((Node) event.getSource()).getScene().getWindow());
            stage.showAndWait();
        } catch (Exception e) {
        }
    }

    /**
     * В зависимости от того какой юнит выбран, осуществляется загрузка данных о юните в текстовые поля
     *
     * @param unit
     */
    private void loadAboutUnit(ImageView unit) {
        if (unit.equals(Warrior))
            loadingInfo("5", "10", "5", "4", "He can occupied village");
        else if (unit.equals(Archer))
            loadingInfo("5", "10", "4", "5", "He can shoot through the cage");

    }

    /**
     * Выводит в метки данные полученные из параметров
     *
     * @param att
     * @param hp
     * @param def
     * @param sp
     * @param desc
     */
    private void loadingInfo(String att, String hp, String def, String sp, String desc) {
        labelAttack.setText(att);
        labelDefence.setText(def);
        labelHealth.setText(hp);
        labelSpeed.setText(sp);
        labelDescription.setText(desc);
    }
}
