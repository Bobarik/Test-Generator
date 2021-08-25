package ru.mail.skorobogatov.www.interf;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import ru.mail.skorobogatov.www.functionality.DocCombiner;
import ru.mail.skorobogatov.www.functionality.Theme;

import java.io.IOException;
import java.util.Optional;

public class Controller {

    public ChoiceBox choice;
    public Button button;
    public TextField num;

    @FXML
    public void onClickMethod() throws IOException {
        try {
            int number = Integer.parseInt(num.getText());

            if(number < 1 || number > 200) {
                throw new IllegalArgumentException("The number of copies ........");
            }

            Theme theme = Theme.get(choice.getValue().toString());

            for (int i = 0; i < number; i++) {
                DocCombiner.combineDoc(theme, ".", theme.getFolder() + (i+1) + ".rtf");
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Генерация успешна");
            alert.setHeaderText(null);
            alert.setContentText(number + " Вариант"+ (number%10==1&&number!=11?"":number%10<5&&(number>15||number<10)?"а":"ов")+ " по дисциплине " + theme.getFolder() + " было успешно сгенерировано!");
            Optional<ButtonType> result = alert.showAndWait();
        } catch (IllegalArgumentException e) {
            Alert alertWrongNumber = new Alert(Alert.AlertType.INFORMATION);
            alertWrongNumber.setTitle("Проверьте число копий");
            alertWrongNumber.setHeaderText(null);
            alertWrongNumber.setContentText("Проверьте введенное вами число копий и введите другое.");
            Optional<ButtonType> result = alertWrongNumber.showAndWait();
        } catch (NullPointerException e) {
            Alert alertThemeWasntChosen = new Alert(Alert.AlertType.INFORMATION);
            alertThemeWasntChosen.setTitle("Тема работы не была выбрана");
            alertThemeWasntChosen.setHeaderText(null);
            alertThemeWasntChosen.setContentText("Тема работы не была выбрана. Пожалуйста, выберите тему работы");
            Optional<ButtonType> result = alertThemeWasntChosen.showAndWait();
        }
    }
}