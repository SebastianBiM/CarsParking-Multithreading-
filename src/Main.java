

public class Main {

	public static void main(String[] args) {

	System.out.println("Welcome In My Parking");	
		
	Parking parking = new Parking();
		
	Thread t1 = new Thread(new Runnable() {
		
		@Override
		public void run() {
			try {
				parking.addCarToQue();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	});
	
	Thread t2 = new Thread(new Runnable() {
		
		@Override
		public void run() {
				try {
					parking.showParking();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	});
	
	Thread t3 = new Thread(new Runnable() {
		
		@Override
		public void run() {
				try {
					parking.showQue();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	});
	
	Thread t4 = new Thread(new Runnable() {
		
		@Override
		public void run() {
				try {
					parking.removeCar();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	});
	
	Thread t5 = new Thread(new Runnable() {
		
		@Override
		public void run() {
				try {
					parking.removeCoupleCar();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	});
	
	Thread t6 = new Thread(new Runnable() {
		
		@Override
		public void run() {
				try {
					parking.addCarToMap();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	});
	
	t1.start();
	t2.start();
	t3.start();
	t4.start();
	t5.start();
	t6.start();
	
	try {
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		t5.join();
		t6.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println("It's done");


	
	}
}
