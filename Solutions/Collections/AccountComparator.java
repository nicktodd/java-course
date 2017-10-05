public class AccountComparator implements java.util.Comparator<Account>
{
		public int compare(Account a, Account b)
		{
			if (a.getBalance() < b.getBalance()) return -1;
			else if (a.getBalance() > b.getBalance()) return 1;
			else return 0;
		}


}