//Abdullah Arif
import java.util.*;
public class HashTable<T>{
	private ArrayList<LinkedList<T>> table;
	private int size;
	private double maxLoad;
	public HashTable(){
		table=blank(10);
		size=0;
		maxLoad=0.7;
	}
	public ArrayList<LinkedList<T>> blank(int n){
		ArrayList<LinkedList<T>> arr= new ArrayList<LinkedList<T>>();
		for(int i=0; i<n ;i++){
			arr.add(null);
		}
		return arr;
	}
	public void add(T val){
		int h = Math.abs(val.hashCode());
		int pos = h%table.size();
		if(table.get(pos)==null){
			table.set(pos,new LinkedList<T>());
		}
		table.get(pos).add(val);
		size++;
		if (size/table.size()>maxLoad){
			resize(table.size()*2);
		}
	}
	public void resize(int size){
		ArrayList<LinkedList<T>>tmp =table;
		table= blank(size);
		size=0;
		for(LinkedList<T> lyst :tmp){
			if(lyst!=null){
				for(T val: lyst){
					add(val);
				}
			}
		}
	}
	public String toString(){
		String ans= "";
		for(LinkedList<T> brown:table){
			if(brown != null){
				for(T val : brown){
					ans+="<"+val+">";
				}
			}
		}
		return "$"+ans+"$";
	}
	public void remove(T val){ //remove**
		int h = Math.abs(val.hashCode()), pos = h%table.size();
		if(table.get(pos)!=null){
			table.get(pos).remove(val);
			size--;
		}
	}
	public T get(int key){
		for(int i=0;i<table.size();i++){
			if(table.get(i)!=null){
				for(int j=0;j<table.get(i).size();j++){
					if(table.get(i).get(j).hashCode() == key){
						return table.get(i).get(j);
					}
				}
			}
			return null;
		}
		return null;
	}
	public double getLoad(){
		return (double)(size)/(double)(table.size());
	}
	public void setMaxLoad(double percent){
		if(0.1<percent && percent<0.8){
			maxLoad=percent;
		}
		else{
			System.out.println("Invalid percentage!/nEnter a number beetween 0.1 and 0.8");
		}
	}
	public void setLoad(double percent){
		if(0.1<percent && percent<0.8 && percent<maxLoad){
			resize((int)((double)(size)/getLoad()));
		}
	}
	
	public ArrayList toArray(){
		ArrayList<T>temp = new ArrayList<T>();
		for(LinkedList<T> list : table){
			if(list != null){
				for(T val:list){
					temp.add(val);
				}
			}
		}
		return temp;
	}
	public boolean has(T val){
		int pos = Math.abs(val.hashCode())%table.size();
		if(table.get(pos) != null){
			for(T v :table.get(pos)){
				if(v.equals(val)){
					return true;
				}
			}
		}
		return false;
	}
}