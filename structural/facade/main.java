package structural.facade;

// the unfied facde class 
class FinancialSystemFacade {

    private BillingSystem billingSystem;

    private InvoiceCustomerSystem invoiceCustomerSystem;


    // this is an example method of the abstraction, here 
    // all the cleint has to do is to call the create invoice 
    // method 
    public void createInvoice(Integer amount){

        Bill bill = billingSystem.createBill(amount);
        invoiceCustomerSystem.createInvoiceForBill(bill);

    }


    public void setBillingSystem(BillingSystem billingSystem) {
        this.billingSystem = billingSystem;
    }

    public void setInvoiceCustomerSystem(InvoiceCustomerSystem invoiceCustomerSystem) {
        this.invoiceCustomerSystem = invoiceCustomerSystem;
    }
}

// a system 
class InvoiceCustomerSystem {

	public void createInvoiceForBill(Bill bill){
		System.out.println("Creating invoice for bill with amount: "+bill.getAmount());
	}
	
}

// a system 
class BillingSystem {

	public Bill createBill(Integer amount){
		
		// Let's assume some advanced logic happens here;
		return new Bill(amount);
		
	}
	
}

class Bill {

	private Integer amount;
	
	public Bill(Integer amount){
		this.amount = amount;
	}

	public Integer getAmount() {
		return amount;
	}

	
}


class Client {

	public static void main(String [] args){
		
		// initial setup
        BillingSystem billingSystem = new BillingSystem();
        InvoiceCustomerSystem invoiceCustomerSystem = new InvoiceCustomerSystem();

        FinancialSystemFacade financialSystemFacade = new FinancialSystemFacade();
        financialSystemFacade.setBillingSystem(billingSystem);
        financialSystemFacade.setInvoiceCustomerSystem(invoiceCustomerSystem);

        financialSystemFacade.createInvoice(1000);

	}
	
}

