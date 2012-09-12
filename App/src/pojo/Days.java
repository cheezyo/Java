package pojo;

public class Days {
	
	private String author, title, id, pages, year, syrke, tennis;
	
	
	public String getSyrke() {
		return syrke;
	}


	public void setSyrke(String syrke) {
		this.syrke = syrke;
	}


	public String getTennis() {
		return tennis;
	}


	public void setTennis(String tennis) {
		this.tennis = tennis;
	}


	public Days(String author, String title, String id, String pages,
			String year, String tennis, String syrke) {
		
		setAuthor(author);
		setId(id);
		setPages(pages);
		setTitle(title);
		setYear(year);
		setTennis(tennis);
		setSyrke(syrke);
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPages() {
		return pages;
	}


	public void setPages(String pages) {
		this.pages = pages;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}
	
	public String toString(){
		return getAuthor() + getTitle() + getYear();
	}
}
