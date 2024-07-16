package com.oym.service;

import java.util.ArrayList;

import com.oym.vo.Chinese;
import com.oym.vo.Customer;
import com.oym.vo.Japanese;
import com.oym.vo.Korean;
import com.oym.vo.Restaurant;
import com.oym.vo.Review;
import com.oym.vo.Western;

public class CustomerServiceImpl implements CustomerService{
	
	private ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>(){{
		new Chinese("만리성", "02-111-2222", "관철동", 1000, 2100, new ArrayList<Review>(){{
			new Review("아주 좋아요", 1, "만리성");
			new Review("맛있어요", 3, "만리성");
			new Review("재미있어요", 2, "만리성");
			new Review("별로에요", 5, "만리성");
			new Review("집에가고싶어요", 5, "만리성");
		}}, null);
		new Chinese("광한루", "02-222-4444", "월곡동", 900, 2200, new ArrayList<Review>(){{
			new Review("아주 좋아요", 1, "광한루");
			new Review("맛있어요", 3, "광한루");
			new Review("재미있어요", 2, "광한루");
			new Review("별로에요", 5, "광한루");
			new Review("집에가고싶어요", 5, "광한루");
			new Review("집에가고싶어요", 4, "광한루");
		}}, null);
		new Japanese("갓덴스시", "02-444-5555", "삼성동", 1100, 2100, new ArrayList<Review>(){{
			new Review("아주 좋아요", 1, "갓덴스시");
			new Review("맛있어요", 3, "갓덴스시");
			new Review("재미있어요", 2, "갓덴스시");
			new Review("별로에요", 5, "갓덴스시");
		}}, null);
		new Japanese("코다차야", "02-888-7777", "쌍문동", 1700, 300, new ArrayList<Review>(){{
			new Review("아주 좋아요", 1, "코다차야");
			new Review("맛있어요", 3, "코다차야");
			new Review("재미있어요", 2, "코다차야");
		}}, null);
		new Korean("이리오너라", "02-999-2699", "관철동", 700, 100, new ArrayList<Review>(){{
			new Review("아주 좋아요", 1, "이리오너라");
			new Review("맛있어요", 3, "이리오너라");
			new Review("재미있어요", 2, "이리오너라");
			new Review("별로에요", 5, "이리오너라");
			new Review("집에가고싶어요", 4, "이리오너라");
			new Review("집에가고싶어요", 3, "이리오너라");
		}}, null);
		new Korean("집밥", "02-465-6564", "관철동", 1000, 1100, new ArrayList<Review>(){{
			new Review("아주 좋아요", 1, "집밥");
			new Review("맛있어요", 3, "집밥");
			new Review("재미있어요", 2, "집밥");
			new Review("별로에요", 2, "집밥");
			new Review("집에가고싶어요", 3, "집밥");
		}}, null);
		new Western("롤링파스타", "02-886-4569", "쌍문동", 0, 2400, new ArrayList<Review>(){{
			new Review("아주 좋아요", 1, "롤링파스타");
			new Review("맛있어요", 3, "롤링파스타");
			new Review("재미있어요", 2, "롤링파스타");
			new Review("별로에요", 2, "롤링파스타");
			new Review("집에가고싶어요", 3, "롤링파스타");
			new Review("집에가고싶어요", 4, "롤링파스타");
			new Review("집에가고싶어요", 5, "롤링파스타");
			new Review("집에가고싶어요", 1, "롤링파스타");
			new Review("집에가고싶어요", 1, "롤링파스타");
		}}, null);
		new Western("양식이 뭐가있을까", "02-444-7768", "무슨동", 500, 1500, new ArrayList<Review>(){{
			new Review("아주 좋아요", 4, "양식이 뭐가있을까");
			new Review("맛있어요", 3, "양식이 뭐가있을까");
			new Review("재미있어요", 2, "양식이 뭐가있을까");
			new Review("별로에요", 2, "양식이 뭐가있을까");
			new Review("집에가고싶어요", 2, "양식이 뭐가있을까");
			new Review("집에가고싶어요", 3, "양식이 뭐가있을까");
			new Review("집에가고싶어요", 5, "양식이 뭐가있을까");
		}}, null);
	//메뉴 작성 추후에
		
	}};
	
	private static CustomerServiceImpl service = new CustomerServiceImpl();
	
	private CustomerServiceImpl(){ }
	
	static CustomerServiceImpl getInstance() {
		return service;
	}
	
	ArrayList<Customer> customers = new ArrayList<>();
	

	@Override
	public void register(Customer customer) {
		customers.add(customer);
		
	}

	@Override
	public Customer findCustomer(String id) {
		
		Customer c = null;
		for(Customer tmp : customers) {
			if( tmp.getId() == id) {
				c = tmp;
				break;
			}
		}
		
		return c;
	}

	@Override
	public void updateCustomer(Customer user) {

		for(int i=0; i<customers.size(); i++) {
			if( customers.get(i).getId() == user.getId()) {
				customers.get(i).changeAddress(user.getAddress());
				customers.get(i).changePw(user.getPw());
				customers.get(i).changeFavorite(user.getFavorite());
				break;
			}
		}
		
	}

	@Override
	public void deleteCustomer(String id) {
		
		for(int i=0; i<customers.size(); i++) {
			if(customers.get(i).getId() == id) {
				customers.remove(i);
				break;
			}
		}
		
	}

	@Override
	public ArrayList<Restaurant> findAllRestaurant() {
		
		return restaurants;
	}

	@Override
	// 한식,양식,중식 입력받아서 해당하는 레스토랑 리스트 리턴
	public ArrayList<Restaurant> findRestaurantByCategory(String category) {
		ArrayList<Restaurant> t= new ArrayList<Restaurant>();
		switch(category) {
		case "한식": 
			for(Restaurant r : restaurants) {
				if(r instanceof Korean) t.add(r);
			}
		case "일식": 
			for(Restaurant r : restaurants) {
				if(r instanceof Japanese) t.add(r);
			}
		case "양식": 
			for(Restaurant r : restaurants) {
				if(r instanceof Western) t.add(r);
			}
		case "중식": 
			for(Restaurant r : restaurants) {
				if(r instanceof Chinese) t.add(r);
			}
			
		}
		return t;
	}

	@Override
	public ArrayList<Restaurant> findRestaurantByLocation(String location) {
		ArrayList<Restaurant> t= new ArrayList<Restaurant>();
		for(Restaurant r : restaurants) {
			if(r.getLocation().equals(location)) t.add(r);
		}
		return t;
	}

	@Override
	public ArrayList<Restaurant> findRestaurantByName(String name) {
		ArrayList<Restaurant> t= new ArrayList<Restaurant>();
		for(Restaurant r : restaurants) {
			if(r.getName().contains(name)) t.add(r);
		}
		return t;
	}

	@Override
	public Restaurant[] recommendRestaurantByAddress(Customer customer) {
		return null;
	}

	@Override
	public Restaurant[] recommendRestaurantByCategory(Customer customer) {
		return null;
	}

	@Override
	public Restaurant[] recommendRestaurantByRating(Customer customer) {
		return null;
	}

	@Override
	public Restaurant[] recommendRestaurantByReviews(Customer customer) {
		return null;
	}

	@Override
	public Restaurant[] recommendRestaurantByGender(Customer customer) {
		return null;
	}

	@Override
	public Restaurant[] recommendRestaurantByAge(Customer customer) {
		return null;
	}



}
