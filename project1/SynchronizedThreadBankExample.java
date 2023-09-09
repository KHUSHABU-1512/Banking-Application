package project1;



class Customer
{
	int amount = 10000;
	synchronized void withdraw(int amount)
	{
		System.out.println("Going to withdraw..");
		if(this.amount<amount)
		{
			System.out.println("Less balance ;waiting for deposit:");
			try {
				wait();
			}catch(Exception e)
			{
				
			}
		}
		this.amount-= amount;
		System.out.println(" withdraw completedd..");
		
	}
	synchronized void deposit(int amount)
	{
		System.out.println("Going to Deposit..");
		this.amount+= amount;
		System.out.println(" Deposit completed..");
		notify();
	}
}

public class SynchronizedThreadBankExample {

	public static void main(String[] args) {
		final Customer c = new Customer();
		new Thread() {
		public void run() {
			c.withdraw(50000);
		}	 
		}
		.start(); 
		 new Thread() {
			 public void run() {
					c.deposit(10000);
				}	 
				}
		 .start();
			
		 }
			
}



