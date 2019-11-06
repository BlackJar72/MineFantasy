package jaredbgreat.mf3.api.crafting.anvil;

public interface IAnvil {
	void setForgeTime(int i);
	void setHammerUsed(int i);
	void setRequiredAnvil(int i);
	void setHotOutput(boolean i);
	void setToolType(String toolType);
	// TODO: Skill ... maybe, or maybe drop that aspect
	//void setSkill(Skill skill);
	public void setResearch(String research);
}
