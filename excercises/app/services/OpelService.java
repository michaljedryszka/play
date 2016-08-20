package services;

import com.google.inject.Singleton;

@Singleton
public class OpelService implements CarService{
	
	static int count = 0;
	
	public OpelService(){
		count ++;
		System.out.println("Ilosc obiektów: " + count);
	}

	@Override
	public void makeNoise() {
		System.out.println("Opel");
	}

}
