package me.sharpjaws.sharpSK;

import javax.annotation.Nullable;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class CondPlayerIsStandingOn extends Condition {
	private Expression<Entity> entity;
	private Expression<Block> block;

	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] expr, int matchedPattern, Kleenean arg2, SkriptParser.ParseResult arg3) {
		entity = (Expression<Entity>) expr[0];
		block = (Expression<Block>) expr[1];
		return true;
	}

	@Override
	public String toString(@Nullable Event e, boolean debug) {
		return "%entity% is standing on %itemstack%";
	}

	@Override
	public boolean check(Event e) {
		Block mb = entity.getSingle(e).getLocation().getBlock().getRelative(BlockFace.DOWN);
		Boolean check;
		if (mb == block.getSingle(e)){
			check = true;
		}else{
			check = false;
		}
		
		return true;
	}
}
