/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import service.AddCustomerService;
import model.NewCustomerData;
/**
 *
 * @author RIYA PATIDAR
 */
public class AddNewCustomer extends ActionSupport implements ModelDriven<NewCustomerData>{
    
    private NewCustomerData newCustomer = new NewCustomerData();

    public NewCustomerData getNewCustomer() {
        return newCustomer;
    }

    public void setNewCustomer(NewCustomerData newCustomer) {
        this.newCustomer = newCustomer;
    }

    @Override
    public NewCustomerData getModel() {
        return newCustomer;
    }

    @Override
    public void validate() {
        if(StringUtils.isEmpty(newCustomer.getD_name())){
            addFieldError("d_name","User name cannot be black");
        }
        if(StringUtils.isEmpty(newCustomer.getD_contact())){
            addFieldError("d_contact","Contact cannot be black");
        }
    }
    
    @Override
    public String execute(){
        AddCustomerService service=new AddCustomerService();
        try{
            if(service.verifyNewCustomer(newCustomer)){
                if(service.addEntry(newCustomer)){
                    return SUCCESS;
                }
            }
            else{
                return INPUT;
            }
        }
        catch(Exception E){
            E.getMessage();
        }
        return ERROR;
    }
}
