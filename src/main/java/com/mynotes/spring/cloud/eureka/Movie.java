package com.mynotes.spring.cloud.eureka;

public class Movie {

    private Integer id;

    private String title;

    private String distributor;
    
    private String rankAndYear;

    public Movie() {
    }

	public Movie(Integer id, String title, String distributor, String rankAndYear) {
		super();
		this.id = id;
		this.title = title;
		this.distributor = distributor;
		this.rankAndYear = rankAndYear;
	}

	public Integer getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}

	public String getDistributor() {
		return distributor;
	}

	public String getRankAndYear() {
		return rankAndYear;
	}

    
  

}
