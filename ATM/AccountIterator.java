package ATM;
import java.util.ArrayList;
import java.util.Iterator;

//This class is responsible the Iterator design pattern

public class AccountIterator implements Iterator {
  ArrayList<Account> accounts;
  int position=0;
  public AccountIterator(ArrayList<Account> accounts2) {
		this.accounts = accounts2;
	} //This obtains an already existing ArrayList for use within this class.
  
  
  
	

	public Object next(int position) {
		Account AccountItem = accounts.get(position);
		return AccountItem;
	}


	
	//This function checks when the position is at 0, and prevents the user from going back even further. 
	public boolean hasPrev() {
		if(position == 0)
		return false;
		else
			return true;
	}


	@Override
	public boolean hasNext() {
		if (position >= accounts.size()) {
			return false;
		} else {
			return true;
		}
	}


	@Override
	public Object next() {
		if(hasNext()) {
		   Account AccountItem = accounts.get(position);
		   position++;
		   return AccountItem;
		}
		return null;
	}
	



	

}
