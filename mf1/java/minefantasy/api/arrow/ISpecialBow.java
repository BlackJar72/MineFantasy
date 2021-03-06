package minefantasy.api.arrow;

import net.minecraft.entity.Entity;

public interface ISpecialBow 
{
	/**
	 * This is called when an arrow is fired from a bow
	 * if you have your own arrows firing, call this method when spawning it in world
	 * 
	 * Allows to modify an arrow when fired from this bow
	 * @param arrow the arrow fired(use a cast to determine what class it is)
	 * @return the same arrow, but modified
	 */
	public Entity modifyArrow(Entity arrow);
}
