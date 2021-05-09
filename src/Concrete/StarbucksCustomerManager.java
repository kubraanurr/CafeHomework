package Concrete;

import Abstract.BaseCustomerManager;
import Abstract.ICustomerCheckService;
import Entities.Customer;

public class StarbucksCustomerManager extends BaseCustomerManager{

	private ICustomerCheckService customerCheckService;
	public StarbucksCustomerManager(ICustomerCheckService customerCheckService) {
		this.customerCheckService = customerCheckService;
	}

	
	public void save(Customer customer) {
		
		if(customerCheckService.checkIfRealPerson(customer)) {
			
			this.save(customer);
			System.out.println("Sisteme ba�ar�l� bir �ekilde kaydedildi: "+ customer.getFirtName()+" "+customer.getLastName());
		}
			
		else {
			System.out.println("Kimlik e�le�miyor, i�lem ba�ar�s�z.");
		}
		
		
		
	
}
}
