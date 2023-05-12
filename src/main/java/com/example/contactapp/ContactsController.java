package com.example.contactapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ContactsController {

    private final ObservableList<Contact> contacts = FXCollections.observableArrayList();
    private Contact contactSelected;

    @FXML
    private ListView<Contact> contactsListView;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    void addContactButtonPressed(ActionEvent event) {
        Contact newContact = new Contact();
        newContact.setfName(firstNameTextField.getText().trim());
        newContact.setlName(lastNameTextField.getText().trim());
        newContact.setEmail(emailTextField.getText().trim());
        newContact.setPhone(phoneNumberTextField.getText().trim());
        contacts.add(newContact);

    }

    @FXML
    void deleteContactButtonPressed(ActionEvent event) {
        contacts.remove(contactSelected);
    }

    @FXML
    void updateContactButtonPressed(ActionEvent event) {
        contactSelected.setfName(firstNameTextField.getText().trim());
        contactSelected.setlName(lastNameTextField.getText().trim());
        contactSelected.setEmail(emailTextField.getText().trim());
        contactSelected.setPhone(phoneNumberTextField.getText().trim());
    }

    public void initialize() {
        contacts.add(new Contact("Dastan", "Akatov", "dastan.akatov@gmail.com", "+996000000000"));
        contacts.add(new Contact("Askar", "Akaev", "askar.akaev@gmail.com", "+996000000000"));
        contacts.add(new Contact("Balancha", "Balanchaev", "balancha.balanchaev@gmail.com", "+996000000000"));
        contacts.add(new Contact("Ivan", "Ivanovich", "ivan.ivanovich@gmail.com", "+996000000000"));
        contactsListView.setItems(contacts);

        contactsListView.getSelectionModel().selectedItemProperty().addListener((arg0, oldValue, newValue) -> {
            contactSelected = newValue;
            firstNameTextField.setText(newValue.getfName());
            lastNameTextField.setText(newValue.getlName());
            emailTextField.setText(newValue.getEmail());
            phoneNumberTextField.setText(newValue.getPhone());
        });
    }

}