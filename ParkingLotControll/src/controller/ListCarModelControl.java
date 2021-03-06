
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.DAOSer.CarModelDAOSer;
import model.bo.CarModel;
import view.ListCarModelView;


public class ListCarModelControl implements ActionListener {
    
    private view.ListCarModelView listCarModelView;
    CarModelDAOSer carModelDAOSer = new CarModelDAOSer();
    
    public ListCarModelControl(ListCarModelView listCarModelView) {
        
        this.listCarModelView = listCarModelView;

        this.listCarModelView.getjButtonEdit().addActionListener(this);
        this.listCarModelView.getjButtonExit().addActionListener(this);
        this.listCarModelView.getjButtonDelete().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.listCarModelView.getjTableCarModel().getModel();
        for (CarModel carModelInstance : service.CarModelService.Retrieve()) {
            tabela.addRow(new Object[]{carModelInstance.getId(), carModelInstance.getNameModel(), 
                carModelInstance.getNameType(), carModelInstance.getNameCategory()});
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.listCarModelView.getjButtonEdit()) {
            //desenvolver a codificação de carga do dado ppara a tela de cadastro
        } 
        else if (e.getSource() == this.listCarModelView.getjButtonExit()) {
            this.listCarModelView.dispose();
        }
        else if (e.getSource() == this.listCarModelView.getjButtonDelete()) {
            int id = this.listCarModelView.getjTableCarModel().getSelectedRow();
            if(id != -1) {
                carModelDAOSer.Delete(id);
                this.listCarModelView.dispose();
            }
        }
    }
}
