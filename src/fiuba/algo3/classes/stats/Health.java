package fiuba.algo3.classes.stats;

public class Health {

	private Integer maxHealth;
	private Integer currentHealth;
	
	public Health(Integer health){
		maxHealth = health;
		currentHealth = health;
	}

	public Integer getMaxHealth() {
		return maxHealth;
	}

	public Integer getCurrentHealth() {
		return currentHealth;
	}
	
}
