package testValidation;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class ValidateWicketKeeper {
	@Test
	public void validateWicketKeeper() throws IOException, ParseException {
		
		int wicketKeeperPlayer = 0;
		FileReader readFile = new FileReader(".\\src\\test\\java\\jsonBody\\jsonBody.json");

		JSONParser jsonParser = new JSONParser();
		Object parseObject = jsonParser.parse(readFile);
		JSONObject jsonObject = (JSONObject) parseObject;
		JSONArray playerArray = (JSONArray) jsonObject.get("player");

		for (int i = 0; i < playerArray.size(); i++) {
			
			JSONObject player = (JSONObject) playerArray.get(i);
			if (player.get("role").equals("Wicket-keeper")) {
				wicketKeeperPlayer++;
			}

		}
		// Validating the 1 wicket-Keeper Player
		Assert.assertEquals(1, wicketKeeperPlayer);

		if (wicketKeeperPlayer == 1) {
			System.out.println("Royal Challengers Bangalore has 1 wicket-Keeper Player");
		} else {
			System.out.println("Royal Challengers Bangalore has more than 1 wicket-Keeper Player");
		}

	}

}
