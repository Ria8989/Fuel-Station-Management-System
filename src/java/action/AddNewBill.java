/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import model.NewBillData;
import org.apache.commons.lang3.StringUtils;
import service.AddBillService;

/**
 *
 * @author RIYA PATIDAR
 */
public class AddNewBill extends ActionSupport implements ModelDriven<NewBillData>{

    private NewBillData newBill= new NewBillData();

    public NewBillData getNewBill() {
        return newBill;
    }

    public void setNewBill(NewBillData newBill) {
        this.newBill = newBill;
    }
    
    @Override
    public NewBillData getModel() {
        return newBill;
    }

    @Override
    public void validate() {
        System.out.println("validate");
        if(StringUtils.isEmpty(newBill.getBill_name())){
            addFieldError("bill_name", "Name cannot be blank.");
            System.out.println("name");
        }
        
        if(StringUtils.isEmpty(newBill.getBill_date())){
            addFieldError("bill_date", "Date cannot be blank.");
        System.out.println("date");
        }

        if(StringUtils.isEmpty(newBill.getBill_no())){
            addFieldError("bill_no", "Bill No. cannot be blank.");
        System.out.println("bill");
        }
        
        if(StringUtils.isEmpty(newBill.getDebit())){
            newBill.setDebit("0");
        System.out.println("debit 1 ");
        }
        
        if(!StringUtils.isNumeric(newBill.getDebit())){
                addFieldError("debit", "Only numbers are allowed.");
        System.out.println("debit 2");
        }
        
        if(StringUtils.isEmpty(newBill.getCredit())){
            newBill.setCredit("0");
        System.out.println("credit 1");
        }
        
        if(!StringUtils.isNumeric(newBill.getCredit())){
            addFieldError("credit", "Only numbers are allowed.");
        System.out.println("credit 2");
        }
        
        if(StringUtils.isEmpty(newBill.getDescription())){
            newBill.setDescription("None");
        System.out.println("desc");
        }
        
    }

    @Override
    public String execute() {
        System.out.println("execute");
        AddBillService service=new AddBillService();
        try{
            if(service.verifyBill(newBill)){
                System.out.println("verify");
                if(service.addBill(newBill)){
                    System.out.println("added");
                    return SUCCESS;
                }
                else{
                    return INPUT;
                }
            }
        }
        catch(Exception E){
            E.printStackTrace();
        }
        return ERROR;
        
    }
    
    
}
