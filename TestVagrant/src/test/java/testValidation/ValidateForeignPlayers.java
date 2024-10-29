package testValidation;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import junit.framework.Assert;

public class ValidateForeignPlayers {
//NADEMM FROM REMOTE
	//aYERA BAG FROM REMOTE
	@Test
	public void valFourForeignPlayers() throws IOException, ParseException {

		int countForiegnPlayer = 0;
		FileReader readFile = new FileReader(".\\src\\test\\java\\jsonBody\\jsonBody.json");

		JSONParser jsonParser = new JSONParser();
		Object parseObject = jsonParser.parse(readFile);
		JSONObject jsonObject = (JSONObject) parseObject;
		JSONArray playerArray = (JSONArray) jsonObject.get("player");

		for (int i = 0; i < playerArray.size(); i++) {

			JSONObject player = (JSONObject) playerArray.get(i);
			if (!player.get("country").equals("India")) {
				countForiegnPlayer++;
			}

		}
		// Validating the 4 foreign player
		Assert.assertEquals(4, countForiegnPlayer);
//comment from remote
//comment from local
		if (countForiegnPlayer == 4) {
			System.out.println("Royal Challengers Bangalore has 4 foriegn player");
		} else {
			System.out.println("Royal Challengers Bangalore has more than 4 foriegn player");
		}

	}

}
