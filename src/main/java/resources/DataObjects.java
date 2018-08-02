package resources;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataObjects {

	@JsonProperty("url")
	String url;

	@JsonProperty("invalidUsername")
	String invalidUsername;

	@JsonProperty("invalidPassword")
	String invalidPassword;

	@JsonProperty("validUsername")
	String validUsername;

	@JsonProperty("validPassword")
	String validPassword;

	@JsonProperty("incorrectCredentialsErrorMessage")
	String incorrectCredentialsErrorMessage;

	public String getUrl() {
		return url;
	}

	public String getInValidUserName() {
		return invalidUsername;
	}

	public String getInvalidPassword() {
		return invalidPassword;
	}

	public String getValidUsername() {
		return validUsername;
	}

	public String getValidPassword() {
		return validPassword;
	}

	public String incorrectCredentialsErrorMessage() {
		return incorrectCredentialsErrorMessage;
	}

	public static DataObjects getData(String fileName) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(new File(fileName), DataObjects.class);

	}

}
