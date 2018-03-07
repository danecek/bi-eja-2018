/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.hellorsclient;

import java.util.Observable;
import java.util.Observer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;

public class CustomersPanel extends TitledPane implements Observer {

    private ObservableList<Customer> customers = FXCollections.observableArrayList();
    private TableView<Customer> customersTable;

    public CustomersPanel() {
        super("Customers", null);
        setContent(new ScrollPane(customersTable = createContent()));
        customersTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        refresh();
        // getSelectedBooks().addListener(DeleteBookAction.instance);
        //  LibStateObservable.instance.addObserver(this);
    }

    private TableView<Customer> createContent() {
        TableView<Customer> tv = new TableView<>();
        TableColumn<Customer, Object> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Customer, Object> authorCol = new TableColumn<>("Name");
        authorCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        tv.getColumns().setAll(idCol, authorCol);
        tv.setItems(customers);
        return tv;
    }

    public void refresh() {
        customers.setAll(Proxy.instance.get());
    }

    public ObservableList<Customer> getSelectedBooks() {
        return customersTable.getSelectionModel().getSelectedItems();
    }

    @Override
    public void update(Observable o, Object arg) {

        refresh();

    }
}
