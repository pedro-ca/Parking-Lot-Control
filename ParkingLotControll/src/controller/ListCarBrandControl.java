
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.DAOSer.CarBrandDAOSer;
import model.bo.CarBrand;
import view.ListCarBrandView;


public class ListCarBrandControl implements ActionListener {
    
    private view.ListCarBrandView listCarBrandView;
    CarBrandDAOSer carBrandDAOSer = new CarBrandDAOSer();
    
    public ListCarBrandControl(ListCarBrandView listCarBrandView) {
        
        this.listCarBrandView = listCarBrandView;

        this.listCarBrandView.getjButtonEdit().addActionListener(this);
        this.listCarBrandView.getjButtonExit().addActionListener(this);
        this.listCarBrandView.getjButtonDelete().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.listCarBrandView.getjTableCarBrand().getModel();
        for (CarBrand carBrandInstance : service.CarBrandService.Retrieve()) {
            tabela.addRow(new Object[]{carBrandInstance.getId(), carBrandInstance.getNameBrand()});
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.listCarBrandView.getjButtonEdit()) {              //opcao de menor prioridade
            //desenvolver a codificação de carga do dado ppara a tela de cadastro
        } 
        else if (e.getSource() == this.listCarBrandView.getjButtonExit()) {
            this.listCarBrandView.dispose();
        }
        else if (e.getSource() == this.listCarBrandView.getjButtonDelete()) {       //opcao de menor prioridade
            int id = this.listCarBrandView.getjTableCarBrand().getSelectedRow();
            if(id != -1) {
                carBrandDAOSer.Delete(id);
                this.listCarBrandView.dispose();
            }
        }
    }
}
