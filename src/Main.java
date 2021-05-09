import Abstract.BaseCustomerManager;
import Abstract.ICustomerCheckService;
import Concrete.NeroCustomerManager;
import Concrete.StarbucksCustomerManager;
import Entities.Customer;

public class Main {

	public static void main(String[] args) {
		
		BaseCustomerManager customerManager = new StarbucksCustomerManager(new ICustomerCheckService() {
			
			@Override
			public boolean checkIfRealPerson(Customer customer) {
				// TODO Auto-generated method stub
				return false;
			}
		});
		customerManager.save(new Customer(1, "kübra", "nur", null, "123456789"));

		System.out.println();
	}

}
