/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package action;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import model.NewCustomerData;
import service.UpdateService;

/**
 *
 * @author RIYA PATIDAR
 */
public class DeleteCustomer extends ActionSupport implements ModelDriven<NewCustomerData>{

    private NewCustomerData cusdata = new NewCustomerData();

    public NewCustomerData getCusdata() {
        return cusdata;
    }

    public void setCusdata(NewCustomerData cusdata) {
        this.cusdata = cusdata;
    }
    
    public String display(){
        UpdateService service = new UpdateService();
        if(service.gNameCus(cusdata)){
            System.out.println(cusdata.getNameList());
            return SUCCESS;
        }
        return ERROR;
    }

    public String getCustomer(){
        UpdateService service = new UpdateService();
        try{
            if(service.verifyCustomer(cusdata)){
                    return SUCCESS;
                }
                else{
                    return INPUT;
                }
        }
        catch(Exception E){
            E.printStackTrace();
        }
        return ERROR;
    }
    
    @Override
    public String execute() {
        UpdateService service = new UpdateService();
        if(service.verifyCustomer(cusdata)){
            if(service.deleteCustomer(cusdata)){
                return SUCCESS;
            }
        }
        else{
            return INPUT;
        }
        return ERROR;
    }
    
    @Override
    public NewCustomerData getModel() {
        return cusdata;
    }
    
}
