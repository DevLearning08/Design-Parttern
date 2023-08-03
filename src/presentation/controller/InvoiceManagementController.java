package presentation.controller;

import presentation.ManagementApp;
import presentation.ManagementAppInfor;
import presentation.ManagementAppInput;
import java.awt.event.ActionEvent;
public class InvoiceManagementController {
    private ManagementApp managementAppRemote;
    private ManagementAppInfor managementAppInforRemote;
    private ManagementAppInput managementAppInputRemote;


    public InvoiceManagementController() {
        
    }


    public ManagementApp getManagementAppRemote() {
        return managementAppRemote;
    }


    public void setManagementAppRemote(ManagementApp managementAppRemote) {
        this.managementAppRemote = managementAppRemote;
    }


    public ManagementAppInfor getManagementAppInforRemote() {
        return managementAppInforRemote;
    }


    public void setManagementAppInforRemote(ManagementAppInfor managementAppInforRemote) {
        this.managementAppInforRemote = managementAppInforRemote;
    }


    public ManagementAppInput getManagementAppInputRemote() {
        return managementAppInputRemote;
    }


    public void setManagementAppInputRemote(ManagementAppInput managementAppInputRemote) {
        this.managementAppInputRemote = managementAppInputRemote;
    }
    

    public void actionPerformed(ActionEvent e) {
        
    }

}
