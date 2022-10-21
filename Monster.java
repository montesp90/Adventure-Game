
public class Monster extends Creature
{
	private boolean isEnraged = false;
	private int enrageThreshold;
	
	public Monster(String name, String description, int hitPoints, int damage, int enrageThreshold)
	{
		super(name,description,hitPoints,damage);
		
		this.enrageThreshold = enrageThreshold;
	}
	
	public boolean canEnrage()
	{
		if(super.getHitPoints() < this.enrageThreshold)
		{
			this.isEnraged = true;
			return this.isEnraged;
		}
		else
		{
			this.isEnraged = false;
			return this.isEnraged;
		}
	}
	
	public void enrage()
	{
		if(this.isEnraged == true)
		{
			int damage = super.getDamage() * 2;
			super.setDamage(damage);
		}
	}
}
