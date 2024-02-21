/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import model.NewCustomerData;
import org.apache.commons.lang3.StringUtils;
import service.GetListService;
import service.UpdateService;

/**
 *
 * @author RIYA PATIDAR
 */
public class UpdateCustomer extends ActionSupport implements ModelDriven<NewCustomerData> {

    NewCustomerData cusdata =new NewCustomerData();

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

    @Override
    public void validate() {
        if(StringUtils.isEmpty(cusdata.getD_name())){
            addFieldError("d_name","User name cannot be black");
        }
        if(StringUtils.isEmpty(cusdata.getD_contact())){
            addFieldError("d_contact","Contact cannot be black");
        }
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
        try{
            if(service.updateEntry(cusdata)){
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
    public NewCustomerData getModel() {
        return cusdata;
    }
    
}
