package me.sharpjaws.sharpSK.hooks.mcMMO;

import javax.annotation.Nullable;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import com.gmail.nossr50.api.ExperienceAPI;
import com.gmail.nossr50.datatypes.skills.SkillType;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

public class ExprmcMMOSkillLevelReXP extends SimpleExpression<Integer> {
	private Expression<Player> p;
	private Expression<SkillType> s;
	@Override
	public Class<? extends Integer> getReturnType() {
		return Integer.class;
	}

	@Override
	public boolean isSingle() {
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] expr, int arg1, Kleenean arg2, ParseResult arg3) {
		s = (Expression<SkillType>) expr[0];
		p = (Expression<Player>) expr[1];
		return true;
	}

	@Override
	public String toString(@Nullable Event arg0, boolean arg1) {
		return "[sharpsk] [mcmmo] remaining %skilltype% [e]xp[erience] of %player%";
	}

	@Override
	@Nullable
	protected Integer[] get(Event e) {
		return new Integer[] {ExperienceAPI.getXPRemaining(p.getSingle(e), s.getSingle(e).toString())};
	}

}
