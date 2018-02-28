package hello;



	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;

	@Entity
	public class Countrycodes {

		@Id
		@GeneratedValue
		private Long country_ID;

		private String country_Name;

		private String text_Description;
		private String html_Description;
		private String image;

		protected Countrycodes() {
		}

		public Countrycodes(Long country_ID, String country_Name, String text_Description, String html_Description, String image ) {
			this.country_ID = country_ID; 
			this.country_Name = country_Name;
			
			this.text_Description = text_Description;
			this.html_Description = html_Description;
			this.image = image;
			
			
			
		}

		public Long getCountry_ID() {
			return country_ID;
		}

		public void setCountry_ID(Long country_ID) {
			this.country_ID = country_ID;
		}

		public String getCountry_Name() {
			return country_Name;
		}

		public void setCountry_Name(String country_Name) {
			this.country_Name = country_Name;
		}

		public String getText_Description() {
			return text_Description;
		}

		public void setText_Description(String text_Description) {
			this.text_Description = text_Description;
		}

		public String getHtml_Description() {
			return html_Description;
		}

		public void setHtml_Description(String html_Description) {
			this.html_Description = html_Description;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		

		@Override
		public String toString() {
			return String.format("countrycodes[country_ID=%d, country_Name='%s', text_Description='%s',  html_Description='%s', image='%s']", country_ID,
					country_Name, text_Description, html_Description, image);
		}

	}

	

