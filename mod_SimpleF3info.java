package net.minecraft.src;

import net.minecraft.client.Minecraft;

import org.lwjgl.opengl.GL11;

public class mod_SimpleF3info extends BaseMod {
	
	public String Version() {
		return "2.0";
	}

	public void ModsLoaded() {
		ModLoader.SetInGameHook(this, true, false);		
	}

	public boolean OnTickInGame(Minecraft minecraft1) {
		if(minecraft1.gameSettings.showDebugInfo) {
			int playerx = MathHelper.floor_double(minecraft1.thePlayer.posX);
			int playery = MathHelper.floor_double(minecraft1.thePlayer.posY);
			int playerz = MathHelper.floor_double(minecraft1.thePlayer.posZ);
			int playerchunkx = playerx >> 4;
			int playerchunkz = playerz >> 4;
			long day = minecraft1.theWorld.getWorldTime() / 24000L;
			String biome = minecraft1.theWorld.getWorldChunkManager().getBiomeGenAt(playerx, playerz).biomeName;
			float rawHour = (minecraft1.theWorld.getCelestialAngle(1.0F) * 24.0F + 12.0F) % 24.0F;
			int hour = MathHelper.floor_float(rawHour);
			int min = MathHelper.floor_float(rawHour * 60F) - hour * 60;
			minecraft1.fontRenderer.drawStringWithShadow("Light level: " + minecraft1.thePlayer.worldObj.getBlockLightValue(playerx, playery, playerz), 2, 96, 14737632);
			minecraft1.fontRenderer.drawStringWithShadow("Biome: " + biome, 2, 104, 14737632);
			minecraft1.fontRenderer.drawStringWithShadow("Seed: " + minecraft1.theWorld.getRandomSeed(), 2, 112, 14737632);
			minecraft1.fontRenderer.drawStringWithShadow("Day: " + day, 2, 120, 14737632);
			minecraft1.fontRenderer.drawStringWithShadow("Time: " + String.format("%02d:%02d", new Object[]{hour, min}), 2, 128, 14737632);
 			minecraft1.fontRenderer.drawStringWithShadow("Chunk X: " + playerchunkx, 2, 136, 14737632);
 			minecraft1.fontRenderer.drawStringWithShadow("Chunk Z: " + playerchunkz, 2, 144, 14737632);
		}

		return true;
	}

	public String toString() {
		return "SimpleF3info Mod (v2.0 Update) ";
	}

}
