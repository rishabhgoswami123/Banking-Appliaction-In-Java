import java.util.Scanner;

class bankingApplication 
{
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		System.out.print("Enter customer name:");
		String customerName=s.nextLine();
		System.out.print("Enter customer id:");
		int customerId=s.nextInt();
		BankAccount obj1=new BankAccount(customerName,customerId);
		obj1.showMenu();
	}
	
}


class BankAccount
{
	int balance;
	int previousTransaction;
	String customerName;
	int customerId;
	
	BankAccount(String cname,int cid)
	{
		this.customerName=cname;
		this.customerId=cid;
	}
	
	
	
	
	void deposit(int amount)
	{
		if(amount!=0)
		{
			balance=balance+amount;
			previousTransaction=amount;
		}
	}
	
	void depositWithSI(int amount)
	{
		Scanner sc=new Scanner(System.in);
		if(amount!=0)
		{
			System.out.println("Enter the no of years:");
			int year=sc.nextInt();
			balance=balance+amount+(int)(amount*year*0.07);
		}
	}
	
	void depositWithCI(int amount)
	{
		Scanner sc=new Scanner(System.in);
		if(amount!=0)
		{
			System.out.println("Enter the no of years:");
			int year=sc.nextInt();
			balance=balance+((int)(amount*Math.pow((1+0.07),year)));
		}
	}
	
	void withdraw(int amount)
	{
		if(amount!=0)
		{
			balance=balance-amount;
			previousTransaction=-amount;
		}
	}
	
	void getPreviousTransaction()
	{
		if(previousTransaction>0)
		{
			System.out.println("Deposited:" +previousTransaction);
		}
		else if(previousTransaction<0)
		{
			System.out.println("Withdrawn:" +Math.abs(previousTransaction));
		}
		else
		{
			System.out.println("No transaction occured");
		}
	}
	
	void showMenu()
	{
		char option='\0';
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome:" +customerName);
		System.out.println("Your ID is:"+customerId);
		System.out.println("\n");
		System.out.println("A. Check Balance:");
		System.out.println("B. Deposit:");
		System.out.println("C. Deposit with simple interest(7%PA):");
		System.out.println("D. Deposit with compound interest(7%PA):");
		System.out.println("E. Withdraw:");
		System.out.println("F. Previous Transaction:");
		System.out.println("G. Exit:");
		
		do
		{
			System.out.println("******************");
			System.out.println("Enter an option:");
			System.out.println("******************");
			option=sc.next().charAt(0);
			System.out.println("\n");
			
			switch(option)
			{
			
			case 'A':
				System.out.println("---------------------");
				System.out.println("Balance = " +balance);
				System.out.println("---------------------");
				System.out.println("\n");
				break;
				
			case 'B':
				System.out.println("---------------------");
				System.out.println("Enter an amount to deposit = ");
				System.out.println("---------------------");
				int amount=sc.nextInt();
				deposit(amount);
				System.out.println("\n");
				break;
			case 'C':
				System.out.println("---------------------");
				System.out.println("Enter an amount to deposit = ");
				System.out.println("---------------------");
				int amount3=sc.nextInt();
				depositWithSI(amount3);
				System.out.println("\n");
				break;
				
			case 'D':
				System.out.println("---------------------");
				System.out.println("Enter an amount to deposit = ");
				System.out.println("---------------------");
				int amount4=sc.nextInt();
				depositWithCI(amount4);
				System.out.println("\n");
				break;
			
			case 'E':
				System.out.println("---------------------");
				System.out.println("Enter an amount to withdraw = ");
				System.out.println("---------------------");
				int amount2=sc.nextInt();
				withdraw(amount2);
				System.out.println("\n");
				break;
				
			case 'F':
				System.out.println("---------------------");
				getPreviousTransaction();
				System.out.println("---------------------");
				System.out.println("\n");
				break;
			case 'G':
				System.out.println("---------------------");
				break;
			
			default:
				System.out.println("Invalid operation. Please enter again.");
				break;
			}
		}
		
		while(option!='G');
		System.out.println("Thank You for using our services");
		
		
	}
	
}
