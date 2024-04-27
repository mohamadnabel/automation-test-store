package parameters;

import java.util.Random;

public class Parameters {
	protected String URL = "https://automationteststore.com/";
	protected Random rand = new Random();
	protected String[] randoomFirstName = { "mohammad", "ahmad", "yousef", "Esaa", "rama" };
	protected String[] randoomLastName = { "mahmoud", "yazan", "basell", "kallel", "omran" };
	protected int randLName = rand.nextInt(randoomLastName.length);
	protected int randFName = rand.nextInt(randoomFirstName.length);
	protected int randomNum = rand.nextInt(99);


}
