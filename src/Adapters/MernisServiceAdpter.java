package Adapters;

import java.rmi.RemoteException;
import java.time.ZoneId;

import Abstract.ICustomerCheckService;
import Entities.Customer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdpter implements ICustomerCheckService{

	@Override
	public boolean checkIfRealPerson(Customer customer) {
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();    
	    boolean result = false;
	    
		try 
		{
			result = kpsPublicSoapProxy.TCKimlikNoDogrula
					(
					Long.parseLong(customer.getNationalityId()) , 
					customer.getFirtName().toUpperCase(), 
					customer.getLastName().toUpperCase(), 
					customer.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear()
					);
		} 
		catch (RemoteException e) 
		{
			e.printStackTrace();
		}

		return result;
	}

}
