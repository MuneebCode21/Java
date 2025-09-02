import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

class Dealership {
    private static Dealership instance;
    private ArrayList<Car> purchasedCars = new ArrayList<>();

    private Dealership() {}

    public static Dealership getInstance() {
        if (instance == null) instance = new Dealership();
        return instance;
    }

    public void addCar(Car car) {
        purchasedCars.add(car);
    }

    public void displayAllCars() {
        if (purchasedCars.isEmpty()) {
            System.out.println("No cars purchased yet!");
        } else {
            System.out.println("\n=== Purchased Cars ===");
            for (Car c : purchasedCars) {
                c.displayinfo();
                System.out.println("-------------------");
            }
        }
    }
}

//Customer class for balance check
class Customer {
 private double balance;

 public Customer(double balance) {
     this.balance = balance;
 }

 public boolean deduct(double amount) {
     if (amount <= balance) {
         balance -= amount;
         System.out.println("Payment successful! Remaining balance: $" + balance);
         return true;
     } else {
         System.out.println("Insufficient balance! You have only $" + balance);
         return false;
     }
 }

 public void showBalance() {
     System.out.println("Current Balance: $" + balance);
 }
}

interface Mediaplayer{
	 void startmusic(String name, int year, char symbol, double length , boolean isStart);
	 void endmusic(String name, int year, char symbol, double length, boolean isEnd);
	 void pausemusic(String name, int year, char symbol, double length, boolean isPause);
}

interface Engine {
	void startengine(String message, boolean isStarted);
	void stopengine (String message, boolean isStopped);
}

interface AC{
	void start(String message, boolean isStart);
}

interface Amount{
	void calculateprice(double price);
}

class Car{
	 private String name;
	 private char carlogo;
	 private int year;
	 protected double price;
	 private boolean isCertified;
	 private double fuelmillage;
	 protected boolean purchased;
	 
Car( String name,char carlogo,int year,double price,boolean isCertified,double fuelmillage,boolean purchased){
		 this.name=name;
		 this.carlogo=carlogo;
		 this.year=year;
		 this.price=price;
		 this.isCertified=isCertified;
		 this.fuelmillage=fuelmillage;
		 this.purchased=purchased;
	 }
	 
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	 
	public char getCarlogo() {
		return carlogo;
	}
	
	public void setCarlogo(char carlogo) {
		this.carlogo=carlogo;
	}
	 
	public int getYear() {
		return year;
	}
	
	public void setYear(int  year) {
		this.year=year;
	}
	 
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price=price;
	}
	
	public boolean getisCertified() {
		return isCertified;
	}
	
	public void setisCertified(boolean isCertified) {
		this.isCertified=isCertified;
	}
	
	public double getFuelMillage() {
		return fuelmillage;
	}
	
	public void setFuelMillage(double fuelmillage) {
		this.fuelmillage=fuelmillage;
	}
	 
	public void calculateprice(double price) {
		System.out.println("Price is: " + " , " + price);
		}
 
	public void displayinfo() {
		System.out.println("Car name is: " + " , " + name + "Carlogo is: " + " , " + carlogo +
				"Model is : " + " , " + year + "Price is: " + " , " + price+
				"Is it certified or not? : " + " , " + isCertified + "Millage is: " + " , " + fuelmillage);
	}
 }
	
 class ElectricCar extends Car implements Mediaplayer, Engine, AC,Amount{
	
	private boolean isselfDriving;
	private boolean hasAirbags;
	protected static final double value=150000.00;
	
	ElectricCar(String name, char carlogo, int year,double price, boolean isCertified, 
			double fuelmillage,boolean purchased,boolean isselfDriving,boolean hasAirbags)
	{
		super(name, carlogo, year,price,isCertified, fuelmillage,purchased);
		this.isselfDriving=isselfDriving;
		this.hasAirbags=hasAirbags;
	}
	
	public boolean getisSelfDriving() {
		return isselfDriving;
	}
	
	public void setisSelfDriving(boolean isselfDriving) {
		this.isselfDriving=isselfDriving;
	}
	public boolean getHasAirbags() {
		return hasAirbags;
	}
	
	public void setHasAirbags(boolean hasAirbags) {
		this.hasAirbags=hasAirbags;
	}
	
	@Override
	public void calculateprice(double price) {
		if (price<=this.value) {
			purchased=true;
			System.out.println("Thank You for purchasing it ! Order Confirmed");
			displayinfo();
			Dealership.getInstance().addCar(this);
		}
		else {
			purchased=false;
		System.out.println("We are sorry! Order Cancelled");
		displayinfo();
		}
	}
 
	@Override
	 public void displayinfo() {
			System.out.println("Car name is: " + " , " + getName() + "Carlogo is: " + " , " + getCarlogo() +
				"Model is : " + " , " + getYear() + "Price is : " + " , " + getPrice() +
				"Is it certified or not? : " + " , " + getisCertified() + "Millage is: " + " , " + getFuelMillage() +
				"It can selfdrive " + " , " + isselfDriving  + "Has Airbags:  "+ " , " + hasAirbags);
		}
	
	@Override
	public void startengine(String message, boolean isStarted) {
	    if (isStarted) {
	        System.out.println("ElectricCar engine started: " +message);
	    }
	}

	@Override
	public void stopengine(String message, boolean isStopped) {
	    if (isStopped) {
	        System.out.println("ElectricCar engine stopped: " + message);
	    }
	}

	@Override
	public void startmusic(String name, int year, char symbol, double length, boolean isStart) {
	    if (isStart) {
	        System.out.println(" Media started in ElectricCar " + name+
	        		  ", Year: " + year +
	                  ", Symbol: " + symbol + ", Length: " + length +
	                  ", isStart: " + isStart);
	    }
	}

	@Override
	public void endmusic(String name, int year, char symbol, double length, boolean isEnd) {
	    if (isEnd) {
	        System.out.println(" Media stopped in ElectricCar " + name+
	        		  ", Year: " + year +
	                  ", Symbol: " + symbol + ", Length: " + length +
	                  ", Stopped: " + isEnd);
	    }
	}

	@Override
	public void pausemusic(String name, int year, char symbol, double length, boolean isPause) {
	    if (isPause) {
	        System.out.println("Media paused in ElectricCar " + name+
	        		" Year: " + year +
	                  ", Symbol: " + symbol + ", Length: " + length +
	                  ", Paused: " + isPause);
	    }
	}

	@Override
	public void start(String message, boolean isStartAC) {
	    if (isStartAC) {
	        System.out.println(" AC started in ElectricCar: " + message);
	    }
	}
 }
	
class SportsCar extends Car implements Mediaplayer, Engine, AC,Amount{
		
		private boolean isselfDriving;
		private boolean hasAirbags;
		private boolean hascruisemod;
		private boolean hasturbocharged;
		protected static final double value=50000.00;

	SportsCar(String name, char carlogo, int year, double price, boolean isCertified, 
				double fuelmillage,boolean purchased,boolean isselfDriving,boolean hasAirbags,
				boolean hascruisemod, boolean hasturbocharged)
		{
			super(name, carlogo, year, price, isCertified, fuelmillage,purchased);
			this.isselfDriving=isselfDriving;
			this.hasAirbags=hasAirbags;
			this.hascruisemod=hascruisemod;
			this.hasturbocharged=hasturbocharged;
		}
		
		public boolean getisSelfDriving() {
			return isselfDriving;
		}
		public void setisSelfDriving(boolean isselfDriving) {
			this.isselfDriving=isselfDriving;
		}
		
		public boolean getHasAirbags() {
			return hasAirbags;
		}
		public void setHasAirbags(boolean hasAirbags) {
			this.hasAirbags=hasAirbags;
		}
		
		public boolean getHasCruiseMod() {
			return hascruisemod;
		}
		public void setHasCruisemod(boolean hascruisemod) {
			this.hascruisemod=hascruisemod;
		}
		
		public boolean getHasTurbocharged() {
			return hasturbocharged;
		}
		public void setHasTruboCharged(boolean hasturbocharged) {
			this.hasturbocharged=hasturbocharged;
		}
		
		@Override
		public void calculateprice(double price) {
			if (price<=this.value) {
				purchased=true;
				System.out.println("Thank You for purchasing it ! Order Confirmed");
				displayinfo();
				Dealership.getInstance().addCar(this);
			}
			else {
				purchased=false;
			System.out.println("We are sorry! Order Cancelled");
			displayinfo();
			}
		}
		
		@Override
		 public void displayinfo() {
			System.out.println("Car name is: " + " , " + getName() + "Carlogo is: " + " , " + getCarlogo() +
				"Model is : " + " , " + getYear() + "Price is : " + " , " + getPrice() +
				"Is it certified or not? : " + " , " + getisCertified() + "Millage is: " + " , " + getFuelMillage() +
					"It can selfdrive " + " , " + isselfDriving  + "Has Airbags: + "+ " , " + hasAirbags
					+ "It has crusie mod: " + " ," + hascruisemod + "Trobocharged:" + " , " + hasturbocharged);
			}
		
		@Override
		public void startengine(String message, boolean isStarted) {
		    if (isStarted) {
		        System.out.println("SportsCar engine started: " + message);
		    }
		}

		@Override
		public void stopengine(String message, boolean isStopped) {
		    if (isStopped) {
		        System.out.println("SportsCar engine stopped: " + message);
		    }
		}

		@Override
		public void startmusic(String name, int year, char symbol, double length, boolean isStart) {
		    if (isStart) {
		        System.out.println(" Media started in SportsCar " + name+
		        		" Year: " + year +
		                  ", Symbol: " + symbol + ", Length: " + length +
		                  ", Started: " + isStart);
		    }
		}

		@Override
		public void endmusic(String name, int year, char symbol, double length, boolean isEnd) {
		    if (isEnd) {
		        System.out.println(" Media ended in SportsCar " + name+
		        		" Year: " + year +
		                  ", Symbol: " + symbol + ", Length: " + length +
		                  ", Stopped: " + isEnd);
		    }
		}

		@Override
		public void pausemusic(String name, int year, char symbol, double length, boolean isPause) {
		    if (isPause) {
		        System.out.println("Media paused in SportsCar " + name+
		        		", Year: " + year +
		                  ", Symbol: " + symbol + ", Length: " + length +
		                  ", Paused: " + isPause);
		    }
		}

		@Override
		public void start(String message, boolean isStartAC) {
		    if (isStartAC) {
		        System.out.println(" AC started in SportsCar: " + message);
		    }
		}
}
		
 class OffroadCar extends Car implements Mediaplayer, Engine, AC,Amount{
			
			private boolean isselfDriving;
			private boolean hasAirbags;
			private boolean awd;
			private boolean allterrainmode;
			protected static final double value = 30000.00;
			
	OffroadCar(String name, char carlogo, int year, double price, boolean isCertified, 
					double fuelmillage,boolean purchased,boolean isselfDriving,boolean hasAirbags,boolean awd,boolean allterrainmode)
			{
				super(name, carlogo, year, price, isCertified, fuelmillage,purchased);
				this.isselfDriving=isselfDriving;
				this.hasAirbags=hasAirbags;
				this.awd=awd;
				this.allterrainmode=allterrainmode;
			}
			
			public boolean getisSelfDriving() {
				return isselfDriving;
			}
			
			public void setisSelfDriving(boolean isselfDriving) {
				this.isselfDriving=isselfDriving;
			}
			public boolean getHasAirbags() {
				return hasAirbags;
			}
			
			public void setHasAirbags(boolean hasAirbags) {
				this.hasAirbags=hasAirbags;
			}
			
			public boolean getAWD() {
				return awd;
			}
			public void setAWD(boolean awd) {
				this.awd=awd;
			}
			
			public boolean getAllTerrainmode() {
				return allterrainmode;
			}
			public void setAllTerrainMode(boolean allterrainmode) {
				this.allterrainmode=allterrainmode;
			}
			
			@Override
			public void calculateprice(double price) {
				if (price<=this.value) {
					purchased=true;
					System.out.println("Thank You for purchasing it ! Order Confirmed");
					displayinfo();
					Dealership.getInstance().addCar(this);
				}
				else {
					purchased=false;
				System.out.println("We are sorry! Order Cancelled");
				displayinfo();
				}
			}
			
			@Override
			 public void displayinfo() {
				System.out.println("Car name is: " + " , " + getName() + "Carlogo is: " + " , " + getCarlogo() +
					"Model is : " + " , " + getYear() + "Price is : " + " , " + getPrice() +
					"Is it certified or not? : " + " , " + getisCertified() + "Millage is: " + " , " + getFuelMillage() +
						"It can selfdrive " + " , " + isselfDriving  + "Has Airbags: + "+ " , " + hasAirbags
						+ "Its all weheeldrive: " + " ," + awd+ "Run evertwhere:" + " , " + allterrainmode);
				}
			
			@Override
			public void startengine(String message, boolean isStarted) {
			    if (isStarted) {
			        System.out.println("OffradCar engine started: " + message);
			    }
			}

			@Override
			public void stopengine(String message, boolean isStopped) {
			    if (isStopped) {
			        System.out.println("OffroadCar engine stopped: " + message);
			    }
			}

			@Override
			public void startmusic(String name, int year, char symbol, double length, boolean isStart) {
			    if (isStart) {
			        System.out.println(" Media started in OffroadCar " + name+
			        		", Year: " + year +
			                  ", Symbol: " + symbol + ", Length: " + length +
			                  ", Started: " + isStart);
			    }
			}

			@Override
			public void endmusic(String name, int year, char symbol, double length, boolean isEnd) {
			    if (isEnd) {
			        System.out.println(" Media ended in OffraodCar " + name+
			        		", Year: " + year +
			                  ", Symbol: " + symbol + ", Length: " + length +
			                  ", Stopped: " + isEnd);
			    }
			}

			@Override
			public void pausemusic(String name, int year, char symbol, double length, boolean isPause) {
			    if (isPause) {
			        System.out.println("Media paused in OffroadCar " + name+
			        		", Year: " + year +
			                  ", Symbol: " + symbol + ", Length: " + length +
			                  "Puased: " + isPause);
			    }
			}

			@Override
			public void start(String message, boolean isStartAC) {
			    if (isStartAC) {
			        System.out.println(" AC started in OffraodCar: " + message);
			    
			    }
			}
 		}	
 
 public class Main {
     public static void main(String[] args) {
     	Customer customer = new Customer(200000);
         Scanner sc = new Scanner(System.in);
         Random rand = new Random();
         Car selectedCar = null;

         while (true) {
             System.out.println("\n=== MUNEEB CAR SHOWROOM===");
             System.out.println("1. Buy Electric Car");
             System.out.println("2. Buy Sports Car");
             System.out.println("3. Buy Offroad Car");
             System.out.println("4. Display purchased Cars");
             System.out.println("5. Check Balance");
             System.out.println("6. Start MuediaPlayer");
             System.out.println("7. Start Engine + AC");
             System.out.println("0. Exit");
             System.out.print("Enter choice: ");
             int choice = sc.nextInt();
     
             switch (choice) {
                 case 1 -> {
                     Car car1 = new ElectricCar("Tesla", 'T', 2024, 140000, true, 450, false, true, true);
                     System.out.print("Enter price to confirm: ");
                     double p = sc.nextDouble();
                     Amount amt = (pr) -> car1.calculateprice(pr); 
                     amt.calculateprice(p);
                     if (car1.purchased) { 
                         selectedCar = car1;
                     }
                 }
                 case 2 -> {
                     Car car2 = new SportsCar("Ferrari", 'F', 2023, 48000, true, 300, true, true, true, true, true);
                     System.out.print("Enter price to confirm: ");
                     double p = sc.nextDouble();
                     Amount amt = (pr) -> car2.calculateprice(pr); 
                     amt.calculateprice(p);
                     if (car2.purchased) {
                         selectedCar = car2;
                     }
                 }
                 case 3 -> {
                     Car car3 = new OffroadCar("Jeep", 'J', 2022, 28000, true, 350, false, true, true, true, true);
                     System.out.print("Enter price to confirm: ");
                     double p = sc.nextDouble();
                     Amount amt = (pr) -> car3.calculateprice(pr); 
                     amt.calculateprice(p);
                     if (car3.purchased) {
                         selectedCar = car3;
                     }
                 }
                 case 4 -> {
                	 Dealership.getInstance().displayAllCars();
                	 if (selectedCar != null) {selectedCar.displayinfo();}
                	 else { 
                    	 System.out.println(" No car selected yet!");
                	 }
                 }
             
                 case 5 -> {
                	 customer.showBalance();
                 }
                 
                 case 6 -> {
                     if (selectedCar != null && selectedCar instanceof Mediaplayer m) {
                         m.startmusic(selectedCar.getName(), selectedCar.getYear(),
                                 selectedCar.getCarlogo(), rand.nextInt(200) + 100, true);
                         m.pausemusic(selectedCar.getName(), selectedCar.getYear(),
                                 selectedCar.getCarlogo(), 100, true);
                         m.endmusic(selectedCar.getName(), selectedCar.getYear(),
                                 selectedCar.getCarlogo(), 200, true);
                     } else {
                         System.out.println(" No car purchased yet!");
                     }
                 }
                 case 7 -> {
                     if (selectedCar != null && selectedCar instanceof Engine e && selectedCar instanceof AC a) {
                         e.startengine("Ignition", true);
                         a.start("Cooling mode", true);
                         e.stopengine("Ignition off", true);
                     } else {
                         System.out.println(" No car purchased yet!");
                     }
                 }
                 case 0 -> {
                     System.out.println("Exiting... Bye!");
                     System.exit(0);
                 }
                 default -> System.out.println(" Invalid choice!");
             }  
         }
     }  
 }

