package jaredbgreat.mf3mobs.model;

//import minefantasy.entity.EntityDrake;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;



public class ModelDrake extends ModelBiped {
	ModelRenderer Lthigh;
	ModelRenderer LToe2;
	ModelRenderer Lleg;
	ModelRenderer LFoot;
	ModelRenderer LToe1;
	ModelRenderer Rthigh;
	ModelRenderer RToe2;
	ModelRenderer Rleg;
	ModelRenderer RFoot;
	ModelRenderer RToe1;
	ModelRenderer TailEnd;
	ModelRenderer Belly;
	ModelRenderer Body;
	ModelRenderer Mouth;
	ModelRenderer Tail;
	ModelRenderer TailTip;
	ModelRenderer Neck;
	ModelRenderer Head;
	ModelRenderer Jaw;
	ModelRenderer RThumb;
	ModelRenderer RArm;
	ModelRenderer RClaw;
	ModelRenderer LArm;
	ModelRenderer LThumb;
	ModelRenderer LClaw;
	ModelRenderer Back;

	public ModelDrake() {		
		textureWidth = 128;
		textureHeight = 128;

		Lthigh = new ModelRenderer(this, 0, 0);
		LToe2 = new ModelRenderer(this,  0, 55);
		Lleg = new ModelRenderer(this,  0, 20);
		LFoot = new ModelRenderer(this,  0, 34);
		LToe1 = new ModelRenderer(this,  0, 55);
		Rthigh = new ModelRenderer(this,  0, 0);
		RToe2 = new ModelRenderer(this,  0, 55);
		Rleg = new ModelRenderer(this,  0, 20);
		RFoot = new ModelRenderer(this,  0, 34);
		RToe1 = new ModelRenderer(this,  0, 55);
		TailEnd = new ModelRenderer(this,  70, 45);
		Belly = new ModelRenderer(this,  108, 105);
		Body = new ModelRenderer(this,  84, 0);
		Mouth = new ModelRenderer(this,  0, 77);
		Tail = new ModelRenderer(this,  102, 41);
		TailTip = new ModelRenderer(this,  82, 45);
		Neck = new ModelRenderer(this,  52, 0);
		Head = new ModelRenderer(this,  44, 21);
		Jaw = new ModelRenderer(this,  0, 64);
		RThumb = new ModelRenderer(this,  0, 102);
		RArm = new ModelRenderer(this,  12, 90);
		RClaw = new ModelRenderer(this,  0, 110);
		LArm = new ModelRenderer(this,  12, 90);
		LThumb = new ModelRenderer(this,  0, 102);
		LClaw = new ModelRenderer(this,  0, 110);
		Back = new ModelRenderer(this,  108, 64);

		Lthigh.field_78809_i = true;

		Lthigh.func_78789_a(-1.0F, -2.0F, -4.0F, 5, 11, 9);
		Lthigh.func_78793_a(4.0F, 2.0F, 0.0F);
		Lthigh.func_78787_b(128, 128);
		Lthigh.field_78809_i = true;
		setRotation(Lthigh, 0.0F, 0.0F, 0.0F);
		Lthigh.field_78809_i = false;
		LToe2.field_78809_i = true;

		LToe2.func_78789_a(2.5F, 19.0F, -8.0F, 3, 3, 6);
		LToe2.func_78793_a(4.0F, 2.0F, 0.0F);
		LToe2.func_78787_b(128, 128);
		LToe2.field_78809_i = true;
		setRotation(LToe2, 0.0F, 0.0F, 0.0F);
		LToe2.field_78809_i = false;
		Lleg.field_78809_i = true;

		Lleg.func_78789_a(2.0F, 9.0F, 1.0F, 4, 9, 5);
		Lleg.func_78793_a(3.0F, 2.0F, 0.0F);
		Lleg.func_78787_b(128, 128);
		Lleg.field_78809_i = true;
		setRotation(Lleg, 0.0F, 0.0F, 0.0F);
		Lleg.field_78809_i = false;
		LFoot.field_78809_i = true;

		LFoot.func_78789_a(-0.5F, 18.0F, -2.0F, 5, 4, 8);
		LFoot.func_78793_a(4.0F, 2.0F, 0.0F);
		LFoot.func_78787_b(128, 128);
		LFoot.field_78809_i = true;
		setRotation(LFoot, 0.0F, 0.0F, 0.0F);
		LFoot.field_78809_i = false;
		LToe1.field_78809_i = true;

		LToe1.func_78789_a(-1.5F, 19.0F, -8.0F, 3, 3, 6);
		LToe1.func_78793_a(4.0F, 2.0F, 0.0F);
		LToe1.func_78787_b(128, 128);
		LToe1.field_78809_i = true;
		setRotation(LToe1, 0.0F, 0.0F, 0.0F);
		LToe1.field_78809_i = false;

		Rthigh.func_78789_a(-5.0F, -2.0F, -4.0F, 5, 11, 9);
		Rthigh.func_78793_a(-4.0F, 2.0F, 0.0F);
		Rthigh.func_78787_b(128, 128);
		Rthigh.field_78809_i = true;
		setRotation(Rthigh, 0.0F, 0.0F, 0.0F);

		RToe2.func_78789_a(-1.5F, 19.0F, -8.0F, 3, 3, 6);
		RToe2.func_78793_a(-4.0F, 2.0F, 0.0F);
		RToe2.func_78787_b(128, 128);
		RToe2.field_78809_i = true;
		setRotation(RToe2, 0.0F, 0.0F, 0.0F);

		Rleg.func_78789_a(-4.0F, 9.0F, 1.0F, 4, 9, 5);
		Rleg.func_78793_a(-6.0F, 2.0F, 0.0F);
		Rleg.func_78787_b(128, 128);
		Rleg.field_78809_i = true;
		setRotation(Rleg, 0.0F, 0.0F, 0.0F);

		RFoot.func_78789_a(-4.5F, 18.0F, -2.0F, 5, 4, 8);
		RFoot.func_78793_a(-4.0F, 2.0F, 0.0F);
		RFoot.func_78787_b(128, 128);
		RFoot.field_78809_i = true;
		setRotation(RFoot, 0.0F, 0.0F, 0.0F);

		RToe1.func_78789_a(-5.5F, 19.0F, -8.0F, 3, 3, 6);
		RToe1.func_78793_a(-4.0F, 2.0F, 0.0F);
		RToe1.func_78787_b(128, 128);
		RToe1.field_78809_i = true;
		setRotation(RToe1, 0.0F, 0.0F, 0.0F);

		TailEnd.func_78789_a(-1.0F, 30.0F, -18.0F, 2, 15, 4);
		TailEnd.func_78793_a(0.0F, 2.0F, 0.0F);
		TailEnd.func_78787_b(128, 128);
		TailEnd.field_78809_i = true;
		setRotation(TailEnd, 1.570796F, 0.0F, 0.0F);

		Belly.func_78789_a(-4.0F, -10.0F, -7.0F, 8, 21, 2);
		Belly.func_78793_a(0.0F, 2.0F, 0.0F);
		Belly.func_78787_b(128, 128);
		Belly.field_78809_i = true;
		setRotation(Belly, 0.8726646F, 0.0F, 0.0F);

		Body.func_78789_a(-5.0F, -12.0F, -5.0F, 10, 25, 12);
		Body.func_78793_a(0.0F, 2.0F, 0.0F);
		Body.func_78787_b(128, 128);
		Body.field_78809_i = true;
		setRotation(Body, 0.8726646F, 0.0F, 0.0F);

		Mouth.func_78789_a(-3.0F, -2.0F, -14.0F, 6, 4, 9);
		Mouth.func_78793_a(0.0F, -10.0F, -16.0F);
		Mouth.func_78787_b(128, 128);
		Mouth.field_78809_i = true;
		setRotation(Mouth, 0.0F, 0.0F, 0.0F);

		Tail.func_78789_a(-2.0F, 8.0F, -8.0F, 4, 14, 9);
		Tail.func_78793_a(0.0F, 2.0F, 0.0F);
		Tail.func_78787_b(128, 128);
		Tail.field_78809_i = true;
		setRotation(Tail, 1.22173F, 0.0F, 0.0F);

		TailTip.func_78789_a(-1.5F, 22.0F, -8.0F, 3, 12, 7);
		TailTip.func_78793_a(0.0F, 2.0F, 0.0F);
		TailTip.func_78787_b(128, 128);
		TailTip.field_78809_i = true;
		setRotation(TailTip, 1.22173F, 0.0F, 0.0F);

		Neck.func_78789_a(-2.0F, -20.0F, 2.0F, 4, 11, 8);
		Neck.func_78793_a(0.0F, 2.0F, 0.0F);
		Neck.func_78787_b(128, 128);
		Neck.field_78809_i = true;
		setRotation(Neck, 1.22173F, 0.0F, 0.0F);

		Head.func_78789_a(-3.0F, -6.0F, -6.0F, 6, 10, 9);
		Head.func_78793_a(0.0F, -10.0F, -16.0F);
		Head.func_78787_b(128, 128);
		Head.field_78809_i = true;
		setRotation(Head, 0.0F, 0.0F, 0.0F);

		Jaw.func_78789_a(-2.0F, 2.0F, -12.0F, 4, 2, 7);
		Jaw.func_78793_a(0.0F, -10.0F, -16.0F);
		Jaw.func_78787_b(128, 128);
		Jaw.field_78809_i = true;
		setRotation(Jaw, 0.0F, 0.0F, 0.0F);

		RThumb.func_78789_a(0.0F, 6.0F, -4.0F, 2, 5, 2);
		RThumb.func_78793_a(-3.0F, 5.0F, -9.0F);
		RThumb.func_78787_b(128, 128);
		RThumb.field_78809_i = true;
		setRotation(RThumb, 0.0F, 0.0F, 0.0F);

		RArm.func_78789_a(-2.0F, -2.0F, -2.0F, 3, 9, 3);
		RArm.func_78793_a(-3.0F, 5.0F, -9.0F);
		RArm.func_78787_b(128, 128);
		RArm.field_78809_i = true;
		setRotation(RArm, -0.418879F, 0.0F, 0.0F);

		RClaw.func_78789_a(-3.0F, 6.0F, -4.0F, 2, 6, 2);
		RClaw.func_78793_a(-3.0F, 5.0F, -9.0F);
		RClaw.func_78787_b(128, 128);
		RClaw.field_78809_i = true;
		setRotation(RClaw, 0.0F, 0.0F, 0.0F);
		LArm.field_78809_i = true;

		LArm.func_78789_a(-1.0F, -2.0F, -2.0F, 3, 9, 3);
		LArm.func_78793_a(3.0F, 5.0F, -9.0F);
		LArm.func_78787_b(128, 128);
		LArm.field_78809_i = true;
		setRotation(LArm, -0.418879F, 0.0F, 0.0F);
		LArm.field_78809_i = false;
		LThumb.field_78809_i = true;

		LThumb.func_78789_a(-2.0F, 6.0F, -4.0F, 2, 5, 2);
		LThumb.func_78793_a(3.0F, 5.0F, -9.0F);
		LThumb.func_78787_b(128, 128);
		LThumb.field_78809_i = true;
		setRotation(LThumb, 0.0F, 0.0F, 0.0F);
		LThumb.field_78809_i = false;
		LClaw.field_78809_i = true;

		LClaw.func_78789_a(1.0F, 6.0F, -4.0F, 2, 6, 2);
		LClaw.func_78793_a(3.0F, 5.0F, -9.0F);
		LClaw.func_78787_b(128, 128);
		LClaw.field_78809_i = true;
		setRotation(LClaw, 0.0F, 0.0F, 0.0F);
		LClaw.field_78809_i = false;

		Back.func_78789_a(-4.0F, -12.0F, 7.0F, 8, 25, 2);
		Back.func_78793_a(0.0F, 2.0F, 0.0F);
		Back.func_78787_b(128, 128);
		Back.field_78809_i = true;
		setRotation(Back, 0.8726646F, 0.0F, 0.0F);
	}

	public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		setRotationAngles(f, f1, f2, f3, f4, f5, (EntityDrake)entity);
		Lthigh.func_78785_a(f5);
		LToe2.func_78785_a(f5);
		Lleg.func_78785_a(f5);
		LFoot.func_78785_a(f5);
		LToe1.func_78785_a(f5);
		Rthigh.func_78785_a(f5);
		RToe2.func_78785_a(f5);
		Rleg.func_78785_a(f5);
		RFoot.func_78785_a(f5);
		RToe1.func_78785_a(f5);
		TailEnd.func_78785_a(f5);
		Belly.func_78785_a(f5);
		Body.func_78785_a(f5);
		Mouth.func_78785_a(f5);
		Tail.func_78785_a(f5);
		TailTip.func_78785_a(f5);
		Neck.func_78785_a(f5);
		Head.func_78785_a(f5);
		Jaw.func_78785_a(f5);
		RThumb.func_78785_a(f5);
		RArm.func_78785_a(f5);
		RClaw.func_78785_a(f5);
		LArm.func_78785_a(f5);
		LThumb.func_78785_a(f5);
		LClaw.func_78785_a(f5);
		Back.func_78785_a(f5);
	}

	
	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	

	public void setRotationAngles(float f, float f1, float f2, 
				float f3, float f4, float f5, EntityLiving /*EntityDrake*/ entity) {
		float headX = this.swingProgress; // What is this really supposed to be
		/*float mouth = (float)Math.toRadians(entity.getMouthAngle());
		float tailY = (float)Math.toRadians(entity.getTailYAngle());
		float tailY1 = (float)Math.toRadians(entity.getTailYAngle());
		float tailY2 = (float)Math.toRadians(entity.getTailYAngle());*/
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Rthigh.field_78795_f = (Rleg.field_78795_f = RFoot.field_78795_f = RToe1.field_78795_f = RToe2.field_78795_f = field_78123_h.field_78795_f);
		Lthigh.field_78795_f = (Lleg.field_78795_f = LFoot.field_78795_f = LToe1.field_78795_f = LToe2.field_78795_f = field_78124_i.field_78795_f);

		Head.field_78795_f = headX;
		Mouth.field_78795_f = (headX - mouth);
		Jaw.field_78795_f = (headX + mouth);

		Head.field_78796_g = (Mouth.field_78796_g = Jaw.field_78796_g = field_78116_c.field_78796_g);

		if (tailY < -6.0F)
			tailY = -6.0F;
		if (tailY > 6.0F)
			tailY = 6.0F;
		if (tailY1 < -12.0F)
			tailY1 = -12.0F;
		if (tailY1 > 12.0F)
			tailY1 = 12.0F;
		Tail.field_78796_g = tailY;
		TailEnd.field_78796_g = tailY1;
		TailTip.field_78796_g = tailY2;

		if (entity.scratchTime > 0) {
			float armS = 30.0F - (float)Math.toRadians(entity.getScratchForDisplay());
			Head.field_78796_g = (Mouth.field_78796_g = Jaw.field_78796_g = (float)Math.toRadians(0.0D));
			Head.field_78795_f = (Mouth.field_78795_f = Jaw.field_78795_f = (float)Math.toRadians(90.0D));
			RArm.field_78795_f = (RClaw.field_78795_f = RThumb.field_78795_f = armS);
		} else {
			RArm.field_78795_f = -0.418879F;
			RClaw.field_78795_f = (RThumb.field_78795_f = 0.0F);
		}
	}
}

