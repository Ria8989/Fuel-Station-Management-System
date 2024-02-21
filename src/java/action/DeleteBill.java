/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import model.NewBillData;
import service.UpdateService;

/**
 *
 * @author RIYA PATIDAR
 */
public class DeleteBill extends ActionSupport implements ModelDriven<NewBillData>{
    private NewBillData billdata = new NewBillData();

    public NewBillData getBilldata() {
        return billdata;
    }

    public void setBilldata(NewBillData billdata) {
        this.billdata = billdata;
    }
    
    public String verify(){
        UpdateService service = new UpdateService();
        if(service.verifyBill(billdata)){
            return SUCCESS;
        }
        return INPUT;
    }

    @Override
    public String execute() {
        UpdateService service = new UpdateService();
        System.out.println("e1");    
        if(service.deleteBill(billdata)){
            System.out.println("e3");
            return SUCCESS;
        }
        return ERROR;
    }
    
    @Override
    public NewBillData getModel() {
        return billdata;
    }
    
    
}
