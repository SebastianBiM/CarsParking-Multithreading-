import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

public class Parking {
	
	Queue<Integer> que = new ArrayDeque<Integer>();
	Map<Integer, Object> map = new HashMap<Integer, Object>();
	
	private int id;
	private int space;
	private Boolean addCarToQue = true;
	private Boolean addCarToMap = true;
	private Boolean showPar = true;
	private Boolean showQue = true;
	private Boolean removeCar = true;
	private Boolean removeCoupleCar = true;
	
	public Integer giveId(){
		
		id = new Random().nextInt(100) + 1;
		
		return id;
	}
	
	public void addCarToQue() throws InterruptedException{
		while(addCarToQue){
			Thread.sleep(1010);
			
			Car car = new Car(giveId());
	
			if(!que.contains(car.getId())) {
				que.add(car.getId());
			} 
		}
	}
	
	public void addCarToMap() throws InterruptedException{
		while(addCarToMap){
			Thread.sleep(100);
			
			do {
				space = new Random().nextInt(30) + 1;
				
				if(map.size() <= 30 && !map.containsKey(space) ){
					if(!que.isEmpty()){
						map.put(space, que.remove());
					}
				} 
			} while(map.containsKey(space));
				
				

		}
	}
	
	public void removeCar() throws InterruptedException{
		while(removeCar){
			Thread.sleep(5000);
			
			int v = new Random().nextInt(map.size() + 1);
			
			map.remove(v);
			
			System.out.println("This Car Said GOODBYE : " + v);
			System.out.println("-------------------------------------------------------------------------");
		}
	}
	
	public void removeCoupleCar() throws InterruptedException {
		while(removeCoupleCar){
				Thread.sleep(19000);
				
				ArrayList<Integer> toRemove = new ArrayList<Integer>();
				
				for(int i = 0; i < 10; i++){
					int v = new Random().nextInt(map.size() + 1);
						if(!toRemove.contains(v)){
							toRemove.add(v);
						}
				}
				
				for(int x : toRemove){
					map.remove(x);
					   System.out.println("Ten Cars Said GOODBYE : ");
					   System.out.println("CAR ID : " + x);
					   System.out.println("-------------------------------------------------------------------------");
				}
		}
	}
	
	
	
	public void showParking() throws InterruptedException{
		while(showPar){
			Thread.sleep(10000);
			
			for(Map.Entry<Integer, Object> par : map.entrySet()) {
					System.out.println("Key (SPACE) : " + par.getKey() + "    "  + "CAR ID : " + par.getValue());
			}
				
			System.out.println("-------------------------------------------------------------------------");
		}
	}
	
	public void showQue() throws InterruptedException{
		while(showQue){
			Thread.sleep(10500);
			
			Iterator<Integer> ite = que.iterator();
			
			if(!que.isEmpty()){
				while(ite.hasNext()){
					System.out.println("Waiting in QUE : " + ite.next());
				}
				System.out.println("-------------------------------------------------------------------------");
			}
		}
	}
	
	public void killer() throws InterruptedException{
		
		addCarToQue = false;
		addCarToMap = false;
		showPar = false;
		showQue = false;
		removeCar = false;
		removeCoupleCar = false;
		
		System.out.println("Parking is closed");
	}
	
	
}
