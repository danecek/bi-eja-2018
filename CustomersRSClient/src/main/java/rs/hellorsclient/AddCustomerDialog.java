package rs.hellorsclient;

import java.util.Date;
import java.util.Optional;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;

public class AddCustomerDialog extends Dialog<ButtonType> {

    private final TextField tf;

    public AddCustomerDialog() {
        getDialogPane().setContent(tf = new TextField());
        getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
    }

    public void exec() {
        Optional<ButtonType> b = this.showAndWait();
        if (b.get() == ButtonType.OK) {
            Proxy.instance.addCustomer(new Customer(tf.getText()));
        }
    }

}
