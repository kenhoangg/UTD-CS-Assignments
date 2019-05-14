/**
 *	@author Kenny Hoang
 *	Class: CS2336 - Computer Science II
 *	Section: 001	
 *	Semester: Fall 2016
 *
 *	Assignment: Term Project
 **/

// Warehouse.java implements the Warehouse class

// Import statements
import java.util.ArrayList;

public class Warehouse extends Building {
	private int size;
	private int inventory;
	private ArrayList<Worker> workers = new ArrayList<Worker>();
	private int numWorkers = 0;
	
	public Warehouse(){
		super();
		this.size = 100;
		this.inventory = 0;
	}
	
	public Warehouse(String name, int size, int inventory){
		super(name);
		this.setSize(size);
		this.setInventory(inventory);
	}
	
	// Get Methods
	public int getSize(){
		return size;
	}
	
	public int getInventory(){
		return inventory;
	}
	
	public int getNumWorkers(){
		return numWorkers;
	}
	
	public String getWorkerName(int index){
		Worker w;
		w = workers.get(index);
		return w.getName();
	}
	
	public double getWage(int index){
		Worker w;
		w = workers.get(index);
		return w.getWage();
	}
	
	public double getHours(int index){
		Worker w;
		w = workers.get(index);
		return w.getHours();
	}
	
	public double getSalary(int index){
		Worker w;
		w = workers.get(index);
		return w.getSalary();
	}

	// Set Methods
	public void setSize(int size){
		this.size = size;
	}
	
	public void setInventory(int inventory){
		this.inventory = inventory;
	}
	
	public void setWage(int index, double wage){
		Worker w;
		w = workers.get(index);
		w.setWage(wage);
	}
	
	public void setHours(int index, double hours){
		Worker w;
		w = workers.get(index);
		w.setWage(hours);
	}
	
	// Modifier Methods
	public void increaseSize(int size){
		this.size += size;
	}
	
	public void decreaseSize(int size){
		this.size -= size;
	}
	
	public void increaseInventory(int inventory){
		this.inventory += inventory;
	}
	
	public void decreaseInventory(int inventory){
		this.inventory -= inventory;
	}
	
	public void addWorker(Worker worker){
		workers.add(worker);
		numWorkers++;
	}
	
	public void removeWorker(int index){
		workers.remove(index-1);
		numWorkers--;
		//workers.trimToSize();
	}
	
	public void displayWorkers(){
		int counter = 1;
		for(Worker w : this.workers){
			System.out.printf("%d. %s\n", counter, w.getName());
			counter++;
		}
	}
}
